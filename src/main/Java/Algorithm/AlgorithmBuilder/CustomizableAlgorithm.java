package Java.Algorithm.AlgorithmBuilder;

import Java.Randomiser.ComparableObject;

import java.util.List;

public class CustomizableAlgorithm<T extends ComparableObject> implements Algorithm<T> {
    private List<IfClause> ifClauses;
    private int cutOffIndex;
    private T maxSeen;


    private CustomizableAlgorithm(List<IfClause> ifClauses, CutoffClause cutOff, int sampleSize) {
        this.ifClauses = ifClauses;
        cutOffIndex = cutOff.calculateCutOff(sampleSize);
    }

    public static Algorithm createAlgorithm(List<IfClause> ifClauses, CutoffClause cutOff, int sampleSize) {

        return new CustomizableAlgorithm(ifClauses, cutOff, sampleSize);
    }

    @Override
    public boolean consider(T object, int index) {
        if (maxSeen == null) {
            maxSeen = object;
        } else if (object.compareTo(maxSeen)>0) {
            maxSeen = object;
        }

        if (index<cutOffIndex) {
            return false;
        }
        boolean passed = true;
        for (IfClause ifClause : ifClauses) {
            passed = ifClause.consider(object, maxSeen);
        }
        return passed;
    }
}
