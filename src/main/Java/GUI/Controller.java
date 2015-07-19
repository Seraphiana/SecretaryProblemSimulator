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

    public Controller() {
        randomiserFactory = new RandomiserFactoryImpl();
        oracleFactory = new OracleFactoryImpl();
        algorithmBuilder = new AlgorithmBuilder();


    }


    public ObservableList<String> getMatroids() {
        List<String> matroidChoices = new ArrayList<>();

        matroidChoices.add("Select Matroid Type");
        matroidChoices.add("Integer");

        return FXCollections.observableArrayList(matroidChoices);
    }


    public String run(String[] buildData, String algChoice, String matroidChoice, String oracleType) {
        constants = new ProjectConstants();
        updateAll(buildData, algChoice, matroidChoice, oracleType);
        Oracle oracle = oracleFactory.makeOracle();
        Algorithm algorithm = algorithmBuilder.buildAlgorithm();
        Randomiser randomSet = randomiserFactory.createRandomiser();
        running = true;

        for (int i = 0; i < randomSet.getSize(); i++) {
            if (!running) {
                break;
            }
            if(algorithm.consider()) {
                oracle.consider(randomSet.getItem());
            }
        }
        return oracle.solution();
    }

    private void updateAll(String[] buildData, String algChoice, String matroidChoice, String oracleType) {
        long[] buildDataAsLongs = new long[buildData.length];
        int index = 0;
        for (int i = 0; i < buildData.length; i++) {
            try {
                buildDataAsLongs[index] = Long.parseLong(buildData[i]);
            } catch (NumberFormatException e) {
                errors.add("invalid input in field" + i);
            }
        }

        randomiserFactory.update(matroidChoice, buildDataAsLongs);
        oracleFactory.update(oracleType);
        algorithmBuilder.update(algChoice);
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
}



