package eulerproject.tools.functions;

import java.util.ArrayList;
import java.util.List;

public class SigmaFunction {

    public long getValue(long k, long n) {

        long[] factors = getIntegerFactors(k);
        long result = 0;

        for (int i = 0; i < factors.length; i++) {

            long factor = 1;

            for (int j = 0; j < n; j++)
                factor *= factors[i];
            result += factor;

        }

        return result;
    }

    private long[] getIntegerFactors(long k) {

        List<Long> arrayList = new ArrayList<>();

        arrayList.add(1L);
        if(k != 1L)
            arrayList.add(k);

        for (long i = 2; i * 2 <= k; i++)
            if (k % i == 0)
                arrayList.add(i);

        return arrayList.stream().mapToLong(s -> s).toArray();
    }

    public long getValueModular(long k, long n, long modulo) {

        long[] factors = getIntegerFactors(k);
        ModularNumberLong result = new ModularNumberLong(modulo, 0);

        for (int i = 0; i < factors.length; i++) {

            ModularNumberLong factor = new ModularNumberLong(modulo, 1L);

            for (int j = 0; j < n; j++)
                factor = factor.multiplyModular(factors[i]);

            result = result.addModular(factor.getValue());

        }

        return result.getValue();
    }


}
