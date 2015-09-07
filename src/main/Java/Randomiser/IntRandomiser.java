package Java.Randomiser;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.random.MersenneTwister;

public class IntRandomiser implements Randomiser<NumComparableObject> {
    private final int size;
    private List<NumComparableObject> matroid;
    private int index;
    private Set<NumComparableObject> solution;


    public IntRandomiser(int max) {
        this(max, 0, 0, 1, 1, 1);
    }

    // constructor that creates ints as a linear function, with duplicates
    public IntRandomiser(int max, int frequency) {
        this(max, 0, 0, 1, 1, frequency);
    }


    // constructor that creates objects as a cubic function
    public IntRandomiser(double max, double a, double b, double c, double d, double freq) {

        index = 0;
        MersenneTwister randomGen = new MersenneTwister();

        size = (int) ((max) * freq);

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
            matroid.add(ComparableObjectBuilder.createWith(aMat.getValue()));
        }
        solution = new HashSet<>();
    }

    @Override
    public NumComparableObject getItem() {
        return matroid.get(index);
    }

    @Override
    public List<NumComparableObject> getMatroid() {
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
    public Set<NumComparableObject> getSolution() {
        return solution;
    }

    @Override
    public void alert() {
        index++;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public List<NumComparableObject> getAlreadySeen() {
        List<NumComparableObject> alreadySeen = matroid.subList(0, index);
        return alreadySeen;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String matroidContents = "";
        int num = 1;
        for (NumComparableObject element : matroid) {
            matroidContents += element+", ";
            if (num==10) {
                matroidContents += "\r";
                num=0;
            }
            num++;
        }
        return matroidContents;
    }

}
