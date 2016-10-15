package eulerproject.tools.subsets;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-26.
 */
public class FixedSubSetImpl5<T> implements  ParralellFixedSubSet<T> {
    public final static int MAX = 5;


    @Override
    public void generate(Set<T> set, Listener<T> listener, int min, int max, int size) {
        if (set.isEmpty())
            return;

        List<T> setList = set.stream().collect(Collectors.toList());

        for(int i=min;i<size-3 & i<max;i++)
            for(int j=i+1;j<size-2;j++)
                for(int k=j+1;k<size-1;k++)
                    for(int l=k+1;l<size-0;l++) {

                            Set<T> resSet = new LinkedHashSet<T>();
                            resSet.add(setList.get(i));
                            resSet.add(setList.get(j));
                            resSet.add(setList.get(k));
                            resSet.add(setList.get(l));

                            listener.activate(resSet);

                        }

    }
}
