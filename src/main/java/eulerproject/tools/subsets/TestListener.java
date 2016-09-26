package eulerproject.tools.subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Lukasz on 2016-09-11.
 */
public class TestListener implements Listener {

    public List<Set<?>> getResultSet() {
        return resultSet;
    }


    List<Set<?>> resultSet = new ArrayList<>();

    @Override
    public void activate(Set set) {
//        System.out.println(set);
        resultSet.add(set);
    }
}
