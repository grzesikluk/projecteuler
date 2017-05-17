package eulerproject.tools.sequences;

import eulerproject.tools.functions.ModularNumberLong;
import eulerproject.tools.functions.SigmaFunction;


public class SequenceGeneratorImplA109976 implements SequenceGenerator {
    private long modulo;

    @Override
    public void init(long modulo) {
        this.modulo = modulo;
    }

    @Override
    public void init(long modulo, int[] primes) {
        this.modulo = modulo;

    }

    @Override
    public long getNumber(long n) {

        SigmaFunction sigmaFunction = new SigmaFunction();
        ModularNumberLong result = new ModularNumberLong(modulo, 0);

        for (long k = 1; k <= Math.floorDiv((n + 1) , 2); k++) {
            result = result.addModular(sigmaFunction.getValueModular(modulo,k - 1, n - 2 * k + 2));
        }

        return result.getValue();
    }

    @Override
    public long getSize() {
        return 0;
    }
}
