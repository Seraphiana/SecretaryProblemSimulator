package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.AlgorithmBuilder;
import Java.Algorithm.AlgorithmBuilder.Interpreter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by seraphiana on 02/10/14.
 */
public class AlgorithmBuilderTest {
    public Interpreter interpreter;
    public AlgorithmBuilder algorithmBuilder;

    @Before
    public void setUp() {

        algorithmBuilder = new AlgorithmBuilder();

    }

    @Test
    public void shouldMakeAnAlgorithmTest() {
        String fileLocation = algorithmBuilder.findFile();
        interpreter = new Interpreter(fileLocation);
        interpreter.buildAlgorithm();

        assertTrue(true);   //How to do this?
    }

}
