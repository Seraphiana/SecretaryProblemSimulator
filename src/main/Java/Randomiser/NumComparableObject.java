package Java.Randomiser;

import Java.Algorithm.AlgorithmBuilder.Token;

public class NumComparableObject extends ComparableObject<Double, NumComparableObject> {

    public <T extends Comparable> NumComparableObject(double i) {


        comparable =  i;
    }

    @Override
    public ComparableObject operateWith(Token currentOperation, NumComparableObject object) {
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
    public ComparableObject times(NumComparableObject object) {
        comparable = comparable *((double) object.comparable);
        return this;
    }

    @Override
    public ComparableObject subtract(NumComparableObject object) {
        comparable = comparable -((double) object.comparable);
        return this;
    }

    @Override
    public ComparableObject divide(NumComparableObject object) {
        comparable = comparable /((double) object.comparable);
        return this;
    }

    @Override
    public ComparableObject plus(NumComparableObject object) {
        comparable = comparable +((double) object.comparable);
        return this;
    }

    @Override
    public ComparableObject clone() {
        return new NumComparableObject(comparable);
    }

}
