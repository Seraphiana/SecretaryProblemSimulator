package Java.Algorithm.AlgorithmBuilder;

import java.util.Queue;

/**
 * Created by seraphiana on 21/04/15.
 */
public class CutoffClause {
    private Queue<Token> expression;
    private Token operation;
    private int sampleSize;

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


    public int calculateCutOff(int sampleSize) {
        this.sampleSize = sampleSize;
        if (expression.peek().token==Token.SIZE) {
            expression.remove();
            return calculate(sampleSize);
        }
        return calculate(0);
    }

    //TODO add parentheses
    private int calculate(int currentTotal) {
        if (expression.isEmpty()) {
            return currentTotal;
        }
        Token token = expression.remove();
        switch (token.token) {
            case (Token.SIZE):
                if(operation==null) {
                    currentTotal = Integer.parseInt(token.sequence);
                } else {
                    currentTotal = evaluate(currentTotal, sampleSize);
                }
                break;
            case (Token.NUM):
                if(operation==null) {
                    currentTotal = Integer.parseInt(token.sequence);
                }
                else currentTotal = evaluate(currentTotal, Integer.parseInt(token.sequence));
                break;
            case (Token.PLUSMINUS):
                operation = token;
                break;
            case (Token.TIMESDIVIDE):
                operation = token;
                break;
            default:
                break;
        }
        return calculate(currentTotal);
    }

    private int evaluate(int currentTotal, int i) {
        switch (operation.sequence) {
            case ("+"):
                currentTotal= currentTotal+i;
                break;
            case ("-"):
                currentTotal=currentTotal-i;
                break;
            case ("*"):
                currentTotal=currentTotal*i;
                break;
            case ("/"):
                currentTotal=currentTotal/i;
                break;

            default: break;
        }
        return currentTotal;
    }
}
