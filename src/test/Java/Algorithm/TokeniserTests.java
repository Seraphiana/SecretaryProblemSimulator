package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.Token;
import Java.Algorithm.AlgorithmBuilder.Tokeniser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by seraphiana on 02/12/14.
 */
public class TokeniserTests {


    @BeforeClass
    public static void buildUp() {

    }

    @Test
    public void shouldPrintSomeStuffTest() {
        String path = new File("").getAbsolutePath();
        path = path + "/src/Algorithms/test.txt";

        Tokeniser tokeniser = new Tokeniser(path);
        try {

            tokeniser.tokenise();

            for (Token tok : tokeniser.getTokens()) {
                System.out.println("" + tok.token + " " + tok.sequence);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
