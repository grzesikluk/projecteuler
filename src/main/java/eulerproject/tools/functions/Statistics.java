package eulerproject.tools.functions;

import java.util.Arrays;

/**
 * Created by Lukasz on 2017-03-07.
 */
public class Statistics {

    public static double median(int[] m) {
        Arrays.sort(m); //make sure this happens

        int middle = m.length/2;
        if (m.length%2 == 1) {
            return m[middle];
        } else {
            return (m[middle-1] + m[middle]) / 2.0;
        }
    }
    
}
