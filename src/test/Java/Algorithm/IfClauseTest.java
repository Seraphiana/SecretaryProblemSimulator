package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.IfClause;
import Java.Algorithm.AlgorithmBuilder.NumComparableObject;
import Java.Algorithm.AlgorithmBuilder.Token;
import Java.Constants.ProjectConstants;
import org.junit.Before;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by fmoon on 18/08/15.
 */
public class IfClauseTest {
    Queue<Token> tokens;
    IfClause ifClause;
    private NumComparableObject ten;
    private NumComparableObject hundred;
    private NumComparableObject one;

    @Before
    public void buildup() {
        tokens = new ConcurrentLinkedQueue<>();
        tokens.add(new Token(ProjectConstants.IF, "If"));
        tokens.add(new Token(ProjectConstants.OPENBRACKET , "("));
        tokens.add(new Token(ProjectConstants.VAR, "x"));
        tokens.add(new Token(ProjectConstants.GREATER , ">"));
        tokens.add(new Token(ProjectConstants.OPENBRACKET , "("));
        tokens.add(new Token(ProjectConstants.MAX , "max"));
        tokens.add(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE , "*"));
        tokens.add(new Token(ProjectConstants.DOUBLE , "0.8"));
        tokens.add(new Token(ProjectConstants.CLOSEBRACKET , ")"));
        tokens.add(new Token(ProjectConstants.CLOSEBRACKET , ")"));
        ifClause = new IfClause(tokens);
        ten = new NumComparableObject(10d);
        hundred = new NumComparableObject(100d);
        one = new NumComparableObject(1d);
    }

    @Test
    public void shouldReturnTrueWhenGivenAnElementLargerThanMaximum() {

        assertThat(ifClause.consider(hundred, ten), is(true));
    }

    @Test
    public void shouldReturnFalseWhenGivenAnElementSmallerThanPermitted() {
        assertThat(ifClause.consider(one,ten), is(false));
    }
}
