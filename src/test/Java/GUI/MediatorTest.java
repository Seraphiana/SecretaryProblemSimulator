package Java.GUI;

import Java.Constants.ProjectConstants;
import Java.Randomiser.VectorCandidate;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MediatorTest {

    private Mediator mediator;
    private String[] buildData = {"" + 100, "" + 0, "" + 0, "" + 1, "" + 0, "" + 1};
    ;

    @Before
    public void buildup() {
        mediator = new Mediator();

    }

    @Test
    public void shouldRunWithoutThrowingAnySortOfException() throws Exception {
        String algChoice = "test";
        String matroidChoice = ProjectConstants.INTEGER;
        String oracleType = ProjectConstants.SINGLECANDIDATE;
        String result = mediator.run(buildData, algChoice, matroidChoice, oracleType);
        assertTrue(Double.parseDouble(result) > 1);
    }

    @Test
    public void shouldRunWithoutThrowingAnySortOfExceptionUsingVectors() throws Exception {
        String algChoice = "test";
        String matroidChoice = ProjectConstants.VECTOR;
        String oracleType = ProjectConstants.SINGLECANDIDATE;
        String result = mediator.run(buildData, algChoice, matroidChoice, oracleType);
        String trimmedResult = result.substring(0, result.length()-2);
        assertTrue(VectorCandidate.createFromString(trimmedResult).magnitude() > 1);
    }

    @Test
    public void shouldGiveOptimalSetTest() {
        String algChoice = ProjectConstants.TRADITIONAL;
        String matroidChoice = ProjectConstants.VECTOR;
        String oracleType = ProjectConstants.SINGLECANDIDATE;
        mediator.run(buildData, algChoice, matroidChoice, oracleType);
        assertTrue(mediator.getOptimalSet().length() > 1);
    }

    @Test
    public void shouldGiveErrorMessages() {
        String result = mediator.run(buildData, "", "", "");
        String expected = "You must select\r" + "an algorithm," + "\r" + "a matroid, " + "\r" + "an oracleType," + "\r" + "to run.";
        assertThat(result, is(expected));
    }
}