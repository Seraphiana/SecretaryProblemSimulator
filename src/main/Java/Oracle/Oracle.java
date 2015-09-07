package Java.Oracle;

import Java.Algorithm.AlgorithmBuilder.ComparableObject;

import java.util.List;
import java.util.Set;

public interface Oracle<T extends ComparableObject> {


    /*
     * necessary method
     * used to decide whether any given element is added to the solution
     * note that all elements that have made it to the oracle are already "added" by the algorithm
     *
     * as such, this should only not add elements if they break the matroid restrictions
     * eg. solution set size is already at the maximum permitted, or vectors not allowed to combine
     *
     * @param the element to be added to the solution
     */
    boolean consider(T value);

    /*
     * necessary method
     * simply returns the solution in the form of a string (for display purposes)
     *
     * might change the return type at some point,
     * potentially to a list of some sort of element with a method to get display information?
     */
    String solution();

    /*
     * optional method
     * should, in a similar vein to above, when given the entire list of elements, find the optimal solution
     * will be displayed in the GUI but otherwise unimportant
     *
     * feel free to stub it out if you're lazy
     *
     * @param a list of all candidates
     */
    String optimalSolution(List<T> matroid);
}
