package Java.Algorithm.AlgorithmBuilder;

import java.util.LinkedList;

/**
 * Created by seraphiana on 22/04/15.
 */
public class Algorithm {
    private LinkedList<IfClause> ifClauses;
    private CutoffClause cutOff;

    public Algorithm(LinkedList<IfClause> ifClauses, CutoffClause cutOff) {
        this.cutOff=cutOff;
        this.ifClauses = ifClauses;
    }

    public CutoffClause getCutOff() {
        return cutOff;
    }

    public LinkedList<IfClause> getIfClauses() {
        return ifClauses;
    }
}
