package Java.Algorithm.AlgorithmBuilder;

import java.util.Queue;

/**
 * Created by seraphiana on 21/04/15.
 */
public class CutoffClause {
    private Queue<Token> expression;

    public CutoffClause(Queue<Token> expression) {
        this.expression = expression;
    }


    public Queue<Token> getExpression() {
        return expression;
    }
}
