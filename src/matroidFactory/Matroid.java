package matroidFactory;

import java.util.List;
import java.util.Set;

/**
 * Created by Fliss on 30/06/14.
 */
public interface Matroid {

    /*
     * Data structure that represents a matroid
     * so, its going to be a set of sets of ints, I guess?
     * with some additional restrictions
     * need a subclass for different kinds
     * they'll just add new restrictions pretty much
     */

    /*
     * returns true if adding the given value to the given set would be permissible by the matroid's rules
     */
    boolean permissible(int val, Set solutionSet);




    /*
     * returns the list of individual elements in the matroid
     * for use by the controller as it processes each element, randomised elsewhere?
     */
    List getList();
}
