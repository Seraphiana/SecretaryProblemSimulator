package Java.Algorithm.AlgorithmBuilder;

/**
 * Created by fmoon on 21/08/15.
 */
public class NumComparableObject extends ComparableObject {

    public <T extends Comparable> NumComparableObject(T i) {


        comparable = i;
    }

    @Override
    public ComparableObject operateWith(Token currentOperation, ComparableObject object) {
        switch (currentOperation.sequence) {
            case "+":
                return this.plus(object);
            case "-":
                return this.subtract(object);
            case "*":
                return this.times(object);
            case "/":
                return this.divide(object);
            default:
                return this;
        }

    }

    @Override
    public ComparableObject times(ComparableObject object) {
        comparable = ((double) comparable)*((double) object.comparable);
        return this;
    }

    @Override
    public ComparableObject subtract(ComparableObject object) {
        comparable = ((double) comparable)-((double) object.comparable);
        return this;
    }

    @Override
    public ComparableObject divide(ComparableObject object) {
        comparable = ((double) comparable)/((double) object.comparable);
        return this;
    }

    @Override
    public ComparableObject plus(ComparableObject object) {
        comparable = ((double) comparable)*((double) object.comparable);
        return this;
    }

    @Override
    public ComparableObject clone() {
        return new NumComparableObject(comparable);
    }

}
