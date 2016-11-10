package eulerproject.level3.problem65;

import eulerproject.tools.fractions.BigFraction;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2016-11-07.
 */
public class Solution {
    public static final int MAX = 100;

    public static void main(String[] args) {

        List<Integer> convs = getConvergentsListForEulerConstant(MAX);

        int i=convs.size()-1;

        BigFraction next = new BigFraction(new BigInteger("1"),new BigInteger(convs.get(i).toString()));

        while(i--> 0) {
            next = getNextPart(convs.get(i),next);
//            System.out.println(next);
        }
        System.out.println(next.revertFraction());
        System.out.println(sumOfDigits(next.revertFraction().getNominator().toString()));

    }


    public static List<Integer> getConvergentsListForEulerConstant(int max) {
        List<Integer> result = new LinkedList<>();

        result.add(new Integer(2));

        int i = 1;
        int k = 1;

        while (i < max) {
            if ((i + 1) % 3 == 0) {
                result.add(new Integer(2 * k));
                k++;
            }
            else
                result.add(new Integer(1));
            i++;
        }

        return result;
    }

    /**
     * Return 1/(conv + fraction)
     * @param conv
     * @param input
     * @return
     */
    public static BigFraction getNextPart(Integer conv, BigFraction input) {
        BigFraction result = new BigFraction(new BigInteger(conv.toString()),new BigInteger("1"));

        result = result.add(input);
        result = result.simplifyFraction();
        result = result.revertFraction();

        return result;

    }


    public static int sumOfDigits(String s) {
        int result =0;

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            result += (int)(c-48);
        }
        return result;


    }


}
