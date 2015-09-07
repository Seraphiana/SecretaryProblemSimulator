package Java.Algorithm.AlgorithmBuilder;

public interface Algorithm<T extends Comparable> {
    boolean consider(T object, int index);
}
