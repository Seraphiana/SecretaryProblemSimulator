package Java.Randomiser;

public interface RandomiserFactory {
    Randomiser createRandomiser();

    void update(String randomiserType, double[] buildData);
}
