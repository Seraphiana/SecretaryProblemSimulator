package Java.Randomiser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class IntegerRandomiserTests {

    @Test
    public void shouldGiveAListOfCandidatesTest() {

        Randomiser randomiser = new IntRandomiser(1, 4);
        List<NumComparableObject> expected = new ArrayList<>();
        expected.add(ComparableObjectBuilder.createWith(1));
        expected.add(ComparableObjectBuilder.createWith(1));
        expected.add(ComparableObjectBuilder.createWith(1));
        expected.add(ComparableObjectBuilder.createWith(1));
        assertEquals(expected, randomiser.getMatroid());
    }

    @Test
    public void shouldAlsoGiveAListOfCandidatesTest() {
        Randomiser randomiser = new IntRandomiser(1);
        List<NumComparableObject> list = new ArrayList<>();
        list.add(ComparableObjectBuilder.createWith(1));
        assertEquals(list, randomiser.getMatroid());
    }

    @Test
    public void shouldGiveTwoSeparateValues() {
        Randomiser<NumComparableObject> randomiser = new IntRandomiser(2);
        NumComparableObject x = randomiser.getItem();
        randomiser.itemDecision(false);
        NumComparableObject y = randomiser.getItem();
        assertNotSame(x, y);
    }

    @Test
    public void shouldGiveSameCandidate() {
        Randomiser<NumComparableObject> randomiser = new IntRandomiser(2);
        NumComparableObject x = randomiser.getItem();
        NumComparableObject y = randomiser.getItem();
        assertEquals(x, y);
    }


    @Test
    public void shouldGiveASolutionSet() {
        Randomiser<NumComparableObject> randomiser = new IntRandomiser(3);
        randomiser.itemDecision(true);
        assertNotSame(new HashSet<Integer>(), randomiser.getSolution());
    }

    @Test
    public void shouldHaveTheCorrectSizeTest() {
        Randomiser<NumComparableObject> randomiser = new IntRandomiser(1);
        assertThat(randomiser.getSize(), is(1));
    }
}
