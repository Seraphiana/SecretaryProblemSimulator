package Java.Oracle;

import java.util.Set;

/**
 * Created by Fliss on 04/07/14.
 */
public interface Oracle<T> {

    boolean consider(T value);

    String solution();
}
