package Java.Oracle;

import Java.Randomiser.ComparableObject;
import Java.Randomiser.VectorCandidate;

import java.util.ArrayList;
import java.util.List;

public class LinearIndependenceOracle implements Oracle {

    private List solution;

    public LinearIndependenceOracle() {
        solution = new ArrayList();
    }

    @Override
    public boolean consider(ComparableObject value) {
        if (solution.size()==0) {
            solution.add(value);
            return true;
        }
        if (solution.size()>1) {
            return false;
        }
        if (value.getClass()== VectorCandidate.class) {
            VectorCandidate vectorA = (VectorCandidate) solution.get(0);
            VectorCandidate vectorB = (VectorCandidate) value;
            double angleDifference = Math.abs(vectorA.direction()-vectorB.direction());
            return (angleDifference>1);
        }
        return false;
    }

    @Override
    public String solution() {
        String result = "";
        for (Object comparableObject : solution) {
            result += comparableObject.toString() + ", ";
        }
        return result;
    }

    @Override
    public String optimalSolution(List matroid) {
        return "Functionality not implemented";
    }
}
