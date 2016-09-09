package eulerproject.problem49;

import eulerproject.tools.Permutation;
import eulerproject.tools.PermutationImpl;
import eulerproject.tools.Primes;

import java.util.*;

/**
 * Created by grzesikl on 09/09/2016.
 */
public class Solution {
    public static final int MIN = 1000;
    public static final int MAX = 9999;

    private static Primes primes = new Primes(MAX);

    static class Double {
        int a, b;

        Double(int a, int b) {
            this.a = a;
            this.b = b;
        }

        ArrayList<Integer> asArray() {
            return (ArrayList<Integer>) Arrays.asList(a, b);
        }

        public String toString() {
            return "a= "+a+" b="+b;
        }

    }

    static class Doubles {
        ArrayList<Double> list = new ArrayList<>();

        public void add(Double d) {
            list.add(d);
        }


        public ArrayList<Double> getList() {
            return list;
        }

        public void clear() {
            list.clear();
        }

        public int size() {
            return list.size();
        }

        public String toString() {
            return list.toString();
        }

    }


    public static void main(String[] args) {

        for (int k = MIN; k <= MAX; k++) {
            if (checkCondition(k)) {
//                System.out.println(k);
//               System.exit(0); //found first

            }
        }
    }


    public static boolean checkCondition(int k) {
        LinkedList<Character> numberListChar = convertInteger(k);
        Permutation<Character> perm = new PermutationImpl<Character>();
        ListenerImplCheckProblem49<Character> listener = new ListenerImplCheckProblem49<>();
        LinkedList<Integer> primeList = new LinkedList<>();
        Map<Integer, Doubles> primeListDifferences = new HashMap<>();

        perm.generate(numberListChar.size() - 1, numberListChar, listener);

        for (Integer i : listener.getResults()) {
            if (i < MAX && i > MIN)
                if (primes.isPrime(i)) {
                    primeList.add(i);
                }
        }


        for (int i = 0; i < primeList.size(); i++)
            for (int j = i + 1; j < primeList.size(); j++) {
                int diff = Math.abs(primeList.get(i) - primeList.get(j)); //get diff
                String valString = primeList.get(i).toString() + " " + primeList.get(j).toString();
                Doubles doublesList;
                Double doubleToAdd = new Double(primeList.get(i), primeList.get(j));

                if (primeListDifferences.containsKey(diff)) {

                    doublesList = primeListDifferences.get(diff);
                    doublesList.add(doubleToAdd);

                    primeListDifferences.replace(diff, doublesList);
                } else {
                    doublesList = new Doubles();
                    doublesList.add(doubleToAdd);
                    primeListDifferences.put(diff, doublesList);
                }

            }

        Set<Doubles> doublesSet = new HashSet<>();
        for (Integer diff : primeListDifferences.keySet()) {
            if (primeListDifferences.get(diff).size() > 1 && checkDouble(primeListDifferences.get(diff))) {
//                doublesSet.add(primeListDifferences.get(diff)) ;
                System.out.println(primeListDifferences.get(diff));
            }
//            System.out.println(doublesSet);
            //return true;
        }


        return false;

    }

    public static LinkedList<Character> convertInteger(int k) {
        String kStr = new Integer(k).toString();
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < kStr.length(); i++)
            list.add(kStr.charAt(i));
        return list;
    }

    public static boolean checkDouble(Doubles doubles) {
        if (doubles.size() == 2) {
            return   checkDouble(doubles.getList().get(0),doubles.getList().get(1));
        }
        else if(doubles.size() == 3) {
            return  checkDouble(doubles.getList().get(0),doubles.getList().get(1)) &&
                    checkDouble(doubles.getList().get(1),doubles.getList().get(2)) ;
        }
        else
            return false;
    }


    public static boolean checkDouble(Double a, Double b) {
        return a.a == b.a || a.b == b.a || a.a == b.b || a.b == b.b;
    }

}
