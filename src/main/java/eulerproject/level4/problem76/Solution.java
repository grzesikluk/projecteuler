package eulerproject.level4.problem76;

import eulerproject.tools.generators.PartitionsNumbersImpl;

/**
 * Created by Lukasz on 2017-01-01.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("Result is " + (new PartitionsNumbersImpl(100).partitionFunction(100)-1));
    }

}
