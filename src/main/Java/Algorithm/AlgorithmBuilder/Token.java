package Java.Algorithm.AlgorithmBuilder;

/**
 * Created by seraphiana on 15/04/15.
 */
public class Token {
    public static final int VAR = 1;
    public static final int N = 2;
    public static final int CUTOFF = 3;
    public static final int IF = 4;
    public static final int STORE = 5;
    public static final int GREATER = 6;
    public static final int LESS = 7;
    public static final int MAX = 8;
    public static final int SIZE = 9;
    public static final int EQUALS = 10;
    public static final int NUM = 12;
    public static final int STEP = 11;
    public static final int ENDSTEP = 13;
    public static final int ADD = 14;
    public static final int PLUSMINUSTIMESDIVIDE = 15;
//    public static final int TIMESDIVIDE = 16;
    public static final int OPENBRACKET = 17;
    public static final int CLOSEBRACKET = 18;
    public static final int EPSILON = -1;

    public final int token;
    public final String sequence;

    public Token(int token, String sequence) {
        super();
        this.token = token;
        this.sequence = sequence;
    }

}
