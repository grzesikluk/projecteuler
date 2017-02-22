package eulerproject.level3.problem74;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by grzesikl on 22/02/2017.
 */
public class Solution {
    public static final int MAX = 1000000;
    public static final int SIZE = 60;

    public static void main(String[] args) {
        int counter=0;

        for(int i=0;i<MAX;i++) {
            if(getChainListForFactorials(i).size() == SIZE)
                counter++;
        }
        System.out.println(counter);



    }


    public static int getFactorial(int k) {
        if(k==0 || k==1)
            return 1;
        else
            return getFactorial(k-1)*k;
    }


    public static int getSumOfFactorialsOfDigits(int k) {
        int result =0;

        for(byte c:Integer.toString(k).getBytes()) {
            result+=getFactorial(c-48);
        }

        return result;
    }

    public static Set<Integer> getChainListForFactorials(int k) {
        Set<Integer> result = new LinkedHashSet<>();

        result.add(k);

        Integer i = getSumOfFactorialsOfDigits(k);

        while(!result.contains(i)) {
            result.add(i);
            i = getSumOfFactorialsOfDigits(i);
        }

        return result;
    }


}
