package eulerproject.problem31;

/**
 * Created by Lukasz on 2016-08-22.
 */
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

    Coin(int k) {
        val = k;
    }

//    public static Coin getOneLess(Coin a) {
//
//        switch (a){
//            case one_p:
//                return null;
//            case two_p:
//                return one_p;
//            case five_p:
//                return two_p;
//            case ten_p:
//                return five_p;
//            case twenty_p:
//                return ten_p;
//            case fifty_p:
//                return twenty_p;
//            case one_pound:
//                return fifty_p;
//            case two_pounds:
//                return one_pound;
//        }
//
//
////
////    public static HashSet<ArrayList<Coin>> generateSmall(Coin coin) {
////        HashSet<ArrayList<Coin>> changeCoins = new HashSet<ArrayList<Coin>>();
////        if (coin == one_p) {
////            changeCoins.add(new ArrayList<Coin>(Arrays.asList(new Coin[]{Coin.one_p})));
////            return changeCoins;
////        } else {
////
////            changeCoins.add();
////        }
//    }
}
