package eulerproject.level3.problem61;

import eulerproject.tools.generators.PolygonalNumbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Lukasz on 2016-10-31.
 */
public class Polygonals {

    private static Map<PolygonNumber.polyTypes, List<Integer>> polygonals = new HashMap<>();


    public final static int MIN = 1000;
    public final static int MAX = 9999;

    /**
     * For set of number (4 digits assumed) last two digits are start of next number.
     *
     * @param k
     */
    public static boolean isCyclic(List<Integer> k) {
        List<Integer> inputList = new ArrayList<>(k);
        List<Integer> cyclicList = new LinkedList<>();

        int tempIx = 0;
        cyclicList.add(inputList.get(0));
        inputList.remove(0);

        while (cyclicList.size() != k.size()) {
            boolean foundNext = false;

            for (Integer i : inputList) {
                if (getFirstTwoDigits(i).equals(getLastTwoDigits(cyclicList.get(tempIx)))) {
                    //found next cyclic
                    foundNext = true;
                    cyclicList.add(i);
                    inputList.remove(i);
                    break;

                }
            }

            if (foundNext == false)
                return false;
            tempIx++;

        }

        if (!getFirstTwoDigits(cyclicList.get(0)).equals(getLastTwoDigits(cyclicList.get(cyclicList.size() - 1))))
            return false;

        return cyclicList.size() == k.size();
    }

    public static boolean isCyclic(int[] tab) {
        List<Integer> list = IntStream.of(tab).boxed().collect(Collectors.toList());
        return isCyclic(list);
    }

    public static String getFirstTwoDigits(int k) {
        String kStr = Integer.toString(k);

        return (kStr.length() == 4) ? kStr.substring(0, 2) : "";
    }

    public static String getLastTwoDigits(int k) {
        String kStr = Integer.toString(k);

        return (kStr.length() == 4) ? kStr.substring(2, 4) : "";
    }

    public static boolean inRange(int k) {
        return k >= MIN && k <= MAX;
    }

    public static void initPolygonals() {
        int val = 0;

        List<Integer> P3 = new ArrayList<>();
        List<Integer> P4 = new ArrayList<>();
        List<Integer> P5 = new ArrayList<>();
        List<Integer> P6 = new ArrayList<>();
        List<Integer> P7 = new ArrayList<>();
        List<Integer> P8 = new ArrayList<>();

        /*
        Init triangular.
         */
        for (int i = 0; i < MAX; i++) {
            val = PolygonalNumbers.getTriangularNumber(i);
            if (inRange(val)) {
                P3.add(val);
            } else
                continue;
        }
        polygonals.put(PolygonNumber.polyTypes.TRI, P3);

        /*
        Init square.
         */
        for (int i = 0; i < MAX; i++) {
            val = PolygonalNumbers.getSquareNumber(i);
            if (inRange(val)) {
                P4.add(val);
            } else
                continue;
        }
        polygonals.put(PolygonNumber.polyTypes.SQU, P4);


        /*
        Init penta.
         */
        for (int i = 0; i < MAX; i++) {
            val = PolygonalNumbers.getPentagonalNumber(i);
            if (inRange(val)) {
                P5.add(val);
            } else
                continue;
        }

        polygonals.put(PolygonNumber.polyTypes.PEN, P5);

                /*
        Init hexa.
         */
        for (int i = 0; i < MAX; i++) {
            val = PolygonalNumbers.getHexagonallNumber(i);
            if (inRange(val)) {
                P6.add(val);
            } else
                continue;
        }

        polygonals.put(PolygonNumber.polyTypes.HEX, P6);

        /*
        init Hepta
         */
        for (int i = 0; i < MAX; i++) {
            val = PolygonalNumbers.getHeptagonalNumber(i);
            if (inRange(val)) {
                P7.add(val);
            } else
                continue;
        }

        polygonals.put(PolygonNumber.polyTypes.HEP, P7);

        /*
        init octa
         */
        for (int i = 0; i < MAX; i++) {
            val = PolygonalNumbers.getOctagonalNumber(i);
            if (inRange(val)) {
                P8.add(val);
            } else
                continue;
        }
        polygonals.put(PolygonNumber.polyTypes.OCT, P8);


    }

    public static      Map<PolygonNumber.polyTypes, List<Integer>> getPolygonals() {
        return polygonals;
    }

}
