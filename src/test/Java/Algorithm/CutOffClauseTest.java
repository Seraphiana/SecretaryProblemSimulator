package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.CutoffClause;
import Java.Algorithm.AlgorithmBuilder.Token;
import Java.Constants.ProjectConstants;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by fmoon on 11/08/15.
 */
public class CutOffClauseTest {
    Queue<Token> tokens = new ConcurrentLinkedQueue<>();

    @Before
    public void buildUp() {

    }

    @Test
    public void shouldEvaluateAnExpressionThatIsASingleNumberTokenToBeEqualToThatNumber() {
        int amount = 500;
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.INT, "" + amount));
        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(10), is(amount));
    }
    @Test
    public void shouldNotBreakIfGivenADouble() {
        double amount = 500.5;
        Queue<Token> tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.DOUBLE, "" + amount));
        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(10), is(0));
    }

    @Test
    public void shouldReturnAProductWhenGivenMultiplyToken() {
        int a = 2;
        int b = 3;
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.INT, "" + a));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "*"));
        tokens.add(new Token(ProjectConstants.INT, "" + b));
        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(5), is(a*b));
    }

    @Test
    public void shouldReturnASumWhenGivenAddToken() {
        int a = 2;
        int b = 3;
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.INT, "" + a));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "+"));
        tokens.add(new Token(ProjectConstants.INT, "" + b));
        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(5), is(a+b));
    }

    @Test
    public void shouldReturnAQuotientWhenGivenDivideToken() {
        int a = 6;
        int b = 3;
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.INT, "" + a));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "/"));
        tokens.add(new Token(ProjectConstants.INT, "" + b));
        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(5), is(a/b));
    }

    @Test
    public void shouldReturnADifferenceWhenGivenSubtractToken() {
        int a = 4;
        int b = 3;
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.INT, "" + a));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "-"));
        tokens.add(new Token(ProjectConstants.INT, "" + b));
        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(5), is(a-b));
    }

    @Test
    public void shouldEvaluateBracketsCorrectly() {
        int a = 2;
        int b = 3;
        int c = 4;
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.INT, "" + a));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "*"));
        tokens.add(new Token(ProjectConstants.OPENBRACKET, "("));
        tokens.add(new Token(ProjectConstants.INT, "" + b));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "+"));
        tokens.add(new Token(ProjectConstants.INT, "" + c));
        tokens.add(new Token(ProjectConstants.CLOSEBRACKET, ")"));
        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(5), is(a*(b+c)));
    }

    @Test
    public void shouldUseSampleSizeWhenToldToUseIt() {
        int sampleSize = 10;
        int x = 3;
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.SIZE, "size"));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "*"));
        tokens.add(new Token(ProjectConstants.INT, "" + x));
        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(sampleSize), is(sampleSize*x));
    }

    @Test
    public void shouldDoNothingWhenFedGarbage() {
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "*"));
        tokens.add(new Token(ProjectConstants.STEP, "Step{"));
        tokens.add(new Token(ProjectConstants.ENDSTEP, "}"));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "-"));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "/"));
        tokens.add(new Token(ProjectConstants.STORE, "store"));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "+"));
        tokens.add(new Token(ProjectConstants.CUTOFF, "c"));

        CutoffClause cutoffClause = new CutoffClause(tokens);
        assertThat(cutoffClause.calculateCutOff(10), is(0));
    }
}
