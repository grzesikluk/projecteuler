package eulerproject.level3.problem54;

/**
 * Created by grzesikl on 13/09/2016.
 */
public enum CardValue {
    two("2"), three("3"), four("4"), five("5"), six("6"), seven("7"), eight("8"), nine("9"), ten("T"), jack("J"), queen("Q"), king("K"), ace("A");

    String symbol;

    CardValue(String val) {
        symbol = val;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static CardValue fromString(String s) {
        switch (s) {
            case "2": return two;
            case "3": return three;
            case "4": return four;
            case "5": return five;
            case "6": return six;
            case "7": return seven;
            case "8": return eight;
            case "9": return nine;
            case "T": return ten;
            case "J": return jack;
            case "Q": return queen;
            case "K": return king;
            case "A": return ace;
        }
        return two;

    }

    public static CardValue getNext(CardValue cv) {
        switch (cv) {
            case two: return three;
            case three: return four;
            case four: return five;
            case five: return six;
            case six: return seven;
            case seven: return eight;
            case eight: return nine;
            case nine: return ten;
            case  ten: return jack;
            case jack: return queen;
            case queen: return king;
            case king: return ace;
            case ace: return null;
        }
        return null;
    }


    public int getIntValue() {
        switch (this) {
            case two: return 1;
            case three: return 2;
            case four: return 3;
            case five: return 4;
            case six: return 5;
            case seven: return 6;
            case eight: return 7;
            case nine: return 8;
            case  ten: return 9;
            case jack: return 10;
            case queen: return 11;
            case king: return 12;
            case ace: return 13;
        }
        return 1;
    }



}


