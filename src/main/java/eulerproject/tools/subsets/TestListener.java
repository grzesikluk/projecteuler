package eulerproject.tools.subsets;

import java.util.Set;

/**
 * Created by Lukasz on 2016-09-11.
 */
public class TestListener implements Listener {
    @Override
    public void activate(Set set) {
        System.out.println(set);
    }
}
