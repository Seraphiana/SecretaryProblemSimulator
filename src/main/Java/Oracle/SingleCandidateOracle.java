package Java.Oracle;


import Java.Controller.ModuleController;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fliss on 04/07/14.
 */
public class SingleCandidateOracle<T> implements Oracle<T> {

    private ModuleController controller;
    private Set<T> SolutionSet;

    public SingleCandidateOracle(ModuleController controller) {
        this.controller = controller;
        SolutionSet = new HashSet<T>();
    }

    @Override
    public boolean consider(T value) {
        return SolutionSet.isEmpty();
    }

    @Override
    public void addValue(T candidate) {
        SolutionSet.add(candidate);
    }

    @Override
    public Set<T> getSolution() {
        return SolutionSet;
    }

}
