package Java.Algorithm.AlgorithmBuilder;

/**
 * Created by fmoon on 19/08/15.
 */
public abstract class ComparableObject <T extends Comparable, S extends ComparableObject> implements Comparable<ComparableObject> {
    protected T comparable;

    @Override
    public int compareTo(ComparableObject o) {
        return comparable.compareTo(o.comparable);
    }

    public static ComparableObject createNew() {
        return ComparableObjectBuilder.createStub();
    }

    public static ComparableObject createNew(Token value) {
        return ComparableObjectBuilder.createWith(value);
    }

    public static ComparableObject createNew(double i) {
        return new NumComparableObject(i);
    }

    public abstract ComparableObject operateWith(Token currentOperation, S object);
    public abstract ComparableObject times(S object);
    public abstract ComparableObject subtract(S object);
    public abstract ComparableObject divide(S object);
    public abstract ComparableObject plus(S object);

    public abstract ComparableObject clone();
}
