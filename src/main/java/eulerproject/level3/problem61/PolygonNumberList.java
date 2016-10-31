package eulerproject.level3.problem61;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-10-31.
 */
public class PolygonNumberList {

    List<PolygonNumber> list;

    PolygonNumberList() {
        list = new LinkedList<>(); //must be ordered. last one is the one to be picked for next processing
    }

    PolygonNumberList(PolygonNumberList input) {
        list = new LinkedList<>(input.getList());
    }


    public void add(PolygonNumber p) {
        list.add(p);
    }

    public PolygonNumber get(int ix) {
        return list.get(ix);
    }

    public boolean hasAllPolygonals() {
        int counter = 0;

        for (PolygonNumber.polyTypes pt : PolygonNumber.polyTypes.values()) {
            for (PolygonNumber pn : list) {

                if (pn.getType() == pt) {
                    counter++;
                    break;
                }

            }

        }

        return counter == PolygonNumber.polyTypes.values().length;
    }

    public List<PolygonNumber.polyTypes> getPolygonalTypes() {
        Set<PolygonNumber.polyTypes> res = new HashSet<>();

        for (PolygonNumber pn : list)
            res.add(pn.getType());

        return res.stream().collect(Collectors.toList());

    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public boolean contains(PolygonNumber polygonNumber) {
        return list.contains(polygonNumber);
    }

    public List<PolygonNumber> getList() {
        return list;
    }

    public int getSum() {
        int result=0;

        for(PolygonNumber pn: list) {
            result+=pn.getVal();
        }
        return result;
    }

    @Override
    public String toString() {
        return list.toString();
    }


    public Map<PolygonNumber.polyTypes, PolygonNumberList> getNextPolygonalNumberLists() {


        Map<PolygonNumber.polyTypes, PolygonNumberList> result = new HashMap<>();
        List<PolygonNumber.polyTypes> exclude = getPolygonalTypes();
        PolygonNumber number = list.get(list.size() - 1);

        if(hasAllPolygonals())
            return result;


        for (PolygonNumber.polyTypes pol : PolygonNumber.polyTypes.values()) {

            if (!exclude.contains(pol)) {

                for (int i = 0; i < Polygonals.getPolygonals().get(pol).size(); i++) {
                    PolygonNumber polygon = new PolygonNumber(pol, Polygonals.getPolygonals().get(pol).get(i));

                    if (number.getLastTwoDigits().equals(polygon.getFirstTwoDigits()))
                        if (!result.containsKey(pol)) {
                            result.put(pol, new PolygonNumberList());
                            result.get(pol).add(polygon);
                        } else {
                            result.get(pol).add(polygon);
                        }
                }
            }
        }
        return result;
    }


    public List<PolygonNumberList> getListOfNextPolygonalLists() {
        List<PolygonNumberList> resultList = new LinkedList<>();

        Map<PolygonNumber.polyTypes, PolygonNumberList> mapOfNextLists = getNextPolygonalNumberLists();

        if (mapOfNextLists.isEmpty()) {
            resultList.add(this);
        } else {


            for (PolygonNumberList nextList : mapOfNextLists.values()) {

                for (PolygonNumber pn : nextList.getList()) {

                    PolygonNumberList newElement = new PolygonNumberList(this);
                    newElement.add(pn);
                    resultList.add(newElement);

                }
            }
        }
        return resultList;


    }

    public boolean isCyclic() {

        if (hasAllPolygonals()) {

            if (list.get(0).getFirstTwoDigits().equals(list.get(list.size()-1).getLastTwoDigits()))
                return true;
            else
                return false;
        } else

            return false;

    }


}
