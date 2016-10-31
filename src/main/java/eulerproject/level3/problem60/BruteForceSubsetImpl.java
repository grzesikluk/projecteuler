package eulerproject.level3.problem60;

import eulerproject.tools.subsets.Listener;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Lukasz on 2016-09-26.
 */
public class BruteForceSubsetImpl<T> implements ParralellFixedSubSetProblem60<T> {

    @Override
    public void generate(List<T> list, Listener<T> listener, int minIx , int maxIx, int maxSize) {

        if (list.isEmpty())
            return;

        for(int i=minIx;i<maxSize-4 & i<maxIx;i++)
            for(int j=i+1;j<maxSize-3;j++)
                for(int k=j+1;k<maxSize-2;k++)
                    for(int l=k+1;l<maxSize-1;l++)
                        for(int m=l+1;m<maxSize-0;m++) {

                            Set<T> resSet = new LinkedHashSet<T>();
                            resSet.add(list.get(i));
                            resSet.add(list.get(j));
                            resSet.add(list.get(k));
                            resSet.add(list.get(l));
                            resSet.add(list.get(m));

                            listener.activate(resSet);

                        }
    }
}
