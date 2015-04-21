package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.Tokeniser;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by seraphiana on 02/12/14.
 */
public class TokeniserTests {
    private static Tokeniser tokeniser;

    @BeforeClass
    public static void buildUp() {
        tokeniser = new Tokeniser();

        tokeniser.add("\\s", 0); // whitespace
        tokeniser.add("sin|cos|exp|ln|sqrt", 1); // function
        tokeniser.add("\\(", 2); // open bracket
        tokeniser.add("\\)", 3); // close bracket
        tokeniser.add("[+-]", 4); // plus or minus
        tokeniser.add("[*/]", 5); // mult or divide
        tokeniser.add("\\^", 6); // raised
        tokeniser.add("[0-9]+",7); // integer number
        tokeniser.add("[a-zA-Z][a-zA-Z0-9_]*", 8); // variable

    }

    @Test
    public void shouldPrintSomeStuffTest() {
        try {
            tokeniser.tokenise(" sin(x) * (1 + var_12) ");
            for (Tokeniser.Token tok : tokeniser.getTokens()) {
                System.out.println("" + tok.token + " " + tok.sequence);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
