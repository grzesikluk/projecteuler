package eulerproject.tools.sequences;

import eulerproject.tools.functions.ModularNumberLong;
import eulerproject.tools.functions.SigmaFunction;


public class SequenceGeneratorImplA109976 implements SequenceGenerator {
    private long modulo;
    SigmaFunction sigmaFunction;

    public SequenceGeneratorImplA109976(SigmaFunction sigmaFunction) {
        this.sigmaFunction = sigmaFunction;
    }

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

        ModularNumberLong result = new ModularNumberLong(modulo, 0);

        for (long k = 1; k <= Math.floorDiv((n + 1), 2); k++) {
            result = result.addModular(sigmaFunction.getValueModular(n - 2 * k + 2, k - 1, modulo));
        }

        return result.getValue();
    }

    @Override
    public long getSize() {
        return 0;
    }
}
