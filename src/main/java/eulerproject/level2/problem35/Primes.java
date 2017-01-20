package net.euler.problems.sol.pr35;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lukasz
 * Date: 20.11.13
 * Time: 22:17
 * To change this template use File | Settings | File Templates.
 */
public class Primes {
    int size;
    double bigSize,BigI,BigJ;
    ArrayList<Boolean> primeMap;

    public boolean isPrime(int k){
        if(k<size) return primeMap.get(k);
        return false;

    }

    public Primes(int size) {
        this.size = size;
        primeMap = new ArrayList<Boolean>(size);
        bigSize = size;

        for (int i = 0; i < size ; i++) {
            primeMap.add(i,true);
        }

        primeMap.set(0,false);
        primeMap.set(1,false);

        for (int i = 2; i < size/2 ; i++) {
            BigI = i;

            for (int j = 2; j < (size/i+1) ; j++) {
                BigJ = j;
                if (BigI*BigJ < bigSize)
                    primeMap.set(i*j,false);
            }
        }
    }
}
