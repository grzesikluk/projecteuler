package eulerproject.level3.problem64;

import eulerproject.tools.StringHelper;
import eulerproject.tools.fractions.ContinuedFraction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lukasz on 2016-11-02.
 */
public class Solution {

    public static final int MAX = 10000;
    public static final int FACTOR_LIMIT = 2500;


    private static Set<Long> cubes;

    static {
        cubes = new HashSet<>();

        for (int i = 1; i < (int) Math.sqrt(MAX) + 1; i++)
            cubes.add(new Long(i * i));

    }

    public static void main(String[] args) {
        int counter = 0;

        for (int i = 1; i <= MAX; i++) {

            if (!cubes.contains(new Long(i))) {
                List<Integer> factors = ContinuedFraction.getPartialQuotientsForQuadraticSurd(i,FACTOR_LIMIT);
                String factorsString = arrayListToString(factors);

                List<String> period = Arrays.asList( StringHelper.findPeriodInSubstring(factorsString, 0).replace(" ","").split(","));

                if ((period.size()-1) % 2 != 0 )
                    counter++;

            }
        }

        System.out.println("Odd period factors number is " + counter);

    }

    private static String arrayListToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        for (Integer i : list) {
            sb.append(i.toString());
            sb.append(",");
        }

        return sb.toString();

    }


}