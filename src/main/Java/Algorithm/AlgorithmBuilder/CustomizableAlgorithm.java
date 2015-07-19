package Java.Algorithm.AlgorithmBuilder;

import java.util.List;

/**
 * Created by seraphiana on 22/04/15.
 */
public class CustomizableAlgorithm<T extends Comparable> implements Algorithm<T> {
    private List<IfClause> ifClauses;
    private CutoffClause cutOff;
    private int cutOffIndex;


    private CustomizableAlgorithm(List<IfClause> ifClauses, CutoffClause cutOff, int sampleSize) {
        this.cutOff=cutOff;
        this.ifClauses = ifClauses;
        cutOffIndex = calculateCutOff(sampleSize);
    }

    private int calculateCutOff(int sampleSize) {

        return cutOff.calculateCutOff(sampleSize);
    }

    public static Algorithm createAlgorithm(List<IfClause> ifClauses, CutoffClause cutOff, int sampleSize) {

        return new CustomizableAlgorithm(ifClauses, cutOff, sampleSize);
    }

    @Override
    public boolean consider(T object, int index) {
        if (index<cutOffIndex) {
            return false;
        }

        return false;
    }
}
