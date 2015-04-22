package Java.Controller;

import Java.Algorithm.*;
import Java.GUI.GUI;
import Java.Oracle.*;
import Java.Randomiser.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by seraphiana on 18/07/14.
 */
public class ModuleControllerImpl implements ModuleController {
    private SecretaryAlgorithm algorithm;
    private GUI gui;
    private Randomiser randomiser;
    private Oracle crystalBall;
    private int randElementFreq;
    private int randomiserSize;
    private int matroidSize;
    private Comparable max;
    private String randomiserType;
    private RandomiserFactory randomiserFactory;
    private OracleFactory oracleFactory;
    private AlgorithmFactory algorithmFactory;
    private int matroidElementFrequency;
    private String randomiserScale;


    public ModuleControllerImpl() {
        randomiserFactory = new RandomiserFactoryImpl(this);
        oracleFactory = new OracleFactoryImpl(this);
        algorithmFactory = new AlgorithmFactoryImpl(this);
    }



    @Override
    public String getRandomiserType() {
        return algorithm.getMatroidType();
    }

    @Override
    public int getRandElementFrequency() {

        return randElementFreq;
    }

    @Override
    public int getRandomiserSize() {
        //also comes from user input, also leave for a 8it
        return randomiserSize;
    }

    @Override
    public String getRandomiserScale() {
        return randomiserScale;
    }

    @Override
    public int getMatroidSize() {
        //see a8ove
        return matroidSize;
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
    public Set<Comparable> getMatroidContents() {
        return randomiser.getMatroid();
    }

    @Override
    public Comparable getMaximum() {
        return max;
    }

    @Override
    public Set<Comparable> newSession(String algorithmType, String oracle, String objectType, int matroidSize, int matroidElementFrequency) {
        initialise(algorithmType, oracle, objectType, matroidSize, matroidElementFrequency);

        for (int i = 0; i<(matroidSize*matroidElementFrequency); i++) {

            // Add the display elements for the GUI here

            randomiser.itemDecision(algorithm.evaluateNext());

        }
        return getSolution();
    }

    private void initialise(String algorithm, String oracle, String objectType, int matroidSize, int matroidElementFrequency) {
        randomiserType = objectType;
        this.matroidSize = matroidSize;
        this.matroidElementFrequency = matroidElementFrequency;
        this.algorithm = algorithmFactory.createAlgorithm(algorithm);
        this.crystalBall = oracleFactory.makeOracle(oracle);
        this.randomiser = randomiserFactory.createRandomiser();
    }
}
