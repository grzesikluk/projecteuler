package net.euler.problems.sol.pr35;
import net.euler.problems.sol.pr32.Number;
/**
 Circular primes
 Problem 35
 The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

 There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

 How many circular primes are there below one million?
 */
public class CircularPrimes {

    public static int SIZE = 1000000;
    private static boolean isCircPrime;
    private static int counter =0;

    public static void main(String[] args) {
        Primes p = new Primes(SIZE);

        Number my = new Number(123);

        for (int i = 1; i < SIZE; i++) {
            my.setI(i);

            isCircPrime = true;
            for(Integer d: my.getAllRotations()) {

               //System.out.println(d);
               if (p.isPrime(d) != true)
                    isCircPrime = false;

            }

            if (isCircPrime == true) counter++;


        }

        System.out.println(counter);


    }
}
