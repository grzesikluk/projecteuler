package eulerproject.level2.problem41;

import eulerproject.level2.problem32.Number;
import eulerproject.tools.primes.Primes;

/*Pandigital prime
Problem 41
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?*/

public class PandigitalPrime {
    private static int SIZE = 8;  //n pandigitals
    private static int res;  //n pandigitals
    private static Number myPrim = new Number(2);


    public static void main(String[] args) {

        Primes pr = new Primes((int) Math.pow(10,SIZE));

        for (int i = 2; i <= Number.getMaxPandig(SIZE); i++) {

            if (pr.isPrime(i)) {
                myPrim.setI(i);

                if (myPrim.isPandigital(SIZE)) {

                    res = i;
                }
            }
        }

        System.out.println(res);

    }
}
