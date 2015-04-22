package Java.Algorithm.AlgorithmBuilder;

/**
 * Created by seraphiana on 02/10/14.
 */
public class AlgorithmBuilder {

    public Algorithm buildAlgorithm(String fileLocation) {
        Tokeniser tokeniser = new Tokeniser(fileLocation);
        tokeniser.tokenise();
        Parser parser = new Parser();
        parser.parse(tokeniser.getTokens());
        Algorithm algorithm = new Algorithm(parser.getIfClauses(), parser.getCutoff());
        return algorithm;
    }

}
