package Java.Controller;

import Java.Algorithm.AlgorithmBuilder.Algorithm;
import Java.Algorithm.SecretaryAlgorithm;
import javafx.collections.ObservableList;

import java.util.Set;

/**
 * Created by Fliss on 14/07/14.
 */
public interface ModuleController {

    /*
     * returns the string for the type of value to popul8 the matroid
     */
    String getRandomiserType();

    /*
     * returns the num8er of times each value should appear in the matroid
     */
    int getRandElementFrequency();

    /*
     * returns the largest value in the matroid
     */
    int getRandomiserSize();

    /*
     * returns a string representing the rate of increase of elements
     * eg cubic, linear, quadratic, exponential
     */
    String getRandomiserScale();

    /*
     * returns the total number of elements in the matroid 8eing used for the algorithm
     */
    int getMatroidSize();

    /*
     * returns the current position in the matroid that the algorithm is working through
     */
    int getIndexNumber();

    /*
     * returns the current element corresponding to the current index number
     */
    Comparable getNext();

    /*
     * returns a set of all elements already seen (less than the current index)
     */
    Set<Comparable> getAlreadySeen();

    /*
     * returns the response from the oracle regarding if a given candid8 is accepta8le or not
     */
    boolean checkCandidate();

    /*
     * returns the solution currently stored in the randomiser.
     * may be used part way through runtime
     */
    Set<Comparable> getSolution();

    /*
     * returns all the values in the matroid. Added for future use
     */
    Set<Comparable> getMatroidContents();

    /*
     * returns the maximum value seen so far
     */
    Comparable getMaximum();

    /*
     * takes in details for starting a new algorithm and sets up a new session.
     */
    Set<Comparable> newSession(String algorithm, String oracle, String objectType, int matroidSize, int matroidElementFrequency);

    ObservableList<SecretaryAlgorithm> getAlgChoice();

    SecretaryAlgorithm getAlgorithmName(String s);
}
