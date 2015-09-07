package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.Parser;
import Java.Algorithm.AlgorithmBuilder.Token;
import Java.Constants.ProjectConstants;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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
        tokens.add(new Token(ProjectConstants.CUTOFF, "c"));

        parser.parse(tokens);
    }

    @Test
    public void shouldNotThrowAParserExceptionIfGivenNoCutoff() {
        tokens.add(new Token(ProjectConstants.STEP, "Step{"));

        tokens.add(new Token(ProjectConstants.IF, "If"));
        tokens.add(new Token(ProjectConstants.OPENBRACKET, "("));
        tokens.add(new Token(ProjectConstants.VAR, "x"));
        tokens.add(new Token(ProjectConstants.GREATER, ">"));
        tokens.add(new Token(ProjectConstants.INT, "2"));
        tokens.add(new Token(ProjectConstants.CLOSEBRACKET, ")"));
        tokens.add(new Token(ProjectConstants.ADD, "add"));

        tokens.add(new Token(ProjectConstants.ENDSTEP, "}"));

        parser.parse(tokens);
    }

    @Test
    public void shouldIgnoreExtracAtTheBeginning() {
        tokens.add(new Token(ProjectConstants.CUTOFF, "c"));

        tokens.add(new Token(ProjectConstants.STEP, "Step{"));

        tokens.add(new Token(ProjectConstants.IF, "If"));
        tokens.add(new Token(ProjectConstants.OPENBRACKET, "("));
        tokens.add(new Token(ProjectConstants.VAR, "x"));
        tokens.add(new Token(ProjectConstants.GREATER, ">"));
        tokens.add(new Token(ProjectConstants.INT, "2"));
        tokens.add(new Token(ProjectConstants.CLOSEBRACKET, ")"));
        tokens.add(new Token(ProjectConstants.ADD, "add"));

        tokens.add(new Token(ProjectConstants.ENDSTEP, "}"));

        parser.parse(tokens);
    }

    @Test
    public void shouldNotThrowAnExceptionIfGivenAValidInput() {
        tokens.add(new Token(ProjectConstants.CUTOFF, "c"));
        tokens.add(new Token(ProjectConstants.EQUALS, "="));
        tokens.add(new Token(ProjectConstants.INT, "10"));

        tokens.add(new Token(ProjectConstants.STEP, "Step{"));
        tokens.add(new Token(ProjectConstants.IF, "If"));
        tokens.add(new Token(ProjectConstants.OPENBRACKET, "("));
        tokens.add(new Token(ProjectConstants.VAR, "x"));
        tokens.add(new Token(ProjectConstants.GREATER, ">"));
        tokens.add(new Token(ProjectConstants.INT, "2"));
        tokens.add(new Token(ProjectConstants.CLOSEBRACKET, ")"));
        tokens.add(new Token(ProjectConstants.ADD, "add"));

        tokens.add(new Token(ProjectConstants.ENDSTEP, "}"));

        parser.parse(tokens);
    }

}
