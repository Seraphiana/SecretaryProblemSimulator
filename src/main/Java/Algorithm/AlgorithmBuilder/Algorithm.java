package Java.Algorithm.AlgorithmBuilder;

/**
 * Created by fmoon on 19/07/15.
 */
public interface Algorithm<T extends Comparable> {
    boolean consider(T object, int index);
}
