package Java.Controller;

import Java.Algorithm.*;
import Java.GUI.GUIController;
import Java.Oracle.*;
import Java.Randomiser.*;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.collections.transformation.SortedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by seraphiana on 18/07/14.
 */
public class ModuleControllerImpl implements ModuleController {
    private SecretaryAlgorithm algorithm;
    private GUIController gui;
    private Randomiser randomiser;
    private Oracle crystalBall;
    private Comparable max;
    private String randomiserType;
    private RandomiserFactory randomiserFactory;
    private OracleFactory oracleFactory;
    private AlgorithmFactory algorithmFactory;
    private HashMap<String, SecretaryAlgorithm> algorithmHashMap;
    private String oracleType;
    private String algorithmName;
    private int[] buildData;

    public ModuleControllerImpl() {
        randomiserFactory = new RandomiserFactoryImpl();
        oracleFactory = new OracleFactoryImpl(this);
        algorithmFactory = new AlgorithmFactoryImpl(this);
    }



    @Override
    public String getRandomiserType() {
        return algorithm.getMatroidType();
    }


    @Override
    public int getIndexNumber() {
        return randomiser.getIndex();
    }

    @Override
    public Comparable getNext() {
        return randomiser.getItem();
    }

    @Override
    public Set<Comparable> getAlreadySeen() {
        return randomiser.getAlreadySeen();
    }

    @Override
    public boolean checkCandidate() {
        return crystalBall.consider(randomiser.getItem());
    }

    @Override
    public Set<Comparable> getSolution() {
        return randomiser.getSolution();
    }

    @Override
    public List<Comparable> getMatroidContents() {
        return randomiser.getMatroid();
    }

    @Override
    public Comparable getMaximum() {
        return max;
    }

    @Override
    public ObservableList<SecretaryAlgorithm> getAlgChoice() {

        return new SortedList<>(new ObservableListBase<SecretaryAlgorithm>() {
            private LinkedList<SecretaryAlgorithm> algorithmList = new LinkedList<>(algorithmHashMap.values());

            @Override
            public SecretaryAlgorithm get(int index) {
                return algorithmList.get(index);
            }

            @Override
            public int size() {
                return algorithmList.size();
            }
        });
    }

    @Override
    public SecretaryAlgorithm getAlgorithmName(String s) {
        return algorithmHashMap.get(s);
    }

    @Override
    public boolean update() {
        randomiserFactory.update(randomiserType, buildData);
        crystalBall = oracleFactory.makeOracle(oracleType);
        algorithm = algorithmFactory.createAlgorithm(algorithmName);
        return true;
    }

    private void initialise(String algorithm, String oracle, String objectType, int[] buildData) {
        randomiserType = objectType;
        this.buildData = buildData;
        this.algorithm = algorithmFactory.createAlgorithm(algorithm);
        this.crystalBall = oracleFactory.makeOracle(oracle);
        this.randomiser = randomiserFactory.createRandomiser();
    }
}
