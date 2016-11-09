package eulerproject.level3.problem65;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2016-11-07.
 */
public class Solution {

    public static void main(String[] args) {

    }


    public static List<Integer> getConvergentsListForEulerConstant(int max) {
        List<Integer> result = new LinkedList<>();

        result.add(new Integer(2));

        int i=1;

        while(i<max) {
            if ((i+1)%3 == 0)
                result.add(new Integer(2*(i-1)));
            else
                result.add(new Integer(1));
            i++;
        }

        return result;
    }


}
