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
        File file = new File("t.txt");
        tokeniser = new Tokeniser("t.txt");
        t = tokeniser.getClass();
        URL url = t.getResource("t.txt");
        System.out.println(url.getPath());
        tokeniser = new Tokeniser(url.getPath());
    }

    @Test
    public void shouldPrintSomeStuffTest() {
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
