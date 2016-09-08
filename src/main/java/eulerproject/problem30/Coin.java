package eulerproject.problem30;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public enum Coin {

    one_p(1),
    two_p(2),
    five_p(5),
    ten_p(10),
    twenty_p(20),
    fifty_p(50),
    one_pound(100),
    two_pounds(200);

    public int getVal() {
        return val;
    }

    int val;
    private static HashSet<ArrayList<Coin>> changeCoinsVariants = new HashSet<ArrayList<Coin>>();

    Coin(int k) {
        val = k;
    }

    public static Coin getOneLess(Coin a) {

        switch (a) {
            case one_p:
                return null;
            case two_p:
                return one_p;
            case five_p:
                return two_p;
            case ten_p:
                return five_p;
            case twenty_p:
                return ten_p;
            case fifty_p:
                return twenty_p;
            case one_pound:
                return fifty_p;
            case two_pounds:
                return one_pound;
        }
        return a;
    }

    public static Coin getCoinFromVal(int val) {
        for (Coin a : Coin.values()) {
            if (a.getVal() == val)
                return a;
        }
        return null;
    }

    public static Coin getCoinBiggestAndLessThanVal(int val) {

        for (Coin a : Coin.values()) {
            if (a.getVal() >= val && getOneLess(a).getVal() < val) {
                return getOneLess(a);
            }
        }
        return null;
    }

    public static HashSet<ArrayList<Coin>> generateSmall(int coinVal) {
        return generateSmall(coinVal,new HashSet<ArrayList<Coin>>());
    }

    public static HashSet<ArrayList<Coin>> generateSmall(int coinVal,HashSet<ArrayList<Coin>> partial) {

        Coin c;
        c = getCoinFromVal(coinVal);

        if (c != null) { /*Exact value*/
            changeCoinsVariants.add(covertArray(new Coin[]{c}));
            if (c.getVal() == one_p.getVal()) {
                return changeCoinsVariants;
            }
        }

        c = getCoinBiggestAndLessThanVal(coinVal);

        if (c != null) {
            for (ArrayList<Coin> arr : generateSmall(c.getVal(),partial)) {
                partial.add(arr);
            }
                /*use change*/
            for (ArrayList<Coin> arr : generateSmall(coinVal - c.getVal(),partial)) {
                partial.add(arr);
            }
        }
        for (ArrayList<Coin> arr : partial) {
            changeCoinsVariants.add(arr);
        }

        return changeCoinsVariants;


    }

    public static ArrayList<Coin> covertArray(Coin... tab) {
        return new ArrayList<Coin>(Arrays.asList(tab));
    }
}
