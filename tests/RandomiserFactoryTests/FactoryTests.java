package RandomiserFactoryTests;

import Controller.*;
import Randomiser.*;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
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
