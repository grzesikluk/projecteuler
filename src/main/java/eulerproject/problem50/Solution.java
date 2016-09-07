package eulerproject.problem50;

/**
 * Created by Lukasz on 2016-08-30.
 */
public class Solution {

    private static final int MAX = 1000000;
    static Primes primes = new Primes(MAX);


    public static void main(String[] args) {
        int maxlength = 0;

        for(int i=2;i<MAX;i=primes.getNextPrime(i)) {
            //System.out.println("Starting from " + i);
            int sum=i;
            int count = 1;

            for(int j=primes.getNextPrime(i);j<MAX;j=primes.getNextPrime(j)) {
                count++;

                if ( (sum+=j) < MAX) {
                    if (primes.isPrime(sum)) {
                        if (count > maxlength) {
                            maxlength=count;
                            System.out.println("Length is =" + maxlength + " prime is " + sum );
                        }


                    }
                }
                else
                    break;

            }

        }



    }


}