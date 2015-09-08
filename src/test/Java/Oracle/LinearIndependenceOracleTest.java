package Java.Oracle;

import Java.Randomiser.VectorCandidate;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class LinearIndependenceOracleTest {

    private VectorCandidate k;
    private VectorCandidate i;
    private VectorCandidate j;

    @Before
    public void buildup() {
        i = new VectorCandidate(2, 90);
        j = new VectorCandidate(3, 90);
        k = new VectorCandidate(4, 75);
    }

    @Test
    public void shouldSayYesToFirstElementAndNoToSecondElementIfNotLinearlyIndependentAndYesIfAreIndependent() {
        Oracle oracle = new LinearIndependenceOracle();
        assertThat(oracle.consider(i), is(true));
        assertThat(oracle.consider(j), is(false));
        assertThat(oracle.consider(k), is(true));
    }

    @Test
    public void shouldReturnSolution() {
        Oracle oracle = new LinearIndependenceOracle();
        assertThat(oracle.consider(j), is(true));
        assertTrue(oracle.solution().contains("3"));
        assertTrue(oracle.solution().contains("90"));
    }

}
