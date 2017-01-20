package net.euler.problems.sol.pr40;

import java.util.ArrayList;

/**
 */
public class ChamperowneConstant {
    private static int SIZE = 1000001;



    public static void main(String[] args) {

        Integer i = 0,counter=0;
        ArrayList<Character> array = new ArrayList<Character>(SIZE);

        while(counter <SIZE) {

            String k = i.toString();
            char[] s = k.toCharArray();

            for (int j = 0; j < s.length ; j++) {
                array.add(s[j]);
                counter++;
            }

            i++;
        }

        int res =
                                ch2int(array.get(1))*
                                ch2int(array.get(10))*
                                ch2int(array.get(100))*
                                ch2int(array.get(1000))*
                                ch2int(array.get(10000))*
                                ch2int(array.get(100000))*
                                ch2int(array.get(1000000));

        System.out.println(res);



    }

    public static int ch2int(Character c){
        Character zero = new Character('0');

        return c.charValue()-zero.charValue();

    }

}
