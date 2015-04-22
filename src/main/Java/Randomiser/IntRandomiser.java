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
    private int number;
    private MersenneTwister randomGen;
    private Set<Integer> solution;


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
        solution = new HashSet<Integer>();
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
        solution = new HashSet<Integer>();
    }

    public IntRandomiser(int max, int a, int b, int c, int d, int freq) {
        number = 0;
        randomGen = new MersenneTwister();
        int size = (max+1) * freq;
        List<SortingElement<Integer>> mat = new ArrayList<SortingElement<Integer>>();
        int k;
        int val;
        for (int x = 0; x<=max; x++) {
            val = a*x^(3) + b*x^2 + c*x + d;
            for (int n = 1; n<=freq; n++) {
                k = randomGen.nextInt(size);
                mat.add(new SortingElement<Integer>(val, k));
            }
        }
        mat.sort(new Comparer());
        matroid = new ArrayList<Integer>();
        for (SortingElement<Integer> aMat : mat) {
            matroid.add(aMat.getValue());
        }
        solution = new HashSet<Integer>();
    }

    @Override
    public Integer getItem() {
        return matroid.get(number);
    }

    @Override
    public Set<Integer> getMatroid() {
        return new HashSet<Integer>(matroid);
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
        number++;
    }

    @Override
    public int getIndex() {
        return number;
    }

    @Override
    public Set<Integer> getAlreadySeen() {
        List<Integer> alreadySeen = matroid.subList(0, number);
        return new HashSet<Integer>(alreadySeen);
    }

}
