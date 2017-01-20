package net.euler.problems.sol.pr32;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Lukasz
 * Date: 19.11.13
 * Time: 22:02
 * To change this template use File | Settings | File Templates.
 */
public class Number {
    private Integer i;

    public Number(Integer i) {
        this.i = i;
    }

    public Number(String s) {
        i = Integer.parseInt(s);
    }

    public int getLength() {
        return i.toString().length();
    }

    public static int getMaxPandig(int l) {
        char[] Digits =  {'1','2','3','4','5','6','7','8','9','0'};
        String ret = new String("");

        if (l < Digits.length) {
            for (int j = l-1; j >= 0  ; j--) {
                ret = ret + Digits[j];
             }

        };
        return Integer.parseInt(ret);
    }
    public boolean isPandigital(int l){

        String st = i.toString();
        char[] Digits =  {'1','2','3','4','5','6','7','8','9','0'};
        int[]  Counter = new int[l];

        for (int j = 0; j < l; j++) {
                  Counter[j] = 0;
        }

        if (l != st.length()) return false;

        for(char c: st.toCharArray()) {

            for (int j = 0; j < l; j++) {
                 if(c == Digits[j])    Counter[j]++;
            }

        }

        for (int j = 0; j < l; j++)
             if (Counter[j] != 1 ) return false;


        return true;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }

    public static Number multiply(Number a,Number b) {

        return new Number(a.getI()*b.getI());

    }

    public void setI(String s) {
        this.i = Integer.parseInt(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        if (!i.equals(number.i)) return false;

        return true;
    }

    @Override
    public String toString() {

        return i.toString();
    };


    public ArrayList<Integer> getAllRotations() {

        String k = i.toString();
        char[] s = k.toCharArray();
        char first;

        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int j = 0; j < s.length ; j++) {
            first = s[0]; //store first

            for (int l = 0; l < s.length-1 ; l++) {
                 s[l] = s[l+1];
            }

            s[s.length-1] = first;
            k = new String(s);

            result.add(Integer.parseInt(k));

        }
        return result;
    }

    public String getBinaryRepres() {
        Integer copy = i;
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        String res = new String();

        while(copy != 0) {
            result1.add(copy % 2);
            copy = copy/2;
        }

        for (int j = result1.size()-1; j >= 0 ; j--) {
            res = res + result1.get(j).toString();
        }
        return res;
    }


}
