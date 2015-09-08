package Java.Randomiser;

import Java.Algorithm.AlgorithmBuilder.Token;

public class VectorCandidate extends ComparableObject {

    protected int direction;
    protected double magnitude;

    public VectorCandidate(ComparableVector comparable) {
        direction = comparable.direction();
        magnitude = comparable.magnitude();
        this.comparable = comparable;
    }

    public static VectorCandidate createFromString(String candidate) {
        candidate = candidate.substring(1, candidate.length() - 1);
        String[] data = candidate.split(",");
        double magnitude = Double.parseDouble(data[0]);
        int direction = Integer.parseInt(data[1]);
        return new VectorCandidate(magnitude, direction);
    }

    public VectorCandidate(double magnitude, int direction) {
        this.magnitude = magnitude;
        this.direction = direction % 360;
        comparable = new ComparableVector(magnitude, direction);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o.getClass() != VectorCandidate.class) {
            return false;
        }
        VectorCandidate object = (VectorCandidate) o;
        if (direction != object.direction || magnitude() != object.magnitude()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + ((int) magnitude) + "," + direction + "']";
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
        if (object.getClass() == NumComparableObject.class) {
            magnitude = magnitude * (double) object.comparable;
            comparable = new ComparableVector(magnitude, direction);
        } else if (object.getClass() == VectorCandidate.class) {
            VectorCandidate vectorB = (VectorCandidate) (object).clone();
            return ComparableObject.createNew(((ComparableVector) comparable).dotProduct((ComparableVector) vectorB.comparable));
        }
        return this;
    }

    @Override
    public ComparableObject subtract(ComparableObject object) {
        if (object.getClass() == VectorCandidate.class) {
            VectorCandidate vectorB = (VectorCandidate) object;
            return this.plus(new VectorCandidate(vectorB.magnitude, (vectorB.direction+180)%360));
        }
        return this;
    }

    @Override
    public ComparableObject divide(ComparableObject object) {
        return this;
    }

    @Override
    public ComparableObject plus(ComparableObject object) {
        if (object.getClass() == VectorCandidate.class) {
            VectorCandidate vectorB = (VectorCandidate) object;

            comparable = ((ComparableVector) comparable).plus((ComparableVector) vectorB.comparable);
            return new VectorCandidate((ComparableVector) comparable);
        }
        return this;
    }

    @Override
    public ComparableObject clone() {
        return new VectorCandidate(magnitude, direction);
    }

    public int magnitude() {
        return (int) magnitude;
    }

}
