package Java.Oracle;

import Java.Randomiser.ComparableObjectBuilder;
import Java.Randomiser.NumComparableObject;
import Java.Randomiser.VectorCandidate;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class SCOracleTests {

    @Test
    public void ShouldAnswerYesTest() {
        NumComparableObject x = ComparableObjectBuilder.createWith(5);

        SingleCandidateOracle oracle =  SingleCandidateOracle.createSingleCandidateOracle();

        assertEquals(true, oracle.consider(x));
    }

    @Test
    public void shouldAnswerNoTest() {
        NumComparableObject x = ComparableObjectBuilder.createWith(3);
        NumComparableObject y = ComparableObjectBuilder.createWith(9);
        Oracle oracle = SingleCandidateOracle.createSingleCandidateOracle();


        oracle.consider(y);
        assertEquals(false, oracle.consider(x));
    }

    @Test
    public void shouldAnswerYesAndNoToVector() {
        VectorCandidate i = new VectorCandidate(2, 90);
        VectorCandidate j = new VectorCandidate(3, 90);
        Oracle oracle = SingleCandidateOracle.createSingleCandidateOracle();
        assertTrue(oracle.consider(i));
        assertFalse(oracle.consider(j));

    }

}
