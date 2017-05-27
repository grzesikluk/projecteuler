package eulerproject.level4.problem84;

public class ChanceCards {

    Cards cards;

    public ChanceCards() {
        cards = new Cards(16);

        cards.addCard("GO");
        cards.addCard("JAIL");
        cards.addCard("C1");
        cards.addCard("E3");
        cards.addCard("H2");
        cards.addCard("R1");
        cards.addCard("R");
        cards.addCard("R");
        cards.addCard("U");
        cards.addCard("-3");
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
