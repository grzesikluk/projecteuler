package eulerproject.level4.problem78;

import eulerproject.tools.functions.SigmaFunctionBerndtImpl;
import eulerproject.tools.primes.Primes;
import eulerproject.tools.sequences.SequenceGenerator;
import eulerproject.tools.sequences.SequenceGeneratorImplA109976;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    private final static long MAX = 10_000_000L;
//    private final static long[] MAX_ARRAY = {10L, 100L, 1_000L, 10_000L, 100_000L, 1000_000L};
    private final static long[] MAX_ARRAY = {1000_000L};

    public static void main(String[] args) {

        Primes primes = new Primes((int)MAX);
        primes.init();

        for (long modulo : MAX_ARRAY) {
            SequenceGenerator sequenceGenerator = new SequenceGeneratorImplA109976(new SigmaFunctionBerndtImpl(primes));

            System.out.println("Doing modulo = " + modulo);
            sequenceGenerator.init(modulo);

            List<Long> cachedValues = new ArrayList<>();


            if (cachedValues.isEmpty()) {
                //first iteration
                for (long i = 1; i < MAX; i++) {

                    if((i % 1000) == 0)
                        System.out.println((double)i/MAX);

                    if (sequenceGenerator.getNumber(i) == 0L) {
                        System.out.println("Found -> " + i);
                        cachedValues.add(i);
                    }

                }

            } else {
                List<Long> newCachedValues = new ArrayList<>();
                newCachedValues.clear();

                for(long i:cachedValues)
                    if (sequenceGenerator.getNumber(i) == 0L)
                        newCachedValues.add(i);

                cachedValues.clear();
                cachedValues.addAll(newCachedValues);

            }

            System.out.println(cachedValues);

        }


    }


}
