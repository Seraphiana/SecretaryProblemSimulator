package Java.GUI;

import Java.Constants.ProjectConstants;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by fmoon on 06/09/15.
 */
public class MediatorTest {

    private Mediator mediator;
    private String[] buildData = {"" + 10,"" + 1,"" + -1,"" +  1,"" + -1,"" + 1};;

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
        assertTrue(Double.parseDouble(result.substring(1, result.length()-1))>200);
    }

    @Test
        public void shouldGiveErrorMessages() {
    String result = mediator.run(buildData, "", "", "");
        String expected = "You must select\r" + "an algorithm, " + "\r" + "a matroid, " + "\r" + "an oracleType, " + "\r" + "to run.";
        assertThat(result, is(expected));
    }
}