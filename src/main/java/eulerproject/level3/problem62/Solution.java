package eulerproject.level3.problem62;

import eulerproject.tools.generators.PowerNumbers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2016-10-31.
 */
public class Solution {
    private static List<String> cubes;
    public static long MAX = 10000;
    public static int PERMNO = 5;

    static {
        cubes = new LinkedList<>();

        for (long i = 0; i < MAX; i++)
            cubes.add(new Long(PowerNumbers.getCubeNumber(i)).toString());
        System.out.println("static initiated");
    }


    private static boolean isCube(String k) {
        return cubes.contains(k);
    }

    public static void main(String[] args) {
        int i =0;

        while(!cubes.isEmpty()) {

            List<String> list = getCubePermutations(cubes.get(0));

            if(list.size() == PERMNO) {
                System.out.println("Found solution for " + PERMNO +" permutations "+cubes.get(i));
                System.out.println("Cubes size is " + cubes.size());
                System.exit(0);
            }
            else {
                cubes.removeAll(list);
            }

        }

    }


    public static int getNumberOfCubePermutations(String s) {
        return getCubePermutations(s).size();

    }

    public static List<String> getCubePermutations(String s) {
        List<String> result = new LinkedList<>();

        List<Character> sCharList = convertToCharList(new Long(s).toString().toCharArray());
        sCharList.sort((Character l, Character m)->l-m);

        for(int i=0;i<cubes.size();i++)
            if(isPermutation(sCharList,cubes.get(i)))
                result.add(cubes.get(i));

        return result;

    }


    /**
     * a list must be sorted first!
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isPermutation(List<Character> a, String b) {
        List<Character> aChars =  a;
        List<Character> bChars =  convertToCharList( b.toCharArray());

        bChars.sort((Character l, Character m)->l-m);

        if(aChars.size()!= bChars.size())
            return false;

        for(int i=0;i<aChars.size();i++) {
            if(!aChars.get(i).equals(bChars.get(i)))
                return false;
        }
        return true;

    }


    public static boolean isPermutation(String a, String b) {
        List<Character> aChars =  convertToCharList( a.toCharArray());

        aChars.sort((Character l, Character m)->l-m);

        return isPermutation(aChars,b);

    }

    public static List<Character> convertToCharList(char[] a) {
        List<Character> result = new LinkedList<>();

        for(int i=0;i<a.length;i++)
            result.add(a[i]);
        return result;
    }


}
