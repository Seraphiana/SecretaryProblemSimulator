package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.Parser;
import Java.Algorithm.AlgorithmBuilder.Token;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fmoon on 11/08/15.
 */
public class ParserTest {

    private Parser parser;
    private List<Token> tokens;

    @Before
    public void buildup() {
        parser = new Parser();
        tokens = new LinkedList<>();
    }

    @Test(expected = Parser.ParserException.class)
    public void shouldThrowAnExceptionIfGivenAnInputWithNoSteps() {
        tokens.add(new Token(Token.CUTOFF, "c"));

        parser.parse(tokens);
    }

    @Test
    public void shouldNotThrowAParserExceptionIfGivenNoCutoff() {
        tokens.add(new Token(Token.STEP, "Step{"));

        tokens.add(new Token(Token.IF, "If"));
        tokens.add(new Token(Token.OPENBRACKET, "("));
        tokens.add(new Token(Token.VAR, "x"));
        tokens.add(new Token(Token.GREATER, ">"));
        tokens.add(new Token(Token.INT, "2"));
        tokens.add(new Token(Token.CLOSEBRACKET, ")"));
        tokens.add(new Token(Token.ADD, "add"));

        tokens.add(new Token(Token.ENDSTEP, "}"));

        parser.parse(tokens);
    }

    @Test
    public void shouldIgnoreExtracAtTheBeginning() {
        tokens.add(new Token(Token.CUTOFF, "c"));

        tokens.add(new Token(Token.STEP, "Step{"));

        tokens.add(new Token(Token.IF, "If"));
        tokens.add(new Token(Token.OPENBRACKET, "("));
        tokens.add(new Token(Token.VAR, "x"));
        tokens.add(new Token(Token.GREATER, ">"));
        tokens.add(new Token(Token.INT, "2"));
        tokens.add(new Token(Token.CLOSEBRACKET, ")"));
        tokens.add(new Token(Token.ADD, "add"));

        tokens.add(new Token(Token.ENDSTEP, "}"));

        parser.parse(tokens);
    }

    @Test
    public void shouldNotThrowAnExceptionIfGivenAValidInput() {
        tokens.add(new Token(Token.CUTOFF, "c"));
        tokens.add(new Token(Token.EQUALS, "="));
        tokens.add(new Token(Token.INT, "10"));

        tokens.add(new Token(Token.STEP, "Step{"));
        tokens.add(new Token(Token.IF, "If"));
        tokens.add(new Token(Token.OPENBRACKET, "("));
        tokens.add(new Token(Token.VAR, "x"));
        tokens.add(new Token(Token.GREATER, ">"));
        tokens.add(new Token(Token.INT, "2"));
        tokens.add(new Token(Token.CLOSEBRACKET, ")"));
        tokens.add(new Token(Token.ADD, "add"));

        tokens.add(new Token(Token.ENDSTEP, "}"));

        parser.parse(tokens);
    }

}
