package eulerproject.level2.problem43;

import eulerproject.tools.combinatorics.Listener;
import eulerproject.tools.combinatorics.Permutation;
import eulerproject.tools.combinatorics.PermutationWithoutRepetitionsImpl;

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
        Permutation<Character> perm = new PermutationWithoutRepetitionsImpl<Character>();
        Listener<Character> listener = new ListenerImplCheck<Character>();

        perm.generate(list,listener);
        
    }
}
