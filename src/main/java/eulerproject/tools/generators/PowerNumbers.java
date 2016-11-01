package eulerproject.tools.generators;

/**
 * Created by Lukasz on 2016-10-31.
 */
public class PowerNumbers {

    public static long getCubeNumber(long i) {
        long res = i*i*i;
        if (res<0)
            throw new IllegalArgumentException("The number is too big " + i);

        return res;
    }
}
