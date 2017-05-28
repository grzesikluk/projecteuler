package eulerproject.level4.problem84;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    private static final long MAX = 100_000_000L;
    private static long[] statistics;

    public static void main(String[] args) {

        statistics = new long[Board.FIELDS_COUNT];

        Board monopolyBoard = new Board();
        ChanceCards chanceCards = new ChanceCards();
        ComunityChestCards comunityChestCards = new ComunityChestCards();
        DicePair dicePair = new DicePairImpl(6);

        for (long i = 0; i < MAX; i++) {

            int k = dicePair.throwIt();

            if (dicePair.isDoubleDiceThreeTimes()) {
                monopolyBoard.moveToNextByName("JAIL");
            }
            else {
                monopolyBoard.move(k);

                switch (monopolyBoard.currentField().name) {
                    case "G2J":
                        monopolyBoard.moveToNextByName("JAIL");
                        break;
                    case "CC1":
                    case "CC2":
                        monopolyBoard.moveToNextByName(comunityChestCards.getNext());
                        break;
                    case "CH1":
                    case "CH2":
                    case "CH3":
                        monopolyBoard.moveToNextByName(chanceCards.getNext());
                        break;

                    default:


                }
            }

            statistics[monopolyBoard.currentField().number]++;

        }

        Map<Long, Integer> sortMap = new HashMap<>();

        for (int i = 0; i < statistics.length; i++)
            sortMap.put(statistics[i], i);

        for (Long l : sortMap.keySet().stream().sorted().collect(Collectors.toList())) {
            System.out.println((double)l*100/MAX + " " + sortMap.get(l));
        }


    }


}
