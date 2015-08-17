package Java.Algorithm.AlgorithmBuilder;

import Java.Constants.ProjectConstants;

import java.util.Queue;

/**
 * Created by seraphiana on 21/04/15.
 */
public class CutoffClause {
    private Queue<Token> expression;
    private int sampleSize;

    public CutoffClause(Queue<Token> expression) {
        if (expression.peek()!=null) {
            boolean t = true;
            while (t) {
                t = false;
                if (expression.peek()!=null) {
                    if (expression.peek().token == 3 || expression.peek().token == 10) {
                        expression.remove();
                        t = true;
                    }
                }
            }
            this.expression = expression;
        }
    }


    public int calculateCutOff(int sampleSize) {
        this.sampleSize = sampleSize;

        if(expression.isEmpty()) {
            return 0;
        }
        return calculate(0, null);
    }

    private int calculate(int currentTotal, Token currentOperation) {
        if (expression.isEmpty()) {
            return currentTotal;
        }
        Token token = expression.remove();
        switch (token.token) {
            case (ProjectConstants.SIZE):
                if(currentOperation==null) {
                    currentTotal = sampleSize;
                } else {
                    currentTotal = evaluate(currentTotal, sampleSize, currentOperation);
                }
                break;
            case (ProjectConstants.INT):
                if(currentOperation==null) {
                    currentTotal = Integer.parseInt(token.sequence);
                }
                else currentTotal = evaluate(currentTotal, Integer.parseInt(token.sequence), currentOperation);
                break;
            case (ProjectConstants.PLUSMINUSTIMESDIVIDE):
                currentOperation = token;
                break;
            case (ProjectConstants.OPENBRACKET):
                if(currentOperation==null) {
                    currentTotal = calculate(0, null);
                }
                else currentTotal = evaluate(currentTotal, calculate(0, null), currentOperation);
                break;
            case (ProjectConstants.CLOSEBRACKET):
                return currentTotal;
            default:
                break;
        }
        return calculate(currentTotal, currentOperation);
    }


    private int evaluate(int currentTotal, int i, Token operation) {
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
