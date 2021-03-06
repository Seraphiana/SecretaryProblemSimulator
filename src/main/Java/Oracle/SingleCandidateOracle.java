package Java.Oracle;


import Java.Randomiser.ComparableObject;

import java.util.ArrayList;
import java.util.List;

public class SingleCandidateOracle<T extends ComparableObject> implements Oracle<T> {
    private ArrayList<T> solution;
    private T maximum;

    private SingleCandidateOracle() {

        solution = new ArrayList<>();
    }

    public static SingleCandidateOracle createSingleCandidateOracle() {
        return new SingleCandidateOracle();
    }

    @Override
    public boolean consider(T obj) {

        if (solution.isEmpty()) {
            solution.add(obj);

            return true;
        } else return false;
    }

    @Override
    public String solution() {
        String result = solution.toString();
        return result.substring(1, result.length()-1);
    }

    @Override
    public String optimalSolution(List<T> objects) {
        for (T object : objects) {
            if (maximum==null){
                maximum=object;
            } else if (maximum.compareTo(object)<0) {
                maximum=object;
            }
        }

        return maximum.toString();
    }


}
