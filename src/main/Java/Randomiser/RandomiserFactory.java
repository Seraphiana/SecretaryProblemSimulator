package Java.Randomiser;

/**
 * Created by Fliss on 14/07/14.
 */
public interface RandomiserFactory {
    Randomiser createRandomiser();

    void update(String randomiserType, long[] buildData);
}
