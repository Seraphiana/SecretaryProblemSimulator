package Java.Algorithm.AlgorithmBuilder;

public abstract class ComparableObject <T extends Comparable, S extends ComparableObject> implements Comparable<ComparableObject> {
    protected T comparable;

    @Override
    public int compareTo(ComparableObject o) {
        return comparable.compareTo(o.comparable);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass()!=this.getClass()) {
            return false;
        }
        ComparableObject comp = (ComparableObject) o;
        if (comparable.equals(comp.comparable)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return comparable.toString();
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
