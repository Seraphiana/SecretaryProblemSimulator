package Java.Randomiser;

import Java.Algorithm.AlgorithmBuilder.ComparableObject;

import java.util.List;
import java.util.Set;

/**
 * Created by Fliss on 04/07/14.
 */
public interface Randomiser<T extends ComparableObject> {

    T getItem();

    List<T> getMatroid();

    void itemDecision(boolean answer);

    Set<T> getSolution();

    void alert();

    int getIndex();

    List<T> getAlreadySeen();

    int getSize();

    String toString();
}
