package Java.Algorithm.AlgorithmBuilder;

import java.io.File;

/**
 * Created by seraphiana on 02/10/14.
 */
public class AlgorithmBuilder {
    private int matroidSize;

    private String fileName;

    public Algorithm buildAlgorithm() {
        String path = new File("").getAbsolutePath();
        path = path + "/src/Algorithms/" + fileName + ".txt";
        Tokeniser tokeniser = new Tokeniser(path);
        tokeniser.tokenise();
        Parser parser = new Parser();

        parser.parse(tokeniser.getTokens());
        Algorithm algorithm =  CustomizableAlgorithm.createAlgorithm(parser.getIfClauses(), parser.getCutoff(), matroidSize);
        return algorithm;
    }

    public void update(String algChoice, int matroidSize) {
        fileName = algChoice;
        this.matroidSize = matroidSize;
    }
}
