package Java.Randomiser;

import java.util.Comparator;

/**
 * Created by seraphiana on 17/07/14.
 */
public class Comparer implements Comparator<SortingElement> {
    @Override
    public int compare(SortingElement o1, SortingElement o2) {
        int i = o1.getIndex();
        int j = o2.getIndex();
        if (i==j) {
            return 0;
        } else if (i<j) {
            return -1;
        } else return +1;
    }

}
