package Java.Oracle;

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
        Integer x = 5;

        SingleCandidateOracle oracle =  SingleCandidateOracle.createSingleCandidateOracle();

        assertEquals(true, oracle.consider(x));
    }

    @Test
    public void shouldAnswerNoTest() {
        Integer x = 3;
        Integer y = 9;
        Oracle oracle = SingleCandidateOracle.createSingleCandidateOracle();

        oracle.consider(y);
        assertEquals(false, oracle.consider(x));
    }

}
