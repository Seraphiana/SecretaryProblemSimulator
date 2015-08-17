package Java.Randomiser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


/**
 * Created by Fliss on 15/07/14.
 */
public class IntegerRandomiserTests {

    @Test
    public void shouldGiveAListOfCandidatesTest() {

        Randomiser randomiser = new IntRandomiser(1, 4);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(1);
        expected.add(1);
        assertEquals(expected, randomiser.getMatroid());
    }

    @Test
    public void shouldAlsoGiveAListOfCandidatesTest() {
        Randomiser randomiser = new IntRandomiser(1);
        List<Integer> list = new ArrayList<>();
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

    @Test
    public void shouldHaveTheCorrectSizeTest() {
        Randomiser<Integer> randomiser = new IntRandomiser(1);
        assertThat(randomiser.getSize(), is(1));
    }
}
