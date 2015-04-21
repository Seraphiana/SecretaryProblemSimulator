package Java.Algorithm.AlgorithmBuilder;

/**
 * Created by seraphiana on 15/04/15.
 */
public class Token {
    public static final int VAR = 0;
    public static final int N = 1;
    public static final int CUTOFF = 2;
    public static final int IF = 3;
    public static final int STORE = 4;
    public static final int GREATER = 5;
    public static final int LESS = 6;
    public static final int MAX = 7;
    public static final int SIZE = 8;
    public static final int EQUALS = 9;
    public static final int NUM = 10;
    public static final int STEP = 11;
    public static final int ENDSTEP = 12;
    public static final int ADD = 13;
    public static final int OPENBRACKET = 14;
    public static final int CLOSEBRACKET = 15;
    public static final int EPSILON = -1;

    public final int token;
    public final String sequence;

    public Token(int token, String sequence) {
        super();
        this.token = token;
        this.sequence = sequence;
    }

}
