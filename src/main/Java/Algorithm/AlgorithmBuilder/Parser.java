package Java.Algorithm.AlgorithmBuilder;

import Java.Constants.ProjectConstants;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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


    public void parse(List<Token> tokens1) throws ParserException {

        this.tokens = (LinkedList<Token>) tokens1;
        lookahead = this.tokens.getFirst();

        algorithm();

        if (lookahead != null) {
            if (lookahead.token != ProjectConstants.EPSILON) {
                throw new ParserException("Unexpected Symbol found" + lookahead.token + tokens.peek().token, lookahead);
            }
        }
    }

    private void algorithm() {

        while (lookahead.token != ProjectConstants.STEP) {

            queue.add(tokens.pop());
            lookahead = tokens.peek();
            if (lookahead == null) {
                throw new ParserException("Algorithm does not contain any if conditions", new Token(ProjectConstants.STEP, "Step{"));
            }
        }
        evaluateCutoff();
        tokens.pop();
        while (lookahead.token != ProjectConstants.ENDSTEP) {
            while (lookahead.token != ProjectConstants.ADD) {
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

    private void evaluateCutoff() {
        cutoff = new CutoffClause(queue);
        queue = new LinkedList<>();
    }

    private void evaluateIfClause() {
        ifClauses.add(new IfClause(queue));
        queue = new LinkedList<>();
    }

    public LinkedList<IfClause> getIfClauses() {
        return ifClauses;
    }

    public CutoffClause getCutoff() {
        return cutoff;
    }

    public class ParserException extends RuntimeException {
        private Token illegalToken;

        public ParserException(String message, Token illegalToken) {
            super(message);
            this.illegalToken = illegalToken;
        }
    }
}
