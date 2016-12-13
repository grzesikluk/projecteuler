package eulerproject.problem92;

/**
 * Created by Lukasz on 2016-11-02.
 */
public class Solution {
  
      public static final int MAX = 10000000;

    public static void main(String[] args) {
        int counter =0;

        for(int i=1;i<MAX;i++) {
            int infLoopNo = getInfiniteLoopNumber(i);
            if(infLoopNo == 89)
                counter++;
        }
        System.out.println(counter);

    }


    public static int getInfiniteLoopNumber(int k) {
        int store=k;
        while( store != 1 && store != 89) {
            store = getNextNumber(store);
        }
        return store;
    }

    public static int getNextNumber(int k) {
        int result = 0;
        char[] characters = new Integer(k).toString().toCharArray();

        for (char c : characters) {
            int val = charToInt(c);
            val *= val; //do square
            result += val;
        }

        return result;
    }

    private static int charToInt(char c) {
        int result = (int) c;
        return (result >= 48 && result <= 58) ? result - 48 : 0;
    }
}
