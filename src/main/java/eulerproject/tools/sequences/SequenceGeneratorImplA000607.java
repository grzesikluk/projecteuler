package eulerproject.tools.sequences;

public class SequenceGeneratorImplA000607 implements SequenceGenerator {
    /*http://oeis.org/A000607
    *    a(n) = (1/n)*Sum_{k=1..n} A008472(k)*a(n-k)
    *
    *
    * */
    private long max;
    private SequenceGenerator sequenceGeneratorA008472;
    private long sum;

    public SequenceGeneratorImplA000607() {
        sequenceGeneratorA008472 = new SequenceGeneratorImplA008472();
    }

    @Override
    public void init(long k) {
        sequenceGeneratorA008472.init(k);
    }

    @Override
    public void init(long k, int[] primes) {
        sequenceGeneratorA008472.init(k, primes);
    }

    @Override
    public long getNumber(long n) {
//        clearSum();
        return getNumberRecursion(n);
    }

    private long getNumberRecursion(long n) {
        // a(n) = (1/n)*Sum_{k=1..n} A008472(k)*a(n-k)
        int sum = 0;

        if (n == 0)
            return 1;
        else if (n == 1)
            return 0;
        else if (n == 2)
            return 1;


        for (int k = 1; k <= n; k++) {
            sum += sequenceGeneratorA008472.getNumber(k) * getNumberRecursion(n - k);
        }
        return sum / n;
    }


    public void clearSum() {
        sum = 0;
    }

    @Override
    public long getSize() {
        return max;
    }
}
