package eulerproject.tools.generators;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class RandomGenerator<T>
{
    private List<T> randomList;
    private Map<T,Double> probabilityMap;
    private Map<T,Pair<Double,Double>> probabilityMapRanges;
    private Random generator;

    public RandomGenerator(final Set<T> initSet) {
        randomList = new ArrayList<>(initSet);
        probabilityMap = new HashMap<>();

        double probability = getEvenProbability(randomList.size());
        randomList.stream().forEach(e->probabilityMap.putIfAbsent(e,probability));

        probabilityMapRanges = getProbabilityMapRanges(probabilityMap);

        generator = new Random();

    }

    public RandomGenerator(final Map<T,Double> map) {

        if(!isProbabilitiesMapCorrect(map))
            throw new IllegalArgumentException("Wrong probabilities definition");

        probabilityMap = new HashMap<>(map);
        probabilityMapRanges = getProbabilityMapRanges(probabilityMap);

        generator = new Random();
    }

    public T getNext() {
        return getElement(generator.nextDouble()).orElseThrow(()->new IllegalStateException("Cannot generate "));
    }

    private double getEvenProbability(int k) {
        return 1.0/k;
    }

    private Optional<T> getElement(final double probability) {

        for(T key:probabilityMapRanges.keySet()) {

            if(probabilityMapRanges.get(key).getKey() <= probability &&
               probabilityMapRanges.get(key).getValue() > probability)
               return Optional.of(key);
        }

        return Optional.empty();
    }

    private Map<T, Pair<Double,Double>> getProbabilityMapRanges(final Map<T,Double> probabilityMap) {
        final double[] p = {0.0};
        Map<T, Pair<Double,Double>> resultMap = new HashMap<>();

        probabilityMap.forEach((k,v)->{
            resultMap.put(k,new Pair<>(p[0], p[0] +v));
            p[0] +=v;
        });
        return resultMap;
    }

    private boolean isProbabilitiesMapCorrect(final Map<T,Double> probabilityMap) {
        return probabilityMap.values().stream().mapToDouble(d->d).sum() == 1.0;
    }

}
