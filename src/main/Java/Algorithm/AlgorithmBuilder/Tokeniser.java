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
        add("x", 1); // current variable
        add("n", 2); // item number
        add("c", 3); // cutoff
        add("if", 4); // if function
        add("store", 5); // store value
        add(">", 6); // greater than
        add("<", 7); // less than
        add("max", 8); // maximum seen element
        add("size", 9); // matroid size
        add("=", 10); // equals
        add("[0123456789]+.[0123456789]+", 12); // number
        add("[0123456789]", 12); //number
        add("Step\\{", 11); // begin step
        add("\\}", 13); // end step
        add("add", 14); // add, if oracle says yes
        add("[+-]", 15); // plus or minus
        add("[*/]", 16); // mult or divide
        add("\\(", 17); // open bracket
        add("\\)", 18); // close bracket
        add("Z", -1); //End program

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
