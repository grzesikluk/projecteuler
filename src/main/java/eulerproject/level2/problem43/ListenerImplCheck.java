package eulerproject.level2.problem43;

import eulerproject.tools.permutation.Listener;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class ListenerImplCheck<T> implements Listener<T> {

    long result = 0;

    public void activate(List<T> list) {
        if(check((LinkedList<Character>)list) ){
            System.out.println(list);
            result+= toNumber((LinkedList<Character>)list,0,1,2,3,4,5,6,7,8,9);
            System.out.println(result);
        }


    }

    public static boolean check(List<Character> list) {


        return
                (list.get(0) != '0') &&
                        (toNumber(list, 1, 2, 3) % 2 == 0) &&
                        (toNumber(list, 2, 3, 4) % 3 == 0) &&
                        (toNumber(list, 3, 4, 5) % 5 == 0) &&
                        (toNumber(list, 4, 5, 6) % 7 == 0) &&
                        (toNumber(list, 5, 6, 7) % 11 == 0) &&
                        (toNumber(list, 6, 7, 8) % 13 == 0) &&
                        (toNumber(list, 7, 8, 9) % 17 == 0)
                ;

    }

    public static long toNumber(List<Character> list, int... k) {
        LinkedList<Character> temp = new LinkedList<Character>();

        for (int i : k) {
            if (i < list.size())
                temp.add(list.get(i));
        }
        String tempStr = "";

        for (Character c : temp) {
            tempStr += c;
        }

        return new Long(tempStr);
    }

}
