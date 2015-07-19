package Java.Oracle;


import java.util.ArrayList;

/**
 * Created by Fliss on 04/07/14.
 */
public class SingleCandidateOracle<T extends Comparable> implements Oracle<T> {
    ArrayList<T> solution;

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
        return solution.toString();
    }


}
