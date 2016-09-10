package eulerproject.level2.problem29;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by grzesikl on 18/08/2016.
 */
public class Solution {
    public static final int MAX = 100;

    public static void main(String[] args) {
        Set<BigInteger> mySet = new HashSet<>();

        for (int a=2;a<=MAX;a++)
            for (int b=2;b<=MAX;b++)
                mySet.add(generatePower(a,b));

//        System.out.println(mySet);
        System.out.println(mySet.size());
        mySet.stream().sorted().forEach(System.out::println);



    }


    public static BigInteger generatePower(int a, int b) {
        BigDecimal dec = new BigDecimal(Math.pow(a,b));

        return new BigInteger(String.valueOf(dec));
    }

}
