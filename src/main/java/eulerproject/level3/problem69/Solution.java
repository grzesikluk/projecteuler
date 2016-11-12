package eulerproject.level3.problem69;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class Solution {

    private static final int MAX = 1000000;

    public static void main(String[] args) {

        int store = 0;
        double val = 0,temp = 0;

        for(int i=0;i<MAX;i++) {

            if((temp=(double)i/(double)eulersTotientFunction(i))> val) {
                store = i;
                val = temp;
                System.out.println("Found new " + val + " is for n=" +store);
            }

        }

        System.out.println("MAx = " + val + " is for n=" +store);
    }


    public static int eulersTotientFunction(int k) {
        int counter = 1;
        Set<Integer> notPrimes = new HashSet();

        for (int i = 2; i < k; i++) {
            if (!notPrimes.contains(new Integer(i)) && k % i != 0)
                counter++;
            else {
                for (int j = 1; j * i < k; j++)
                    notPrimes.add(new Integer(i * j));

            }
        }
        return counter;
    }


}
