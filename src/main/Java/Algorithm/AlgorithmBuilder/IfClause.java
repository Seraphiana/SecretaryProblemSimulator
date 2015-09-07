package Java.Algorithm.AlgorithmBuilder;

import Java.Constants.ProjectConstants;
import Java.Randomiser.ComparableObject;

import java.util.LinkedList;
import java.util.Queue;

public class IfClause {
    private Queue<Token> statement;
    private Token comparison;
    private final Queue<Token> originalStatement;


//    if (x > (max*0.8)) add

    public IfClause(Queue<Token> statement) {
        boolean trim = true;
        while (trim) {
            if (statement.peek().token == ProjectConstants.IF
                    || statement.peek().token == ProjectConstants.OPENBRACKET
                    || statement.peek().token == ProjectConstants.VAR) {
                statement.remove();
            } else trim = false;
        }
        originalStatement = statement;
        this.statement = statement;
    }

    public Queue<Token> getStatement() {
        return statement;
    }

    public <T extends ComparableObject> boolean consider(T object, T highestSeen) {
        statement = new LinkedList<>(originalStatement);
        comparison = statement.remove();

        return evaluate(object, expression(highestSeen, ComparableObject.createNew(), null));
    }

    private <T extends Comparable> boolean evaluate(T element, T threshhold) throws Parser.ParserException {
        switch (comparison.sequence) {
            case ("<"):
                return (element.compareTo(threshhold) < 0);
            case (">"):
                return (element.compareTo(threshhold) > 0);
            case ("="):
                return (element.compareTo(threshhold) == 0);
            default:
                throw new RuntimeException("no valid comparison within IF statement " + comparison.sequence);
        }
    }

    private ComparableObject expression(ComparableObject highestSeen, ComparableObject currentValue, Token currentOperation) {
        Token action = statement.remove();
        switch (action.token) {
            case ProjectConstants.MAX:
                if (currentOperation == null) {
                    currentValue = highestSeen.clone();
                } else {
                    currentValue = currentValue.operateWith(currentOperation, highestSeen);
                }
                break;
            case ProjectConstants.INT:

            case ProjectConstants.DOUBLE:
                if (currentValue==null) {
                    currentValue=ComparableObject.createNew(action);
                } else {
                    if (currentOperation == null) {
                        currentValue = ComparableObject.createNew(action);
                    } else {

                        currentValue = currentValue.operateWith(currentOperation, ComparableObject.createNew(action));
                    }
                }
            break;
            case ProjectConstants.PLUSMINUSTIMESDIVIDE:
                currentOperation = action;
                break;

            case ProjectConstants.OPENBRACKET:
                if (currentOperation!= null) {
                    currentValue = currentValue.operateWith(currentOperation, expression(highestSeen, ComparableObject.createNew(), null));
                }
                break;

            case ProjectConstants.CLOSEBRACKET:
                return currentValue;
            default:
                break;
        }
        return expression(highestSeen, currentValue, currentOperation);
    }

}
