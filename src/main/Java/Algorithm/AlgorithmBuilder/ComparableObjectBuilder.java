package Java.Algorithm.AlgorithmBuilder;

import Java.Constants.ProjectConstants;

/**
 * Created by fmoon on 01/09/15.
 */
public class ComparableObjectBuilder {

    public static ComparableObject createWith(Token value) {
        switch (value.token) {
            case ProjectConstants.INT:
                return new NumComparableObject(Double.parseDouble(value.sequence));
            case ProjectConstants.DOUBLE:
                return new NumComparableObject(Double.parseDouble(value.sequence));
            default:
                return null;
        }
    }

    public static ComparableObject createStub() {
        return new NumComparableObject(0d);
    }

    public static NumComparableObject createWith(double value) {
        return new NumComparableObject(value);
    }
}
