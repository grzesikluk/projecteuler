package eulerproject.problem43;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class PermutationImplTest {
    LinkedList<Character> list = new LinkedList<Character>();

    @Before
    public void initiateInput() {

        list.add(new Character('a'));
        list.add(new Character('b'));
        list.add(new Character('c'));

    }

    @Test
    public void testGenerate() throws Exception {

        Permutation<Character> perm = new PermutationImpl<Character>();
        Listener<Character> listener = new ListenerImpl<Character>();

        perm.generate(list.size()-1,list,listener);



    }
}