package eulerproject.level3.problem54;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class Card implements Comparable{
    CardValue value;

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public CardDeck getDeck() {
        return deck;
    }

    public void setDeck(CardDeck deck) {
        this.deck = deck;
    }

    CardDeck deck;

    public Card(CardValue val, CardDeck d) {
        value = val;
        deck = d;
    }

    /**
     * format is CardValue+CardDeck
     * @param s
     */
    public Card(String s) {
        if (s.length() == 2) {
            value = CardValue.fromString(s.substring(0,1));
            deck  = CardDeck.fromString(s.substring(1,2));

        }
        if (s.length() == 3) {
            value = CardValue.fromString(s.substring(0,2));
            deck  = CardDeck.fromString(s.substring(2,3));
        }

    }

    @Override
    public String toString() {
        return value.toString()+deck.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (value != card.value) return false;
        return deck == card.deck;

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (deck != null ? deck.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null || getClass() != o.getClass()) return 1;
        Card temp = (Card)o;

        if (value.compareTo(temp.value) == 0) {
            return deck.compareTo(temp.deck);
        }
        else {
            return value.compareTo(temp.value);
        }
    }

    public boolean isSameValue(Card c) {
        return this.value == c.value;
    }

    public boolean isSameDeck(Card c) {
        return this.deck == c.deck;
    }

}
