package Java.RandomiserFactory;

import Java.Constants.ProjectConstants;
import Java.Randomiser.IntRandomiser;
import Java.Randomiser.Randomiser;
import Java.Randomiser.RandomiserFactory;
import Java.Randomiser.RandomiserFactoryImpl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Fliss on 15/07/14.
 */
public class FactoryTests {

    @Test
    public void shouldGiveAnIntRandomiser() {
        RandomiserFactory randomiserFactory = new RandomiserFactoryImpl();
        double[] buildData = {1,1,1,1,1};
        randomiserFactory.update(ProjectConstants.INTEGER, buildData);
        Randomiser randomiser = randomiserFactory.createRandomiser();

        assertTrue(randomiser.getClass() == IntRandomiser.class);
    }
}
