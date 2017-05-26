package eulerproject.level4.problem84;

/**
 * Created by grzesikl on 26/05/2017.
 */
public class ComunityChestCards {
    Cards cards;

    public ComunityChestCards() {
        cards = new Cards(16);

        cards.addCard("GO");
        cards.addCard("JAIL");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        cards.addCard("");
        
        cards.shuffleCards();
    }

    public String getNext() {
        return cards.getNextCard();
    }



}
