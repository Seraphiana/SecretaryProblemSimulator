package Java.Randomiser;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class VectorRandomiserTest {

    @Test
    public void shouldBuildACollectionOfVectors() {
        Randomiser<VectorCandidate> randomiser = new VectorRandomiser(10, 0, 1, 0, 10, 1);
        assertThat(randomiser.getMatroid().size(), is(10));
    }

    @Test
    public void shouldGiveTwoSeparateValues() {
        Randomiser<VectorCandidate> randomiser = new VectorRandomiser(10, 0, 1, 0, 10, 1);
        VectorCandidate x = randomiser.getItem();
        randomiser.itemDecision(false);
        VectorCandidate y = randomiser.getItem();
        assertNotSame(x, y);
    }

    @Test
    public void shouldGiveSameCandidate() {
        Randomiser<VectorCandidate> randomiser = new VectorRandomiser(10, 0, 1, 0, 10, 1);
        VectorCandidate x = randomiser.getItem();
        VectorCandidate y = randomiser.getItem();
        assertEquals(x, y);
    }

    @Test
    public void shouldToString() {
        Randomiser<VectorCandidate> randomiser = new VectorRandomiser(10, 1, 1, 1, 10, 1);
        assertTrue(randomiser.toString().length() > 10);
    }


    @Test
    public void shouldGiveASolutionSet() {
        Randomiser<VectorCandidate> randomiser = new VectorRandomiser(10, 0, 1, 0, 10, 1);
        randomiser.itemDecision(true);
        assertNotSame(new ArrayList<>(), randomiser.getSolution());
    }

    @Test
    public void shouldHaveTheCorrectSizeTest() {
        Randomiser<VectorCandidate> randomiser = new VectorRandomiser(1, 0, 1, 0, 1, 1);
        assertThat(randomiser.getSize(), is(1));
    }
}