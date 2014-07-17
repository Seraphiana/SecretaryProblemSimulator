package Java.Algorithm;


import Java.Controller.ModuleController;
import Java.Oracle.Oracle;
import Java.Randomiser.RandomiserFactory;
import static java.lang.Math.*;

/**
 * Created by Fliss on 04/07/14.
 */
public class ConventionalAlgorithm implements SecretaryAlgorithm {
    private final ModuleController controller;
    private int cutOff;

    public ConventionalAlgorithm(ModuleController controller) {
        this.controller = controller;
        cutOff = -1;
    }

    @Override
    public boolean EvaluateNext() {
        if (cutOff == -1) {
            cutOff = (int) floor(controller.getMatroidSize()/E);
        }
        if (controller.getIndexNumber()==controller.getMatroidSize()-1) {
            return controller.checkCandidate();
        }
        if(controller.getIndexNumber()>=cutOff) {
            if (controller.getNext().compareTo(controller.getMaximum())>0) {
                return controller.checkCandidate();
            }
        }
        return false;
    }

}
