package algorithm;

import matroidFactory.Matroid;

import java.util.Set;

/**
 * Created by Fliss on 30/06/14.
 */
public interface Algorithm {

    /*
     * needs thought, this is a pretty simple version, I guess
     * takes a variable and returns true if it should be added to the solution set
     * false otherwise
     * seems a lot more sensible than doing it all at once in the long term
     * moves more stuff to the controller, unfortunately, but its gonna need to be there to make it to the view
     * might want some sort of creational pattern to make this easier on end users
     * but that's low priority? I guess? and adding some sort of factory/builder later should be simple enough.
     */
    public boolean consider(int val, Set answerSet, Matroid opMatroid);

    /*
     * returns the string name for the type of matroid it needs to run.
     */
    public String matroidType();
}
