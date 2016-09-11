package eulerproject.tools.subsets;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Lukasz on 2016-09-11.
 */
public class SubSetGeneratorTest {

    @Test
    public void testGenerate() throws Exception {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        Listener sluchacz = new TestListener();
        SubSets<Integer> generator = new SubSetsImpl<>();
        generator.generate(set,sluchacz);


    }
}





