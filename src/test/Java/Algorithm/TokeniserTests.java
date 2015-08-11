package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.Token;
import Java.Algorithm.AlgorithmBuilder.Tokeniser;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
        String result = "";
        String expected = "3 c\n" +
                "10 =\n" +
                "9 size\n" +
                "15 /\n" +
                "12 2\n" +
                "11 Step{\n" +
                "4 if\n" +
                "17 (\n" +
                "1 x\n" +
                "6 >\n" +
                "17 (\n" +
                "8 max\n" +
                "15 *\n" +
                "16 0.8\n" +
                "18 )\n" +
                "18 )\n" +
                "14 add\n" +
                "13 }\n" +
                "-1 Z";
        Tokeniser tokeniser = new Tokeniser(path);
        try {

            tokeniser.tokenise();

            for (Token tok : tokeniser.getTokens()) {
                result += ("" + tok.token + " " + tok.sequence + "\n");
            }
            result = result.substring(0, result.length()-1); // to remove the extra \n at the end
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        assertThat(result, is(expected));
    }
}
