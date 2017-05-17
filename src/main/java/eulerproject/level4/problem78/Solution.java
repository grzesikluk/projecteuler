package eulerproject.level4.problem78;

import eulerproject.tools.sequences.SequenceGenerator;
import eulerproject.tools.sequences.SequenceGeneratorImplA109976;

public class Solution {
    private final static long MODULO = 1000000L;
    private final static long MAX = 1000000L;

    public static void main(String[] args) {
        SequenceGenerator sequenceGenerator = new SequenceGeneratorImplA109976();
        sequenceGenerator.init(MODULO);


        long i = 1;

        while (i < MAX) {
            if (sequenceGenerator.getNumber(i) == 0) {
                System.out.println(i);
                break;
            }
            i++;
        }


    }


}
