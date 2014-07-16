package AlgorithmTests;

import Algorithm.ConventialAlgorithm;
import Algorithm.SecretaryAlgorithm;
import Controller.ModuleController;
import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by Fliss on 16/07/14.
 */
public class ConventionalAlgorithmTests {

    @Test
    public void shouldAnswerYesTest() {
        ModuleController controller = mock(ModuleController.class);
        SecretaryAlgorithm algorithm = new ConventialAlgorithm(controller);

    }

    @Test
    public void shouldAnswerNoTest() {

    }
}
