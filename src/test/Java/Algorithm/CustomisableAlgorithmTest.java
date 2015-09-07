package Java.Algorithm;

import Java.Algorithm.AlgorithmBuilder.*;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomisableAlgorithmTest {
    CutoffClause cutoffClause;
    IfClause ifClause;
    IfClause ifClause1;
    private int sampleSize;
    LinkedList<IfClause> ifClauses;
    private ComparableObject five;
    private ComparableObject ten;

    @Before
    public void buildUp() {
        cutoffClause = mock(CutoffClause.class);
        ifClause = mock(IfClause.class);
        ifClause1 = mock(IfClause.class);
        ifClauses = new LinkedList<>();
        sampleSize = 50;
        five = ComparableObject.createNew(5d);
        ten = ComparableObject.createNew(10d);
    }

    @Test
    public void shouldSayNoWhenTheElementIsBeforeTheCutOff() {
        when(cutoffClause.calculateCutOff(anyInt())).thenReturn(25);
        Algorithm algorithm = CustomizableAlgorithm.createAlgorithm(ifClauses, cutoffClause, sampleSize);
        assertThat(algorithm.consider(five, 10), is(false));
    }

    @Test
    public void shouldSayNoWhenTheIfStatementSaysNo() {
        when(cutoffClause.calculateCutOff(anyInt())).thenReturn(5);
        ifClauses.add(ifClause);
        when(ifClause.consider(five, ten)).thenReturn(false);
        Algorithm algorithm = CustomizableAlgorithm.createAlgorithm(ifClauses, cutoffClause, sampleSize);
        assertThat(algorithm.consider(five, 10), is(false));
    }

    @Test
    public void shouldSayYesWhenTheIfStatementSaysYes() {
        when(cutoffClause.calculateCutOff(anyInt())).thenReturn(5);
        ifClauses.add(ifClause);
        when(ifClause.consider(any(), any())).thenReturn(true);
        Algorithm algorithm = CustomizableAlgorithm.createAlgorithm(ifClauses, cutoffClause, sampleSize);
        assertThat(algorithm.consider(five, 10), is(true));
    }

    @Test
    public void shouldSayNoWhenAnyIfStatementSaysNo() {
        when(cutoffClause.calculateCutOff(anyInt())).thenReturn(5);
        ifClauses.add(ifClause);
        ifClauses.add(ifClause1);
        when(ifClause.consider(five, ten)).thenReturn(true);
        when(ifClause1.consider(five, ten)).thenReturn(false);
        Algorithm algorithm = CustomizableAlgorithm.createAlgorithm(ifClauses, cutoffClause, sampleSize);
        assertThat(algorithm.consider(five, 10), is(false));
    }

    @Test
    public void shouldSayYesWhenAllIfStatementSaysYes() {
        when(cutoffClause.calculateCutOff(anyInt())).thenReturn(5);
        ifClauses.add(ifClause);
        ifClauses.add(ifClause1);
        when(ifClause.consider(any(), any())).thenReturn(true);
        when(ifClause1.consider(any(), any())).thenReturn(true);
        Algorithm algorithm = CustomizableAlgorithm.createAlgorithm(ifClauses, cutoffClause, sampleSize);
        assertThat(algorithm.consider(five, 10), is(true));
    }
}
