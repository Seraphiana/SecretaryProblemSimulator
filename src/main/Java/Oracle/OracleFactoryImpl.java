package Java.Oracle;


import Java.Constants.Constants;
import Java.Controller.ModuleController;

/**
 * Created by seraphiana on 31/07/14.
 */
public class OracleFactoryImpl implements Java.Oracle.OracleFactory {
    private final ModuleController controller;


    public OracleFactoryImpl(ModuleController controller) {
        this.controller = controller;
    }

    @Override
    public Oracle makeOracle(String oracleType) {
        if (oracleType.equals(Constants.SINGLECANDIDATE)) {
            return new SingleCandidateOracle(controller);
        }
        return null;
    }
}
