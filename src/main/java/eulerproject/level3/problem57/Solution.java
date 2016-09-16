package eulerproject.level3.problem57;

import java.math.BigInteger;

/**
 * Created by grzesikl on 15/09/2016.
 */
public class Solution {
    public static final int MAX = 30;

    public static void main(String[] args) {
        System.out.println(checkNormal());

    }

    public static Fraction getIteration(int k) {
        Fraction temp = new Fraction(2, 1);

        temp = temp.revertFraction();

        for (int i = 1; i < k; i++) {
            temp = new Fraction(2, 1).add(temp);
            temp = temp.revertFraction().simplifyFraction();
        }

        return new Fraction(1, 1).add(temp).simplifyFraction();
    }

    public static BigFraction getBigIteration(int k) {
        BigFraction temp = new BigFraction(new BigInteger("2"), new BigInteger("1"));
        BigFraction temp2 = new BigFraction(temp);


        temp = temp.revertFraction();

        for (int i = 1; i < k; i++) {
            temp = temp2.add(temp);
            temp = temp.revertFraction().simplifyFraction();
        }

        return new BigFraction(new BigInteger("1"), new BigInteger("1")).add(temp).simplifyFraction();
    }

    public static int checkNormal() {
        Fraction iterFraction;
        int counter = 0;

        for (int i = 1; i <= MAX; i++) {
            iterFraction = getIteration(i);

            if (new Long(iterFraction.getNominator()).toString().length() >
                    new Long(iterFraction.getDenominator()).toString().length()) {
                counter++;
            }
        }
        return counter;
    }

}
