package Java.Randomiser;

import Java.Algorithm.AlgorithmBuilder.Token;
import Java.Constants.ProjectConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class VectorCandidateTest {

    private VectorCandidate k;
    private VectorCandidate j;
    private VectorCandidate i;
    private VectorCandidate l;

    @Before
    public void buildUp() {
        i = new VectorCandidate(2d, 90);
        j = new VectorCandidate(3d, 180);
        k = new VectorCandidate(4d, 270);
    }

    @Test
    public void shouldCreateAVectorFromAPolarStringRepresentation() {
        String value = "[5,270]";
        VectorCandidate vectorCandidate = VectorCandidate.createFromString(value);
        assertThat(vectorCandidate, is(new VectorCandidate(5d, 270)));
    }

    @Test
    public void ShouldTellWhenTwoCandidatesArentEqual() {
        VectorCandidate a = new VectorCandidate(5d, 100);
        VectorCandidate b = new VectorCandidate(7d, 200);
        assertFalse(a.equals(b));
    }

    @Test
    public void ShouldTellWhenTwoCandidatesArentEqualWhenAMagnitudeIsZero() {
        VectorCandidate a = new VectorCandidate(7d, 300);
        VectorCandidate b = new VectorCandidate(7d, 660);
        assertTrue(a.equals(b));
    }

    @Test
    public void testOperateWithPlus() throws Exception {
        Assert.assertThat(j.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "+"), k), is(new VectorCandidate(5d, 233)));
    }

    @Test
    public void testOperateWithDivide() throws Exception {
        Assert.assertThat(i.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "/"), j), is(new VectorCandidate(2d, 90)));
    }

    @Test
    public void testOperateWithTimes() throws Exception {
        Assert.assertThat(i.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "*"), j), is(new NumComparableObject(0)));
    }

    @Test
    public void shouldMultiplyUsingScalar() throws Exception {
        assertThat(i.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "*"), new NumComparableObject(2)), is(new VectorCandidate(4d, 90)));
    }

    @Test
    public void testOperateWithSubtract() throws Exception {
        Assert.assertThat(j.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "-"), k), is(is(new VectorCandidate(5d, 126))));
    }

    @Test
    public void testCloneIsNotTheSame() throws Exception {
        ComparableObject d = i.clone();
        i = new VectorCandidate(3d, 100);
        Assert.assertFalse(i.equals(d));
    }
    @Test
    public void testCloneIsEqual() throws Exception {
        ComparableObject d = i.clone();
        Assert.assertTrue(i.equals(d));
    }

}