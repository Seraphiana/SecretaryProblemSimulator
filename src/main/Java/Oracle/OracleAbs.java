package Java.Oracle;

import Java.Controller.ModuleController;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by seraphiana on 17/07/14.
 */
public abstract class OracleAbs<T> implements Oracle<T> {

    private final ModuleController controller;
    private Set<T> solutionSet;

    public OracleAbs(ModuleController controller) {
        this.solutionSet = new HashSet<T>();;
        this.controller = controller;
    }

    protected ModuleController getController() {
        return controller;
    }

    @Override
    public void addValue(T candidate) {
        solutionSet.add(candidate);
    }

    @Override
    public Set<T> getSolution() {
        return solutionSet;
    }
}
