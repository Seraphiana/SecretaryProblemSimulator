package Java.Oracle;

import Java.Constants.ProjectConstants;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class OracleFactTests {
    OracleFactoryImpl oracleFactory;

    @Before
    public void buildup() {
        oracleFactory = new OracleFactoryImpl();
    }

    @Test
    public void shouldMakeANewSCOracleWhenAsked() {
        oracleFactory.update(ProjectConstants.SINGLECANDIDATE);
        assertEquals(oracleFactory.makeOracle().getClass(), SingleCandidateOracle.class);
    }

    @Test
    public void shouldntBreakWhenGivenABadInput() {
        oracleFactory.update("dfgadfvadf1346!@$g");
        assertEquals(oracleFactory.makeOracle(), null);
    }


}
