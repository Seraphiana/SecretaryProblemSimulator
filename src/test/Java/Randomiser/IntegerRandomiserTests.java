package Java.Randomiser;

import Java.Oracle.Oracle;
import Java.Oracle.SingleCandidateOracle;
import org.junit.Test;

import Java.Controller.ModuleController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Fliss on 15/07/14.
 */
public class IntegerRandomiserTests {

    @Test
    public void shouldGiveAListOfCandidatesTest() {
        ModuleController controller = mock(ModuleController.class);
        Randomiser randomiser = new IntRandomiser(1, 4);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        assertEquals(list, randomiser.getMatroid());
    }

    @Test
    public void shouldAlsoGiveAListOfCandidatesTest() {
        Randomiser randomiser = new IntRandomiser(1);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        assertEquals(list, randomiser.getMatroid());
    }

    @Test
    public void shouldGiveTwoSeparateValues() {
        Randomiser<Integer> randomiser = new IntRandomiser(2);
        int x = randomiser.getItem();
        randomiser.itemDecision(false);
        int y = randomiser.getItem();
        assertNotSame(x, y);
    }

    @Test
    public void shouldGiveSameCandidate() {
        Randomiser<Integer> randomiser = new IntRandomiser(2);
        int x = randomiser.getItem();
        int y = randomiser.getItem();
        assertEquals(x, y);
    }


    @Test
    public void shouldGiveASolutionSet() {
        Randomiser<Integer> randomiser = new IntRandomiser(3);
        randomiser.itemDecision(true);
        assertNotSame(new HashSet<Integer>(), randomiser.getSolution());
    }
}
