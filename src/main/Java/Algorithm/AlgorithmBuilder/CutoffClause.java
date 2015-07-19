package Java.Algorithm.AlgorithmBuilder;

import java.util.Queue;

/**
 * Created by seraphiana on 21/04/15.
 */
public class CutoffClause {
    private Queue<Token> expression;

    public CutoffClause(Queue<Token> expression) {
        boolean t = true;
        while (t) {
            t = false;
            if (expression.peek().token==3 || expression.peek().token==10) {
                expression.remove();
                t = true;
            }
        }
        this.expression = expression;
    }


    public Queue<Token> getExpression() {
        return expression;
    }

    public int calculateCutOff(int sampleSize) {
        if (expression.peek().token==9) {
            expression.remove();
        }
        return calculate(sampleSize);
    }

    private int calculate(int currentTotal) {
        if (expression.isEmpty()) {
            return currentTotal;
        }
        Token token = expression.remove();


        return calculate(currentTotal);
    }
}
