package Java.Randomiser;

import Java.Algorithm.AlgorithmBuilder.Token;
import Java.Constants.ProjectConstants;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NumComparableObjectTest {


    private ComparableObject c;
    private ComparableObject b;
    private ComparableObject a;

    @Before
    public void buildup() {
        a = NumComparableObject.createNew(5);
        b = NumComparableObject.createNew(3);
        c = NumComparableObject.createNew(6);
    }

    @Test
    public void testOperateWithPlus() throws Exception {
        assertThat(a.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "+"), b), is(NumComparableObject.createNew(8)));
    }

    @Test
    public void testOperateWithDivide() throws Exception {
        assertThat(c.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "/"), b), is(NumComparableObject.createNew(2)));
    }

    @Test
    public void testOperateWithTimes() throws Exception {
        assertThat(a.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "*"), b), is(NumComparableObject.createNew(15)));
    }

    @Test
    public void testOperateWithSubtract() throws Exception {
        assertThat(b.operateWith(new Token(ProjectConstants.PLUSMINUSTIMESDIVIDE, "-"), a), is(NumComparableObject.createNew(-2)));
    }

    @Test
    public void testClone() throws Exception {
        ComparableObject d = a.clone();
        a.times(b);
        assertFalse(a.equals(d));
    }
}