package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.Token;
import Java.Algorithm.AlgorithmBuilder.Tokeniser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * Created by seraphiana on 02/12/14.
 */
public class TokeniserTests {
    private static Tokeniser tokeniser;
    private static Class t;

    @BeforeClass
    public static void buildUp() {

    }

    @Test
    public void shouldPrintSomeStuffTest() {
        File file = new File("/Algorithms/test.txt");
        URL url = this.getClass().getResource("/Algorithms/test.txt");
        System.out.println(url.getPath());
        tokeniser = new Tokeniser(url.getPath());
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
