package Java.Randomiser;

import java.util.List;
import java.util.Set;

/**
 * Created by Fliss on 04/07/14.
 */
public interface Randomiser<T extends Comparable<T>> {

    T getItem();

    List<T> getMatroid();

    void itemDecision(boolean answer);

    Set<T> getSolution();

    int getIndex();

    Set<T> getAlreadySeen();

    int getSize();
}
