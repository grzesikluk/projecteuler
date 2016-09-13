package eulerproject.level3.problem54;

import java.util.Comparator;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o1.compareTo(o2);
    }

}
