package net.euler.problems.sol.pr32;

import java.util.ArrayList;

public class Permutation {
    private String initialPermutation;

    public Permutation(String initialPermutation) {
        this.initialPermutation = initialPermutation;
    }

    ArrayList<String> getAllPermutations() {

        ArrayList<String> retList    = new ArrayList<String>();
        ArrayList<String> retTmpList = new ArrayList<String>();;

        retList.add("");

        for(Character c:initialPermutation.toCharArray()) {

            for(String str: retList) {
                retTmpList.addAll(getNextPermutation(str,c));
            }

            retList.clear();
            retList.addAll(retTmpList);
            retTmpList.clear();


        }


        return retList;
    }

    ArrayList<String> getNextPermutation(String initList, Character c) {

        ArrayList<String> returnList = new ArrayList<String>();

        for (int i = 0; i < initList.length() ; i++) {
            String tmp =   initList.substring(0,i) + c.toString() + initList.substring(i,initList.length());
            returnList.add(tmp);
        }

        returnList.add(initList+c.toString());

        return returnList;

    }
}
