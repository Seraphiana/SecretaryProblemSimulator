package Java.Randomiser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.math3.random.MersenneTwister;

/**
 * Created by Fliss on 15/07/14.
 */
public class IntRandomiser implements Randomiser<Integer> {
    private List<Integer> matroid;
    private int number;
    private MersenneTwister randomGen;


    public IntRandomiser(int max) {
        number = 0;
        randomGen = new MersenneTwister();
        List<SortingElement<Integer>> mat = new ArrayList<SortingElement<Integer>>();
        int j;
        for (int i = 1; i<=max; i++) {
            j = randomGen.nextInt(max);
            mat.add(new SortingElement<Integer>(i, j));
        }
        mat.sort(new Comparer());
        matroid = new ArrayList<Integer>();
        for (SortingElement<Integer> aMat : mat) {
            matroid.add(aMat.getValue());
        }
    }

    public IntRandomiser(int max, int frequency) {
        number = 0;
        randomGen = new MersenneTwister();
        int size = max*frequency;
        List<SortingElement<Integer>> mat = new ArrayList<SortingElement<Integer>>();
        int k;
        for (int i = 1; i<=max; i++) {
            for (int j = 1; j<=frequency; j++) {
                k = randomGen.nextInt(size);
                mat.add(new SortingElement<Integer>(i, k));
            }
        }
        mat.sort(new Comparer());
        matroid = new ArrayList<Integer>();
        for (SortingElement<Integer> aMat : mat) {
            matroid.add(aMat.getValue());
        }
    }

    @Override
    public Integer getItem() {
        return matroid.get(number);
    }

    @Override
    public List<Integer> getMatroid() {
        return matroid;
    }

    @Override
    public void alert() {
        number++;
    }
}
