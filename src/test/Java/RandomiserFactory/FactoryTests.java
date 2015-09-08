package Java.RandomiserFactory;

import Java.Constants.ProjectConstants;
import Java.Randomiser.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FactoryTests {

    @Test
    public void shouldGiveAnIntRandomiser() {
        RandomiserFactory randomiserFactory = new RandomiserFactoryImpl();
        double[] buildData = {1,1,1,1,1};
        randomiserFactory.update(ProjectConstants.INTEGER, buildData);
        Randomiser randomiser = randomiserFactory.createRandomiser();

        assertTrue(randomiser.getClass() == IntRandomiser.class);
    }

    @Test
    public void shouldGiveNullWhenGivenIncorrectRandomiserName() {
        RandomiserFactory randomiserFactory = new RandomiserFactoryImpl();
        double[] buildData = {1,1,1,1,1};
        randomiserFactory.update("adfg1325!$", buildData);
        Randomiser randomiser = randomiserFactory.createRandomiser();
        assertTrue(randomiser==(null));
    }

    @Test
    public void shouldGiveAVectorRandomiser() {
        RandomiserFactory randomiserFactory = new RandomiserFactoryImpl();
        double[] buildData = {10,1,1,1,1,1};
        randomiserFactory.update(ProjectConstants.VECTOR, buildData);
        Randomiser randomiser = randomiserFactory.createRandomiser();
        assertTrue(randomiser.getClass() == VectorRandomiser.class);
        assertThat(randomiser.getMatroid().size(), is(10));
    }

}
