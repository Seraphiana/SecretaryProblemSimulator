package Java.Oracle;

import Java.Randomiser.ComparableObjectBuilder;
import Java.Randomiser.NumComparableObject;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

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

}
