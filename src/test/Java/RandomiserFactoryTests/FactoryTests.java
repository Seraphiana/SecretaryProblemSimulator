package Java.RandomiserFactoryTests;

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
        ModuleController controller = mock(ModuleController.class);
        when(controller.getRandomiserType()).thenReturn("Integer");
        RandomiserFactory randomiserFactory = new RandomiserFactoryImpl(controller);
        Randomiser randomiser = randomiserFactory.createRandomiser();
        assertTrue(randomiser instanceof IntRandomiser);
    }
}
