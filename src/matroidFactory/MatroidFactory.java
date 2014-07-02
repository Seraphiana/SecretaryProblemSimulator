package matroidFactory;

import java.util.Set;

/**
 * Created by Fliss on 30/06/14.
 */
public interface MatroidFactory {

    /*
     * makes matroids and gives them to the controller
     * make it a factoryMethod, and a singleton
     */

    /*
     * Takes a string for the matroid type, returns a 'standard' matroid normally
     * or if the string corresponds to one of the included types it builds a specific kind
     * throws exceptions if the sets aren't permitted by that kind of matroid.
     */
    Matroid createNewMatroid(String matroidType, int[] values, Set<int>[] sets) throws IllegalArgumentException;
}
