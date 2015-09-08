package Java.Randomiser;

import java.util.List;
import java.util.Set;

public interface Randomiser<T extends ComparableObject> {

    T getItem();

    List<T> getMatroid();

    void itemDecision(boolean answer);

    List<T> getSolution();

    void alert();

    int getIndex();

    List<T> getAlreadySeen();

    int getSize();

    String toString();
}
