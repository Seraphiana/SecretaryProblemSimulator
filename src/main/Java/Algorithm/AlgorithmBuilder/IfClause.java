package Java.Algorithm.AlgorithmBuilder;

import java.util.Queue;

/**
 * Created by seraphiana on 21/04/15.
 */
public class IfClause {
    private Queue<Token> statement;

    public IfClause(Queue<Token> statement) {
        this.statement = statement;
    }

    public Queue<Token> getStatement() {
        return statement;
    }

}
