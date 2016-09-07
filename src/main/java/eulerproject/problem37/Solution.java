package eulerproject.problem37;

import java.util.ArrayList;

/**
 * Created by Lukasz on 2016-08-25.
 */
public class Solution {
    public static final int MAX_VALUE = 1000000;

    public static boolean[] primes = new boolean[MAX_VALUE];
    static  {
        generatePrimes();
    }

    public static void main(String[] args) {

        int result =0;
        int counter = 0;

        for(int i = 10;i<MAX_VALUE;i++) {
            if (isTruncatablePrime(i)) {
                System.out.println(i);

                result += i;
                counter++;

                if (counter == 10000)
                    break;
            }

        }
        System.out.println(result);

    }

    public static void generatePrimes() {


        primes[0] = false;
        primes[1] = false;
        for(int i=2;i<MAX_VALUE;i++)
            primes[i] = true;

        for(int i = 2;i<MAX_VALUE/2;i++) {
            for(int j=i+i;j<MAX_VALUE;j+=i) {
                 primes[j]=false;
            }
        }


    }

    public static boolean isPrime(int k) {
        return primes[k];
    }


    public static boolean isTruncatablePrime(int i) {

        if(isPrime(i)) {

          for(Integer a:generateTruncLeft(i))
              if (!isPrime(a))
                  return false;

          for(Integer b:generateTruncRight(i))
                if (!isPrime(b))
                    return false;
            return true;
        }

       return false;

    }


    public static ArrayList<Integer> generateTruncLeft(int k) {

        String sInt = new Integer(k).toString();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i<sInt.length();i++) {
            result.add(new Integer(sInt.substring(i,sInt.length())));
        }
        return result;

    }


    public static ArrayList<Integer> generateTruncRight(int k) {

        String sInt = new Integer(k).toString();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i<sInt.length();i++) {
            result.add(new Integer(sInt.substring(0, sInt.length()-i)));
        }
        return result;

    }

}
