package Java.Randomiser;

/**
 * Created by seraphiana on 17/07/14.
 */
public class SortingElement<T> {
    private T value;
    private int index;

    public SortingElement(T value, int index) {
        this.value = value;
        this.index = index;
    }

    public T getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

}
