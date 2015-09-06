package Java.Algorithm.AlgorithmBuilder;

import Java.Constants.ProjectConstants;

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
        add("x", ProjectConstants.VAR); // current variable
        add("n", ProjectConstants.N); // item number
        add("c", ProjectConstants.CUTOFF); // cutoff
        add("if", ProjectConstants.IF); // if function
        add("store", ProjectConstants.STORE); // store value
        add(">", ProjectConstants.GREATER); // greater than
        add("<", ProjectConstants.LESS); // less than
        add("max", ProjectConstants.MAX); // maximum seen element
        add("size", ProjectConstants.SIZE); // matroid size
        add("=", ProjectConstants.EQUALS); // equals
        add("[0123456789]+.[0123456789]+", ProjectConstants.DOUBLE); // number
        add("-[0123456789]+.[0123456789]+", ProjectConstants.DOUBLE); //number
        add("[0123456789]", ProjectConstants.DOUBLE); //number
        add("Step\\{", ProjectConstants.STEP); // begin step
        add("\\}", ProjectConstants.ENDSTEP); // end step
        add("add", ProjectConstants.ADD); // add, if oracle says yes
        add("[+-]", ProjectConstants.PLUSMINUSTIMESDIVIDE); // plus or minus
        add("[*/]", ProjectConstants.PLUSMINUSTIMESDIVIDE); // Divide and multiply
        add("\\(", ProjectConstants.OPENBRACKET); // open bracket
        add("\\)", ProjectConstants.CLOSEBRACKET); // close bracket
        add("Z", ProjectConstants.EPSILON); //End program

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
