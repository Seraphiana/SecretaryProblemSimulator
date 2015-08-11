package Java.Algorithm.AlgorithmBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by seraphiana on 15/04/15.
 */
public class Parser {
    private LinkedList<Token> tokens;
    private Token lookahead;
    private Queue<Token> queue;
    private CutoffClause cutoff;
    private LinkedList<IfClause> ifClauses;

    public Parser() {
        tokens = new LinkedList<>();
        queue = new LinkedList<>();
        ifClauses = new LinkedList<>();
    }


    public void parse(List<Token> tokens1) throws ParserException{

        this.tokens = (LinkedList<Token>) tokens1;
        lookahead = this.tokens.getFirst();

        algorithm();

        if (lookahead.token != Token.EPSILON) {
            throw new ParserException("Unexpected Symbol found" + lookahead.token + tokens.peek().token, lookahead);
        }

    }

    private void algorithm() {

        while (lookahead.token != Token.STEP) {

            queue.add(tokens.pop());
            lookahead = tokens.peek();
        }
        evaluateCutoff();
        tokens.pop();
        while (lookahead.token != Token.ENDSTEP) {
            while (lookahead.token != Token.ADD) {
                queue.add(tokens.pop());
                lookahead = tokens.peek();
            }
            tokens.pop();
            lookahead = tokens.peek();
            evaluateIfClause();
        }
        tokens.pop();
        lookahead = tokens.peek();
    }

    private void evaluateIfClause() {
        ifClauses.add(new IfClause(queue));
        queue = new LinkedList<>();

    }

    private void evaluateCutoff() {
        cutoff = new CutoffClause(queue);
        queue = new LinkedList<>();
    }

    public LinkedList<IfClause> getIfClauses() {
        return ifClauses;
    }

    public CutoffClause getCutoff() {
        return cutoff;
    }

    private class ParserException extends RuntimeException {
        private Token illegalToken;
        public ParserException(String message, Token illegalToken) {
            super(message);
            this.illegalToken = illegalToken;
        }
    }
}
