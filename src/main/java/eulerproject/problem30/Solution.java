package eulerproject.problem30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by grzesikl on 18/08/2016.
 */
public class Solution {

    public static void main(String[] args) {
        int n = 10;
        for(List<Integer> sum : new SumIterator(n)) System.out.println(n + " = " + sum);
    }



}
