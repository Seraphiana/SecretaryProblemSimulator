package Java.Randomiser;

public class ComparableVector implements Comparable {

    protected final double magnitude;
    private final int direction;

    public ComparableVector(double magnitude, int direction) {

        this.magnitude = magnitude;
        this.direction = direction;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 0;
        }
        if (o.getClass() != ComparableVector.class) {
            return 0;
        }
        ComparableVector compare = (ComparableVector) o;
        if (magnitude > compare.magnitude) {
            return 1;
        }
        if (magnitude < compare.magnitude) {
            return -1;
        }
        return 0;
    }

    public ComparableVector plus(ComparableVector vectorB) {
        double x = magnitude * Math.cos(Math.toRadians(direction));
        double y = magnitude * Math.sin(Math.toRadians(direction));
        x += vectorB.magnitude * Math.cos(Math.toRadians(vectorB.direction));
        y += vectorB.magnitude * Math.sin(Math.toRadians(vectorB.direction));
        double newMagnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        int newDirection;
        newDirection = getDirection(x, y);
        return new ComparableVector(newMagnitude, newDirection);
    }

    private int getDirection(double x, double y) {
        if (y < 0 && x < 0) {
            return (int) (180 + Math.toDegrees(Math.atan(Math.abs(y) / Math.abs(x))));
        }
        if (y < 0 && x > 0) {
            return (int) (360-Math.toDegrees(Math.atan(Math.abs(y) / Math.abs(x))));
        }
        if (y > 0 && x < 0) {
            return (int) (180-Math.toDegrees(Math.atan(Math.abs(y) / Math.abs(x))));
        }
        if (y > 0 && x > 0) {
            return (int) Math.toDegrees(Math.atan(Math.abs(y) / Math.abs(x)));
        }

        return (int) Math.toDegrees(Math.asin(x / y));
    }

    public double dotProduct(ComparableVector vectorB) {
        double angle = ((Math.abs(vectorB.direction - direction)));
        double angleInRadians = (angle / 180) * Math.PI;
        return Math.round(magnitude * vectorB.magnitude * Math.cos(angleInRadians));
    }


    public int direction() {
        return direction;
    }

    public double magnitude() {
        return magnitude;
    }
}
