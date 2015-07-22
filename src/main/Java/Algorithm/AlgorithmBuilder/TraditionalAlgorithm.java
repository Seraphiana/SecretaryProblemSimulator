package Java.Algorithm.AlgorithmBuilder;

/**
 * Created by fmoon on 19/07/15.
 */
public class TraditionalAlgorithm implements Algorithm {
    int cutOff;
    Comparable maximum;

    public TraditionalAlgorithm(int sampleSize) {
        cutOff = sampleSize / 2;
    }


    @Override
    public boolean consider(Comparable object, int index) {
        if (index==0) {
            maximum = object;
        }

        if (index<cutOff) {
            if (maximum.compareTo(object)<0) {
                maximum = object;
            }
        }

        if (index>=cutOff) {
            if (maximum.compareTo(object)<=0)
            return true;
        }


        return false;
    }
}
