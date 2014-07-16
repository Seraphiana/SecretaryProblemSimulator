package Randomiser;

import java.util.List;

/**
 * Created by Fliss on 04/07/14.
 */
public interface Randomiser<T extends Comparable> {

    T getItem();

    List<T> getMatroid();

    void alert();
}
