package eulerproject.level3.problem54;

import java.util.Comparator;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class CardValueComparator implements Comparator<CardValue> {

    @Override
    public int compare(CardValue o1, CardValue o2) {


        return o1.getIntValue()-o2.getIntValue();
    }
}
