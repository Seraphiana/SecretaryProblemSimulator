package Java.Controller;

import java.util.Set;

/**
 * Created by Fliss on 14/07/14.
 */
public interface ModuleController<T extends Comparable<T>> {

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
    T getNext();

    /*
     * returns a set of all elements already seen (less than the current index)
     */
    Set<T> getAlreadySeen();

    /*
     * returns the response from the oracle regarding if a given candid8 is accepta8le or not
     */
    boolean checkCandidate();

    /*
     * returns all the values in the matroid. Added for future use
     */
    Set<T> getMatroidContents();

    /*
     * returns the maximum value seen so far
     */
    T getMaximum();
}
