package Java.Oracle;


import Java.Controller.ModuleController;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fliss on 04/07/14.
 */
public class SingleCandidateOracle<T> extends OracleAbs<T> implements Oracle<T> {


    public SingleCandidateOracle(ModuleController controller) {
        super(controller);
    }

    @Override
    public boolean consider(T value) {
        return getSolution().isEmpty();
    }


}
