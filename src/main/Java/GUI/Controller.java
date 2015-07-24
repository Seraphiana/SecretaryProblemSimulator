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

/**
 * Created by fmoon on 04/07/15.
 */
public class Controller {
    private RandomiserFactory randomiserFactory;
    private OracleFactoryImpl oracleFactory;
    private AlgorithmBuilder algorithmBuilder;
    private List errors;
    private ProjectConstants constants;
    private boolean running;
    private Randomiser randomSet;
    private Oracle oracle;

    public Controller() {
        randomiserFactory = new RandomiserFactoryImpl();
        oracleFactory = new OracleFactoryImpl();
        algorithmBuilder = new AlgorithmBuilder();
    }





    public String run(String[] buildData, String algChoice, String matroidChoice, String oracleType) {
        constants = new ProjectConstants();

        updateAll(buildData, algChoice, matroidChoice, oracleType);

        oracle = oracleFactory.makeOracle();
        Algorithm algorithm = algorithmBuilder.buildAlgorithm();
        randomSet = randomiserFactory.createRandomiser();
        running = true;

        for (int i = 0; i < randomSet.getSize(); i++) {

            if (!running) {
                break;
            }
            if(algorithm.consider(randomSet.getItem(), i)) {
                oracle.consider(randomSet.getItem());
            }
            randomSet.alert();
        }
        return oracle.solution();
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
        algorithmBuilder.update(algChoice, (int) (buildDataAsDoubles[0]* buildDataAsDoubles[5]));
    }

    public void stop() {
        running = false;
    }

    public ObservableList<String> getOracles() {
        List<String> oracles = new ArrayList<>();
        oracles.add("Select Solution Restriction");
        oracles.add("Single Candidate");
        return FXCollections.observableArrayList(oracles);
    }

    public ObservableList<String> getMatroids() {
        List<String> matroidChoices = new ArrayList<>();

        matroidChoices.add("Select Matroid Type");
        matroidChoices.add("Integer");

        return FXCollections.observableArrayList(matroidChoices);
    }

    public String getMatroid() {
        return randomSet.toString();
    }

    public String getOptimalSet() {
        return oracle.optimalSolution(randomSet.getMatroid());
    }
}



