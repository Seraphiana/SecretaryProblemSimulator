package Java.Algorithm.AlgorithmBuilder;

import java.util.List;

/**
 * Created by seraphiana on 22/04/15.
 */
public class Algorithm {
    private List<IfClause> ifClauses;
    private CutoffClause cutOff;


    private Algorithm(List<IfClause> ifClauses, CutoffClause cutOff) {
        this.cutOff=cutOff;
        this.ifClauses = ifClauses;
    }

    public static Algorithm createAlgorithm(List<IfClause> ifClauses, CutoffClause cutOff) {
        return new Algorithm(ifClauses, cutOff);
    }

    public CutoffClause getCutOff() {
        return cutOff;
    }

    public List<IfClause> getIfClauses() {
        return ifClauses;
    }

    public boolean consider() {
        return false;
    }
}
