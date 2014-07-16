package OracleTests;

import Controller.ModuleController;
import Oracle.*;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Fliss on 16/07/14.
 */
public class SCOracleTests {

    @Test
    public void ShouldAnswerYesTest() {
        Integer x = 5;
        ModuleController controller = mock(ModuleController.class);
        Oracle<Integer> oracle = new SingleCandidateOracle(controller);
        assertEquals(true, oracle.consider(x));
    }

    @Test
    public void shouldAnswerNoTest() {
        Integer x = 3;
        ModuleController controller = mock(ModuleController.class);
        Oracle<Integer> oracle = new SingleCandidateOracle(controller);
        oracle.addValue(x);
        assertEquals(false, oracle.consider(x));
    }

    @Test
    public void shouldGiveASolutionSet() {
        Integer x = 8;
        ModuleController controller = mock(ModuleController.class);
        Oracle<Integer> oracle = new SingleCandidateOracle(controller);
        oracle.addValue(x);
        Set<Integer> testAns = new HashSet<Integer>();
        testAns.add(x);
        assertEquals(testAns, oracle.getSolution());
    }
}
