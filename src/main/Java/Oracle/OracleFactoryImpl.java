package Java.Oracle;


import Java.Constants.ProjectConstants;

public class OracleFactoryImpl {
    private String oracleType;

    public Oracle makeOracle() {
        switch (oracleType) {
            case ProjectConstants.SINGLECANDIDATE:
                return SingleCandidateOracle.createSingleCandidateOracle();
            case ProjectConstants.LINEARINDEPENDENT:
                return new LinearIndependenceOracle();
            default:
                return null;
        }
    }

    public void update(String oracleType) {
        this.oracleType = oracleType;
    }
}
