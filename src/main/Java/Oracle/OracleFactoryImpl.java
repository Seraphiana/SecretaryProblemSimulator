package Java.Oracle;


import Java.Constants.ProjectConstants;

public class OracleFactoryImpl {
    private String oracleType;

    public Oracle makeOracle() {
        switch (oracleType) {
            case ProjectConstants.SINGLECANDIDATE:
                return SingleCandidateOracle.createSingleCandidateOracle();

            default:
                return null;
        }
    }

    public void update(String oracleType) {
        this.oracleType = oracleType;
    }
}
