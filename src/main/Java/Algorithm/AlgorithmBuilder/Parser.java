package Java.Algorithm.AlgorithmBuilder;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by seraphiana on 15/04/15.
 */
public class Parser {
    LinkedList<Token> tokens;
    Token lookahead;
    Stack<Token> stack;


    public void parse(List<Token> tokens1) throws ParserException{

        this.tokens = (LinkedList<Token>) tokens1;
        lookahead = this.tokens.getFirst();

        algorithm();

        if (lookahead.token != Token.EPSILON) {
            throw new ParserException("Unexpected Symbol found", lookahead);
        }

    }

    private void algorithm() {
        while (lookahead.token != Token.STEP) {
            stack.push(tokens.pop());
        }
        evaluateCutoff();
        stack.pop();
        while (lookahead.token != Token.ENDSTEP) {
            while (lookahead.token != Token.ADD) {
                stack.push(tokens.pop());
            }
            stack.pop();
            evaluateIfClause();
        }
        stack.pop();
    }

    private void evaluateIfClause() {

    }

    private void evaluateCutoff() {

    }

    private void nextToken() {
        tokens.pop();
        if (tokens.isEmpty()) {
            lookahead = new Token(Token.EPSILON, "");
        } else {
            lookahead = tokens.getFirst();
        }
    }

    private class ParserException extends RuntimeException {
        private Token illegalToken;
        public ParserException(String message, Token illegalToken) {
            super(message);
            this.illegalToken = illegalToken;
        }
    }
}
