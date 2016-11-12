package eulerproject.tools.functions;

/**
 * Created by Lukasz on 2016-11-12.
 */
public class EulersTotient {

//    public static int eulersTotientFunction(int k) {
//        int counter = 1;
//        Set<Integer> notPrimes = new HashSet();
//
//        for (int i = 2; i < k; i++) {
//            if (!notPrimes.contains(new Integer(i)) && k % i != 0)
//                counter++;
//            else {
//                for (int j = 1; j * i < k; j++)
//                    notPrimes.add(new Integer(i * j));
//
//            }
//        }
//        return counter;
//    }


    public static int eulersTotientFunction(int k) {
        int counter = 1;
        boolean[] tab = new boolean[k];

        for (int i = 0; i < tab.length; i++)
            tab[i] = true;

        for (int i = 2; i < k; i++) {
            if (tab[i] == true && k % i != 0)
                counter++;
            else {
                for (int j = 1; j * i < k; j++)
                    tab[i * j] = false;

            }
        }
        return counter;
    }

}
