package eulerproject.tools.subsets;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-26.
 */
public class FixedSubSetImpl4<T> implements  ParralellFixedSubSet<T> {
    public final static int MAX = 5;


    @Override
    public void generate(Set<T> set, Listener<T> listener, int minIx ,int maxIx, int maxSize) {

        System.out.println("Starting thread "+ LocalTime.now());
        if (set.isEmpty())
            return;

        List<T> setList = set.stream().collect(Collectors.toList());

        for(int i=minIx;i<maxSize-4 & i<maxIx;i++)
            for(int j=i+1;j<maxSize-3;j++)
                for(int k=j+1;k<maxSize-2;k++)
                    for(int l=k+1;l<maxSize-1;l++)
                        for(int m=l+1;m<maxSize-0;m++) {

                            Set<T> resSet = new LinkedHashSet<T>();
                            resSet.add(setList.get(i));
                            resSet.add(setList.get(j));
                            resSet.add(setList.get(k));
                            resSet.add(setList.get(l));
                            resSet.add(setList.get(m));

                            listener.activate(resSet);

                        }
        System.out.println("Finished thread "+ LocalTime.now());
    }
}
