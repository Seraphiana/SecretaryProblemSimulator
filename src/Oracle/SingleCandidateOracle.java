package Oracle;

import Controller.ModuleController;
import Randomiser.Randomiser;

import java.util.Set;

/**
 * Created by Fliss on 04/07/14.
 */
public class SingleCandidateOracle implements Oracle {

    public SingleCandidateOracle(ModuleController controller) {

    }

    @Override
    public boolean consider(Object value) {
        return false;
    }

    @Override
    public void addValue(Object candidate) {

    }

    @Override
    public Set<Object> getSolution() {
        return null;
    }

}
