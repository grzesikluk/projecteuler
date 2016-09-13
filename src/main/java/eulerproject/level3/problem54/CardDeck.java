package eulerproject.level3.problem54;

/**
 * Created by grzesikl on 13/09/2016.
 */
public enum CardDeck  {
    spades("S"),clubs("C"),hearts("H"),diamonds("D");

    String sym;

    CardDeck(String symbol) {
        sym = symbol;
    }

    @Override
    public String toString() {
        return sym;
    }

    public static CardDeck fromString(String s) {
        switch (s) {
            case "S":
                return spades;
            case "C":
                return clubs;
            case "H":
                return hearts;
            case "D":
                return diamonds;
            default:
                return spades;
        }
    }


}
