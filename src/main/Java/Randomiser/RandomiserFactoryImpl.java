package Java.Randomiser;

import Java.Constants.ProjectConstants;

/**
 * Created by Fliss on 14/07/14.
 */
public class RandomiserFactoryImpl implements RandomiserFactory {
    private String randomiserType;
    private long[] buildInfo;


    public RandomiserFactoryImpl() {
        buildInfo = new long[]{0, 0, 0, 0, 0, 0, 0, 0};
        randomiserType = "";

    }

    @Override
    public Randomiser createRandomiser() {
        switch (randomiserType) {
            case ProjectConstants.INTEGER:
                return new IntRandomiser(buildInfo[0], buildInfo[1], buildInfo[2], buildInfo[3], buildInfo[4], (int) buildInfo[5]);

            default:
                return null;
        }
    }


    @Override
    public void update(String randomiserType, long[] buildData) {
        this.randomiserType = randomiserType;
        int size = 8;
        if (buildData.length < 8) {
            size = buildData.length;
        }
        for (int i = 0; i < size; i++) {
            buildInfo[i] = buildData[i];
        }
    }
}
