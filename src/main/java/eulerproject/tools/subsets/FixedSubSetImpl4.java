package eulerproject.tools.subsets;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-26.
 */
public class FixedSubSetImpl4<T> implements  FixedSubSet<T> {
    public final static int MAX = 5;


    @Override
    public void generate(Set<T> set, Listener<T> listener, int limit) {

        if (set.isEmpty())
            return;

        List<T> setList = set.stream().collect(Collectors.toList());

        for(int i=0;i<limit-MAX-4;i++)
            for(int j=i+1;j<limit-MAX-3;j++)
                for(int k=j+1;k<limit-MAX-2;k++)
                    for(int l=k+1;l<limit-MAX-1;l++)
                        for(int m=l+1;m<limit-MAX-0;m++) {

                            Set<T> resSet = new LinkedHashSet<T>();
                            resSet.add(setList.get(i));
                            resSet.add(setList.get(j));
                            resSet.add(setList.get(k));
                            resSet.add(setList.get(l));
                            resSet.add(setList.get(m));

                            listener.activate(resSet);

                        }

    }
}
