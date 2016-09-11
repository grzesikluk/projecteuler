package eulerproject.tools.subsets;

import java.util.Set;

/**
 * Created by Lukasz on 2016-09-11.
 */
public interface SubSets <T>{
    void generate(Set<T> set,Listener<T> listener);
}
