package eulerproject.newest.problem608;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Lukasz on 2017-08-05.
 */
public class FactorsFinder {

    private long[] primeDivisors;
    private long[] multiplicity;
    private List<Long> allFactors;

    public FactorsFinder(Map<Integer, Integer> primePowerFactorisationMap) {
        primeDivisors = new long[primePowerFactorisationMap.keySet().size()];
        multiplicity  = new long[primePowerFactorisationMap.keySet().size()];
        allFactors = new ArrayList<>();

        int i=0;
        for(Integer prime:primePowerFactorisationMap.keySet()) {
            primeDivisors[i] = prime;
            multiplicity[i] = primePowerFactorisationMap.get(prime);
            i++;
        }
    }

    void findFactors(int currentDivisor, long currentResult) {
        if (currentDivisor == primeDivisors.length) {
            allFactors.add(currentResult);
            return;
        }
        for (int i = 0; i <= multiplicity[currentDivisor]; ++i) {
            findFactors(currentDivisor + 1, currentResult);
            currentResult *= primeDivisors[currentDivisor];
        }
    }

    public List<Long> getAllFactors() {
        return allFactors;
    }

}
