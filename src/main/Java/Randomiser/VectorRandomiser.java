package Java.Randomiser;


import org.apache.commons.math3.random.MersenneTwister;

import java.util.ArrayList;
import java.util.List;

public class VectorRandomiser implements Randomiser<VectorCandidate> {
    private int index;
    private List<VectorCandidate> matroid;
    private List<VectorCandidate> solution;
    private int size;

    public VectorRandomiser(double max, double a, double b, double c, double d, int freq) {
        index=0;
        MersenneTwister randomNumberGenerator = new MersenneTwister();
        MersenneTwister directionGenerator = new MersenneTwister(System.currentTimeMillis());
        size = (int) max*freq;
        List<SortingElement<VectorCandidate>> unorderedList = new ArrayList();
        for (int x = 0; x<max; x++) {
            for (int j = 0; j<freq; j++) {
                double magnitude = a*Math.pow(x,3) + b*Math.pow(x, 2) + c*x + d;
                int direction = directionGenerator.nextInt(360);
                int index = randomNumberGenerator.nextInt(size);
                VectorCandidate candidate = new VectorCandidate(magnitude, direction);
                unorderedList.add(new SortingElement<>(candidate, index));
            }
        }

        unorderedList.sort(new Comparer());

        matroid = new ArrayList<>();
        for (SortingElement<VectorCandidate> aMat : unorderedList) {
            matroid.add(aMat.getValue());
        }
        solution = new ArrayList<>();

    }

    @Override
    public VectorCandidate getItem() {
        return matroid.get(index);
    }

    @Override
    public List<VectorCandidate> getMatroid() {
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
    public List<VectorCandidate> getSolution() {
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
    public List<VectorCandidate> getAlreadySeen() {
        List<VectorCandidate> alreadySeen = matroid.subList(0, index);
        return alreadySeen;
    }

    @Override
    public int getSize() {
        return matroid.size();
    }

    @Override
    public String toString() {
        String matroidContents = "";
        int num = 1;
        for (VectorCandidate element : matroid) {
            matroidContents += element.toString()+", ";
            if (num==10) {
                matroidContents += "\r";
                num=0;
            }
            num++;
        }
        return matroidContents;
    }

}
