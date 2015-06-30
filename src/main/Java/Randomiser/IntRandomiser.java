package Java.Randomiser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.random.MersenneTwister;

/**
 * Created by Fliss on 15/07/14.
 */
public class IntRandomiser implements Randomiser<Integer> {
    private List<Integer> matroid;
    private int index;
    private MersenneTwister randomGen;
    private Set<Integer> solution;


    public IntRandomiser(int max) {
        this(max, 0, 0, 1, 1, 1);
    }

    // constructor that creates ints as a linear function, with duplicates
    public IntRandomiser(int max, int frequency) {
        this(max, 0, 0, 1, 1, frequency);
    }


    // constructor that creates objects as a cubic function
    public IntRandomiser(int max, int a, int b, int c, int d, int freq) {

        index = 0;
        randomGen = new MersenneTwister();
        int size = 2*(max+1) * freq;

        List<SortingElement<Integer>> mat = new ArrayList<>();
        int k;
        int val;

        for (int x = 0; x<max; x++) {
            
            double dub = a*Math.pow(x,3) + b*Math.pow(x, 2) + c*x + d;
            val = (int) dub;

            for (int n = 0; n<freq; n++) {

                k = randomGen.nextInt(size);

                mat.add(new SortingElement<>(val, k));


            }
        }

        mat.sort(new Comparer());

        matroid = new ArrayList<>();
        for (SortingElement<Integer> aMat : mat) {
            matroid.add(aMat.getValue());

        }
        solution = new HashSet<>();

    }

    @Override
    public Integer getItem() {
        return matroid.get(index);
    }

    @Override
    public List<Integer> getMatroid() {
        return matroid;
    }

    @Override
    public void itemDecision(boolean answer) {
        if(answer) {
            solution.add(getItem());
        }
        alert();
    }

    @Override
    public Set<Integer> getSolution() {
        return solution;
    }

    private void alert() {
        index++;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public Set<Integer> getAlreadySeen() {
        List<Integer> alreadySeen = matroid.subList(0, index);
        return new HashSet<Integer>(alreadySeen);
    }

}
