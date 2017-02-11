package eulerproject.level2.problem32;
 /*
 * Pandigital products
Problem 32
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example,
the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1
through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 *
 * */


import java.util.ArrayList;
import java.util.HashSet;

public class Pandigital{

    public static void main(String[] args) {
        Permutation pem = new Permutation("123456789");
        ArrayList<Integer> list = new ArrayList<Integer>();
        HashSet<Integer>   set = new HashSet<Integer>();
        Integer  result = 0;



        for(String permutation: pem.getAllPermutations()){
              list.addAll(checkPermutation(permutation));
        };

        for(Integer i:list) {  //make results unique
            set.add(i);

        }

        for (Integer k:set) {
            System.out.println(k);
            result+=k;

        }

        System.out.println(result);


    }


    public static ArrayList<Integer> checkPermutation(String str) {
        ArrayList<Integer> retList = new ArrayList<Integer>();

        for (int i = 1; i <= str.length()-1 ; i++) {
            for (int j = i+1; j <= str.length()-1; j++) {
                Number a = new Number(str.substring(0,i));
                Number b = new Number(str.substring(i,j));
                Number c = new Number(str.substring(j,str.length()));
                Number d = Number.multiply(a,b);

                if (c.equals(d)) {
                    retList.add(c.getI());
//                    System.out.println(a+" "+b+" "+c);
                }

            }
        }

        return retList;
    }
}
