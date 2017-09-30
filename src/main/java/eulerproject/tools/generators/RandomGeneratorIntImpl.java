package eulerproject.tools.generators;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RandomGeneratorIntImpl<T> implements RandomGenerator<T>
{
    private Map<T,Integer> probabilityMap;
    private Map<T,Pair<Integer,Integer>> probabilityMapRanges;

    public RandomGeneratorIntImpl(final Map<T,Integer> map) {
        if(!isProbabilitiesMapCorrect(map))
            throw new IllegalArgumentException("Wrong probabilities definition");

        probabilityMap = new HashMap<>(map);
        probabilityMapRanges = getProbabilityMapRanges(probabilityMap);
    }

    public T getNext() {
        int k = (int)(Math.random()*100);

        return getElement(k).orElseThrow(()->new IllegalStateException("Cannot generate "));
    }

    public Optional<T> getElement(final int probability) {

        for(T key:probabilityMapRanges.keySet()) {

            if(probabilityMapRanges.get(key).getKey() <= probability &&
               probabilityMapRanges.get(key).getValue() > probability)
               return Optional.of(key);
        }

        return Optional.empty();
    }

    private Map<T, Pair<Integer,Integer>> getProbabilityMapRanges(final Map<T,Integer> probabilityMap) {
        final int[] p = {0};
        Map<T, Pair<Integer,Integer>> resultMap = new HashMap<>();

        probabilityMap.forEach((k,v)->{
            resultMap.put(k,new Pair<>(p[0], p[0] +v));
            p[0] +=v;
        });
        return resultMap;
    }

    private boolean isProbabilitiesMapCorrect(final Map<T,Integer> probabilityMap) {
        return probabilityMap.values().stream().mapToInt(i->i).sum() == 100;
    }

}
