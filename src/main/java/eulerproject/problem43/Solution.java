package eulerproject.problem43;

import java.util.LinkedList;

/**
 * Created by Lukasz on 2016-08-26.
 */
public class Solution {

    public static void main(String[] args) {

        LinkedList<Character> list = new LinkedList<Character>();

        list.add('0'); //0
        list.add('1'); //1
        list.add('2');
        list.add('3');
        list.add('4');
        list.add('5'); //5
        list.add('6'); //0
        list.add('7'); //1
        list.add('8');
        list.add('9');
        Permutation<Character> perm = new PermutationImpl<Character>();
        Listener<Character> listener = new ListenerImplCheck<Character>();

        perm.generate(list.size()-1,list,listener);
        
    }
}
