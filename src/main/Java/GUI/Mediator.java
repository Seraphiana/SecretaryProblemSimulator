package Java.GUI;

import Java.Algorithm.AlgorithmBuilder.Algorithm;
import Java.Algorithm.AlgorithmBuilder.AlgorithmBuilder;
import Java.Constants.ProjectConstants;
import Java.Oracle.Oracle;
import Java.Oracle.OracleFactoryImpl;
import Java.Randomiser.Randomiser;
import Java.Randomiser.RandomiserFactory;
import Java.Randomiser.RandomiserFactoryImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    private RandomiserFactory randomiserFactory;
    private OracleFactoryImpl oracleFactory;
    private AlgorithmBuilder algorithmBuilder;
    private List errors;
    private ProjectConstants constants;
    private boolean running;
    private Randomiser randomSet;
    private Oracle oracle;

    public Mediator() {
        randomiserFactory = new RandomiserFactoryImpl();
        oracleFactory = new OracleFactoryImpl();
        algorithmBuilder = new AlgorithmBuilder();
    }


    public String run(String[] buildData, String algChoice, String matroidChoice, String oracleType) {
        running = true;
        constants = new ProjectConstants();

        updateAll(buildData, algChoice, matroidChoice, oracleType);
        String errors = getErrors(algChoice, matroidChoice, oracleType);
        if (errors != null) return errors;

        oracle = oracleFactory.makeOracle();
        Algorithm algorithm = algorithmBuilder.buildAlgorithm();
        randomSet = randomiserFactory.createRandomiser();
        if (!running) {
            return "";
        }

        for (int i = 0; i < randomSet.getSize(); i++) {

            if (!running) {
                return "";
            }
            if (algorithm.consider(randomSet.getItem(), i)) {
                oracle.consider(randomSet.getItem());
            }
            randomSet.alert();
        }
        return oracle.solution();
    }

    public void stop() {
        running = false;
    }

    public ObservableList<String> getOracles() {
        List<String> oracles = new ArrayList<>();
        oracles.add(ProjectConstants.SINGLECANDIDATE);
        return FXCollections.observableArrayList(oracles);
    }

    public ObservableList<String> getMatroids() {
        List<String> matroidChoices = new ArrayList<>();

        matroidChoices.add(ProjectConstants.INTEGER);

        return FXCollections.observableArrayList(matroidChoices);
    }

    private String getErrors(String algChoice, String matroidChoice, String oracleType) {
        String[] error = new String[] {"", "", ""};
        boolean runFailed = false;
        if (algChoice.length()==0) {
            error[0] = "an algorithm,\r";
            runFailed = true;
        }
        if (matroidChoice==null) {
            runFailed = matroidIsRunFailed(error);
        }
        else if (matroidChoice.length()==0) {
            runFailed = matroidIsRunFailed(error);
        }
        if (oracleType==null) {
            runFailed = oracleIsRunFailed(error);
        }
        else if (oracleType.length()==0) {
            runFailed = oracleIsRunFailed(error);
        }
        if (runFailed) {
            return ("You must select\r" + error[0]  + error[1]  + error[2] +  "to run.");
        }
        return null;
    }

    private boolean matroidIsRunFailed(String[] error) {
        boolean runFailed;
        error[1] = "a matroid, \r";
        runFailed = true;
        return runFailed;
    }

    private boolean oracleIsRunFailed(String[] error) {
        boolean runFailed;
        error[2] = "an oracleType,\r";
        runFailed = true;
        return runFailed;
    }

    private void updateAll(String[] buildData, String algChoice, String matroidChoice, String oracleType) {
        double[] buildDataAsDoubles = new double[buildData.length];
        int index = 0;
        for (int i = 0; i < buildData.length; i++) {
            try {
                buildDataAsDoubles[index] = Double.parseDouble(buildData[i]);
                index++;
            } catch (NumberFormatException e) {
                errors.add("invalid input in field" + i);
            }
        }
        randomiserFactory.update(matroidChoice, buildDataAsDoubles);
        oracleFactory.update(oracleType);
        algorithmBuilder.update(algChoice, (int) (buildDataAsDoubles[0] * buildDataAsDoubles[5]));
    }

    public String getMatroid() {
        if (randomSet==null) {
            return "";
        }

        return randomSet.toString();
    }

    public String getOptimalSet() {
        if (oracle==null || randomSet==null) {
            return "";
        }
        return oracle.optimalSolution(randomSet.getMatroid());
    }
}



