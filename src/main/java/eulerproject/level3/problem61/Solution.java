package eulerproject.level3.problem61;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukasz on 2016-10-16.
 */
public class Solution {

    private static List<PolygonNumberList> tempList = new ArrayList<>();
    private static List<PolygonNumberList> tempList2 = new ArrayList<>();
    private static List<PolygonNumberList> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Polygonals.initPolygonals();

        //create initial
        for (Integer i : Polygonals.getPolygonals().get(PolygonNumber.polyTypes.TRI)) {
            PolygonNumberList pl = new PolygonNumberList();
            PolygonNumber pn = new PolygonNumber(PolygonNumber.polyTypes.TRI, i);
            pl.add(pn);

            tempList.add(pl);
        }

        for(PolygonNumber.polyTypes pt:PolygonNumber.polyTypes.values()) { //make it six times

            for(PolygonNumberList tempPolList:tempList) {
                tempList2.addAll(tempPolList.getListOfNextPolygonalLists());
            }

            tempList.clear();
            tempList.addAll(tempList2);
            tempList2.clear();

        }

        for(PolygonNumberList pl:tempList) {
            if(pl.isCyclic()) {
                resultList.add(pl);
            }
        }


        int sum = Integer.MAX_VALUE;
        PolygonNumberList result = null;

        for(PolygonNumberList pl:resultList) {
            if(pl.getSum()<sum) {
                sum = pl.getSum();
                result = pl;
            }
        }

        System.out.println(" Result list is " + result + " with sum = "+ result.getSum());





        /**
         * 1. init tables
         * 2. take first triangular number <T>
         * 3. check if in any other polygonals contains continuation of <T> (either tail or back) if yes store it
         * and continue with it searching in rest of polygonals (excluding triangular and the one which was found)
         *
         */
    }


}
