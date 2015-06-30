package Java.Algorithm;

import org.junit.Test;

import Java.Controller.ModuleController;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Fliss on 16/07/14.
 */
public class ConventionalAlgorithmTests {

    @Test
    public void shouldAnswerYesTest() {
        Set alreadySeen = new HashSet<>();
        ModuleController controller = mock(ModuleController.class);
        SecretaryAlgorithm algorithm = new ConventionalAlgorithm(controller);
        when(controller.getMatroidSize()).thenReturn(1);
        when(controller.getIndexNumber()).thenReturn(0);
        when(controller.getNext()).thenReturn(1);
        when(controller.getAlreadySeen()).thenReturn(alreadySeen);
        when(controller.checkCandidate()).thenReturn(true);
        boolean answer = algorithm.evaluateNext();
        assertTrue(answer);
    }

    @Test
    public void shouldAlsoAnswerYesTest() {
        ModuleController controller = mock(ModuleController.class);
        SecretaryAlgorithm algorithm = new ConventionalAlgorithm(controller);
        when(controller.getMatroidSize()).thenReturn(10);
        when(controller.getIndexNumber()).thenReturn(6);
        when(controller.getMaximum()).thenReturn(5);
        when(controller.getNext()).thenReturn(6);
        when(controller.checkCandidate()).thenReturn(true);
        boolean answer = algorithm.evaluateNext();
        assertTrue(answer);
    }

    @Test
    public void shouldAnswerNoTest() {
        ModuleController controller = mock(ModuleController.class);
        SecretaryAlgorithm algorithm = new ConventionalAlgorithm(controller);
        when(controller.getMatroidSize()).thenReturn(10);
        when(controller.getIndexNumber()).thenReturn(7);
        when(controller.getNext()).thenReturn(1);
        when(controller.checkCandidate()).thenReturn(true);
        when(controller.getMaximum()).thenReturn(5);
        boolean answer = algorithm.evaluateNext();
        assertFalse(answer);
    }
}
