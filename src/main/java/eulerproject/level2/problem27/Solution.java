package eulerproject.level2.problem27;

import eulerproject.tools.primes.Primes;

public class Solution {

    private static final int MAX = 100000;
    private static final Primes primes;

    static {
        primes = new Primes(MAX);
        primes.init();
    }

    public static void main(String[] args) {
        int max = 0;
        int temp = 0;
        int a_max = 0;
        int b_max = 0;

        System.out.println("Starting ...");

        for(int a = -1000; a < 1000; a++) {
            for (int b = a; b <= 1000; b++ ){
                temp = getNumberOfConsPrimes(a,b);
                if (temp > max) {
                    max = temp;
                    a_max = a;
                    b_max = b;
                    System.out.println("found maximum a="+ a_max + " b="+b_max+ " for number: "+max+" cons primes.");
                }
            }
        }
        System.out.println("Result is a*b = " + a_max*b_max+ " for number: "+max+" cons primes.");

    }

    public static int getNumberOfConsPrimes(int a, int b) {
        int n = 0;
        int temp;

        do {
            temp = Math.abs(quadEquation(a, b, n));
            n++;
        }
        while(primes.isPrime(temp));

        return n-1;
    }

    public static int quadEquation(int a, int b, int n) {
        return n*n+a*n+b;
    }

}
