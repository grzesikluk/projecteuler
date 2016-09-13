package eulerproject.level3.problem54;

import java.util.*;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class Hand implements Comparable {
    private List<Card> cards = new ArrayList<Card>();

    public Hand(String c) {
        for (String s : c.split(" ")) {
            cards.add(new Card(s));
            if (cards.size() == 5)
                break;
        }
        cards.sort(new CardComparator());

    }

    @Override
    public String toString() {
        return cards.toString();
    }


    @Override
    public int compareTo(Object o) {
        Hand other = (Hand) o;
        int rankEval = getRank() - other.getRank();

        if (rankEval == 0) {
            return this.compareHighestCards(other);
        }

        return rankEval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hand hand = (Hand) o;

        return cards != null ? cards.equals(hand.cards) : hand.cards == null;

    }

    @Override
    public int hashCode() {
        return cards != null ? cards.hashCode() : 0;
    }


    public boolean isRoyalFlush() {

        return this.equals(new Hand("TD JD QD KD AD")) ||
                this.equals(new Hand("TS JS QS KS AS")) ||
                this.equals(new Hand("TC JC QC KC AC")) ||
                this.equals(new Hand("TH JH QH KH AH"));

    }

    public boolean isStraightFlush() {
        CardDeck deck = cards.get(0).getDeck();
        CardValue value = cards.get(0).getValue();

        for (Card c : cards) {
            if (value == null)
                break;
            if ((c.getDeck() != deck) || (c.getValue() != value))
                return false;
            value = CardValue.getNext(value);

        }

        return true;
    }

    public boolean isFourOfAKind() {

        return ((cards.get(0).getValue() == cards.get(1).getValue()) &&
                (cards.get(1).getValue() == cards.get(2).getValue()) &&
                (cards.get(2).getValue() == cards.get(3).getValue())) ||
                ((cards.get(1).getValue() == cards.get(2).getValue()) &&
                        (cards.get(2).getValue() == cards.get(3).getValue()) &&
                        (cards.get(3).getValue() == cards.get(4).getValue()));
    }

    public boolean isFullHouse() {
        Map<CardValue, Integer> cardCounter = new HashMap<>();

        for (Card c : cards) {
            if (cardCounter.containsKey(c.getValue()))
                cardCounter.replace(c.getValue(), cardCounter.get(c.getValue()) + 1);
            else
                cardCounter.put(c.getValue(), 1);
        }


        for (CardValue cv : cardCounter.keySet()) {
            if (cardCounter.get(cv) < 2)
                return false;
        }
        return true;

    }

    public boolean isFlush() {
        CardDeck cardDeck = cards.get(0).getDeck();
        for (Card c : cards) {
            if (c.getDeck() != cardDeck)
                return false;
        }
        return true;
    }

    public boolean isStraight() {
        CardValue cardValue = cards.get(0).getValue();

        if (isStraightFlush())
            return false;

        for (Card c : cards) {
            if (cardValue == null)
                break;
            if (c.getValue() != cardValue)
                return false;
            cardValue = CardValue.getNext(cardValue);

        }

        return true;

    }

    public boolean isThreeOfAKind() {

        if (isFullHouse())
            return false;

        Map<CardValue, Integer> cardCounter = evaluate();

        if (cardCounter.size() == 3) {
            for (CardValue cv : cardCounter.keySet()) {
                if (cardCounter.get(cv) == 2)
                    return false;
            }
            return true;

        }

        return false;
    }


    public boolean isOnePair() {

        if (isFullHouse())
            return false;
        if (isThreeOfAKind())
            return false;
        if (isFourOfAKind())
            return false;
        if (isTwoPairs())
            return false;

        Map<CardValue, Integer> cardCounter = evaluate();

        if (cardCounter.size() == 4) {
            for (CardValue cv : cardCounter.keySet()) {
                if (cardCounter.get(cv) > 2)
                    return false;
            }
            return true;

        }

        return false;
    }

    public boolean isTwoPairs() {


        if (isFullHouse())
            return false;
        if (isThreeOfAKind())
            return false;
        if (isFourOfAKind())
            return false;

        Map<CardValue, Integer> cardCounter = evaluate();

        if (cardCounter.size() == 3) {
            for (CardValue cv : cardCounter.keySet()) {
                if (cardCounter.get(cv) > 2)
                    return false;
            }
            return true;

        }

        return false;
    }

    private Map<CardValue, Integer> evaluate() {
        Map<CardValue, Integer> cardMap = new HashMap<>();

        for (Card c : cards) {
            if (cardMap.containsKey(c.getValue()))
                cardMap.replace(c.getValue(), cardMap.get(c.getValue()) + 1);
            else
                cardMap.put(c.getValue(), 1);
        }

        return cardMap;
    }

    public int getRank() {
        if (isRoyalFlush())
            return 9;
        if (isStraightFlush())
            return 8;
        if (isFourOfAKind())
            return 7;
        if (isFullHouse())
            return 6;
        if (isFlush())
            return 5;
        if (isStraight())
            return 4;
        if (isThreeOfAKind())
            return 3;
        if (isTwoPairs())
            return 2;
        if (isOnePair())
            return 1;
        return 0;

    }

    public int compareHighestCards(Hand other) {
        Map<CardValue, Integer> cardCounterMy = this.evaluate();
        Map<CardValue, Integer> cardCounterOther = other.evaluate();

        List<CardValue> cardMyArray = new ArrayList<>();
        List<CardValue> cardOtherArray = new ArrayList<>();

        int maxCount = 0;

        for (CardValue c : cardCounterMy.keySet()) {
            if (maxCount < cardCounterMy.get(c)) {
                maxCount = cardCounterMy.get(c);
            }
        }

        //got the maximum val

        while (maxCount >= 1) {

            cardMyArray.clear();
            cardOtherArray.clear();

            for (CardValue c : cardCounterMy.keySet()) {
                if (maxCount == cardCounterMy.get(c)) {
                    cardMyArray.add(c);
                }
            }
            for (CardValue c : cardCounterOther.keySet()) {
                if (maxCount == cardCounterOther.get(c)) {
                    cardOtherArray.add(c);
                }
            }

            cardMyArray.sort(new CardValueComparator());
            cardOtherArray.sort(new CardValueComparator());


            int pointer = cardMyArray.size() - 1;
            int compValue = 0;

            while (pointer >= 0) {
                compValue = cardMyArray.get(pointer).getIntValue() - cardOtherArray.get(pointer).getIntValue();
                if (compValue != 0)
                    return compValue;
                else
                    pointer--;
            }
            maxCount--;


        }
        return 0;


    }


}
