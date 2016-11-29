package eulerproject.tools.sequences;

/**
 * Created by grzesikl on 29/11/2016.
 */
public interface SequenceGenerator {
    void init(long k);
    void init(long k, int[] primes);
    long getNumber(long k);
    long getSize();
}
