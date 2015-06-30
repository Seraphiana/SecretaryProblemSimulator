package Java.Oracle;

import org.junit.Test;

import Java.Controller.ModuleController;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Fliss on 16/07/14.
 */
public class SCOracleTests {

    @Test
    public void ShouldAnswerYesTest() {
        Integer x = 5;
        ModuleController controller = mock(ModuleController.class);
        SingleCandidateOracle oracle =  SingleCandidateOracle.createSingleCandidateOracle(controller);
        when(controller.getSolution()).thenReturn(new HashSet<Comparable>());
        assertEquals(true, oracle.consider(x));
    }

    @Test
    public void shouldAnswerNoTest() {
        Integer x = 3;
        ModuleController controller = mock(ModuleController.class);
        Oracle<Integer> oracle = SingleCandidateOracle.createSingleCandidateOracle(controller);
        Set<Comparable> set = new HashSet<>();
        set.add(9);
        when(controller.getSolution()).thenReturn(set);
        assertEquals(false, oracle.consider(x));
    }

}
