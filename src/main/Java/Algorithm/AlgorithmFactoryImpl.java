package Java.Algorithm;

import Java.Constants.Constants;
import Java.Controller.ModuleController;

/**
 * Created by seraphiana on 31/07/14.
 */
public class AlgorithmFactoryImpl implements AlgorithmFactory {
    private final ModuleController controller;


    public AlgorithmFactoryImpl(ModuleController controller) {
        this.controller = controller;
    }
    @Override
    public SecretaryAlgorithm createAlgorithm(String algorithmType) {
        if(algorithmType.equals(Constants.CONVENTIONAL)) {
            return new ConventionalAlgorithm(controller);
        }
        return null;
    }
}
