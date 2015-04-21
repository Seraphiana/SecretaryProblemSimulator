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
    }

    public void add(String regex, int token) {
        tokenInfos.add(
                new TokenInfo(
                  Pattern.compile("^("+regex+")"), token));
    }

    public static void main(String[] args) {
        Tokeniser tokeniser = new Tokeniser(args[0]);
        tokeniser.add("x", 1); // current variable
        tokeniser.add("n", 2); // item number
        tokeniser.add("c", 3); // cutoff
        tokeniser.add("if", 4); // if function
        tokeniser.add("store", 5); // store value
        tokeniser.add(">", 6); // greater than
        tokeniser.add("<", 7); // less than
        tokeniser.add("max", 8); // maximum seen element
        tokeniser.add("size", 9); // matroid size
        tokeniser.add("=", 10); // equals
        tokeniser.add("[0-9]+", 11); // integer number
        tokeniser.add("Step\\{", 12); // begin step
        tokeniser.add("\\}", 13); // end step
        tokeniser.add("add", 14); // add, if oracle says yes
        tokeniser.add("[*/]", 15); // mult or divide
        tokeniser.add("\\(", 17); // open bracket
        tokeniser.add("\\)", 16); // close bracket

        try {
            tokeniser.file = tokeniser.readFile(tokeniser.fileLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tokeniser.tokenise();
    }

    private String readFile(String fileLocation) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
        try {
            StringBuilder stringBuilder =new StringBuilder();
            String line = bufferedReader.readLine();
            while (line!=null) {
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
                    break;
                }
            }
            if (!match) throw new RuntimeException("Unexpected character in input: "+file);
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
