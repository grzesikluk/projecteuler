package eulerproject.level4.problem84;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by grzesikl on 26/05/2017.
 */
public class Cards {
    private int max;
    List<String> cardList;

    public Cards(int amount) {
        max = amount;
        cardList = new LinkedList<>();
    }

    public void addCard(String name) {
        if (max > cardList.size())
            cardList.add(name);
    }

    public void shuffleCards() {
        if (cardList.size() == max)
            Collections.shuffle(cardList);
    }

   public String getNextCard() {
        String next = cardList.get(nextCardsIx);
        nextCardsIx = (nextCardsIx + 1) % max;
        return next;
    }

}
