package Java.Randomiser;

import Java.Constants.Constants;
import Java.Controller.ModuleController;

/**
 * Created by Fliss on 14/07/14.
 */
public class RandomiserFactoryImpl implements RandomiserFactory {
    private final ModuleController controller;


    public RandomiserFactoryImpl(ModuleController controller) {
        this.controller = controller;
    }

    @Override
    public Randomiser createRandomiser() {
        if (controller.getRandomiserType().equals(Constants.INTEGER)) {
            Randomiser<Integer> randomiser = new IntRandomiser(controller.getRandomiserSize(), controller.getRandElementFrequency());
        return randomiser;
        }

        else return null;
    }
}
