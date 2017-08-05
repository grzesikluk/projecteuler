package eulerproject.tools.functions;

import eulerproject.tools.primes.PrimeFactorization;
import eulerproject.tools.primes.Primes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SigmaFunctionBerndtImpl implements SigmaFunction {

    private Primes primes;
    private int[] primesArray;

    public SigmaFunctionBerndtImpl(Primes primes) {
        this.primes = primes;
        primesArray = primes.toArray();
    }

    public long getValue(long N, long k) {

        long result = 1;

        if (k == 0) {
            result = getNumberOfDivisors(N);

        } else {
            Map<Integer, Integer> primesMap = PrimeFactorization.getPrimeFactorsWithPower(N, primes);

            result = 1;

            for (Integer primeFactor : primesMap.keySet()) {

                long powN = (primesMap.get(primeFactor) + 1) * k; //power
                long powD = k; //power

                result *= (getPower(primeFactor, powN) - 1) / (getPower(primeFactor, powD) - 1);

            }
        }
        return result;
    }

    private long getPower(long k, long pow) {
        long result = 1;
        for (int i = 0; i < pow; i++)
            result *= k;
        return result;
    }

    public long getValueModular(long N, long k, long modulo) {

        ModularNumberLong factor = new ModularNumberLong(modulo, 1L);
        ModularNumberLong result = new ModularNumberLong(modulo, 0);

        if (primes != null && primes.isPrime((int) N)) {

            for (int j = 0; j < k; j++)
                factor = factor.multiplyModular(N);

            if(N != 1)
                factor = factor.addModular(1);

            result = result.addModular(factor);

        } else {

            if (k == 0) {
                result = new ModularNumberLong(modulo, getNumberOfDivisors(N));

            } else {
                result = new ModularNumberLong(modulo, 1);

                Map<Integer, Integer> primesMap = PrimeFactorization.getPrimeFactorsWithPower(N, primesArray);

                for (Integer primeFactor : primesMap.keySet()) {

                    long powN = (primesMap.get(primeFactor) + 1) * k;
                    long powD = k;

                    long nominator = getPower(primeFactor, powN) - 1;
                    long denominator = getPower(primeFactor, powD) - 1;

                    if (denominator == 0L)
                        throw new ArithmeticException(" denominator is zero for M= " + N + " k= " + k + " modulo=" + modulo);


                    result = new ModularNumberLong(modulo, nominator / denominator).multiplyModular(result);

                }
            }
        }
        return result.getValue();
    }

    private long getNumberOfDivisors(long N) {
        List<Long> arrayList = new ArrayList<>();

        arrayList.add(1L);

        if (N != 1L)
            arrayList.add(N);

        for (long i = 2; i * 2 <= N; i++)
            if (N % i == 0)
                arrayList.add(i);

        return arrayList.size();
    }

}
