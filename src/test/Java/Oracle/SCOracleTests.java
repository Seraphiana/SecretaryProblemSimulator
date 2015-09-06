package Java.Oracle;

import Java.Algorithm.AlgorithmBuilder.ComparableObjectBuilder;
import Java.Algorithm.AlgorithmBuilder.NumComparableObject;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Fliss on 16/07/14.
 */
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
