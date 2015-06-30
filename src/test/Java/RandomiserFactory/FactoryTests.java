package Java.RandomiserFactory;

import Java.Constants.Constants;
import org.junit.Test;

import Java.Controller.ModuleController;
import Java.Randomiser.IntRandomiser;
import Java.Randomiser.Randomiser;
import Java.Randomiser.RandomiserFactory;
import Java.Randomiser.RandomiserFactoryImpl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Fliss on 15/07/14.
 */
public class FactoryTests {

    @Test
    public void shouldGiveAnIntRandomiser() {
        RandomiserFactory randomiserFactory = new RandomiserFactoryImpl();
        int[] buildData = {1,1,1,1,1};
        randomiserFactory.update(Constants.INTEGER, buildData);
        Randomiser randomiser = randomiserFactory.createRandomiser();

        assertTrue(randomiser.getClass() == IntRandomiser.class);
    }
}
