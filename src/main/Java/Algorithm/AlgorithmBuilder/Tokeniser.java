package Java.Algorithm.AlgorithmBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by seraphiana on 02/12/14.
 */
public class Tokeniser {
    private LinkedList<TokenInfo> tokenInfos;
    private LinkedList<Token> tokens;
    private String fileLocation;
    private String file;

    public Tokeniser(String filelocation) {
        tokenInfos = new LinkedList<TokenInfo>();
        tokens = new LinkedList<Token>();
        fileLocation = filelocation;
        add("x", Token.VAR); // current variable
        add("n", Token.N); // item number
        add("c", Token.CUTOFF); // cutoff
        add("if", Token.IF); // if function
        add("store", Token.STORE); // store value
        add(">", Token.GREATER); // greater than
        add("<", Token.LESS); // less than
        add("max", Token.MAX); // maximum seen element
        add("size", Token.SIZE); // matroid size
        add("=", Token.EQUALS); // equals
        add("[0123456789]+.[0123456789]+", Token.DOUBLE); // number
        add("[0123456789]", Token.INT); //number
        add("Step\\{", Token.STEP); // begin step
        add("\\}", Token.ENDSTEP); // end step
        add("add", Token.ADD); // add, if oracle says yes
        add("[+-]", Token.PLUSMINUSTIMESDIVIDE); // plus or minus
        add("[*/]", Token.PLUSMINUSTIMESDIVIDE); // Divide and multiply
        add("\\(", Token.OPENBRACKET); // open bracket
        add("\\)", Token.CLOSEBRACKET); // close bracket
        add("Z", Token.EPSILON); //End program

    }

    private void add(String regex, int token) {
        tokenInfos.add(
                new TokenInfo(
                        Pattern.compile("^(" + regex + ")"), token));
    }


    private String readFile(String fileLocation) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = bufferedReader.readLine();
            }
            return stringBuilder.toString();
        } finally {
            bufferedReader.close();
        }
    }

    public void tokenise() {

        try {
            file = readFile(fileLocation);

        } catch (IOException e) {
            e.printStackTrace();
        }
        file = file.replaceAll("\\s", "");

        tokens.clear();
        while (!file.equals("")) {
            boolean match = false;


            for (TokenInfo info : tokenInfos) {
                Matcher m = info.regex.matcher(file);
                if (m.find()) {
                    match = true;
                    String tok = m.group().trim();
                    tokens.add(new Token(info.token, tok));
                    file = m.replaceFirst("");
                }
            }

            if (!match) {

                throw new RuntimeException("Unexpected character in input: " + file);

            }
        }
    }

    public LinkedList<Token> getTokens() {
        return tokens;
    }


    private class TokenInfo {
        public final Pattern regex;
        public final int token;

        public TokenInfo(Pattern regex, int token) {
            super();
            this.regex = regex;
            this.token = token;
        }
    }
}
