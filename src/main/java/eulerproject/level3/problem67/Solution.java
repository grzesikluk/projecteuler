package eulerproject.level3.problem67;

/**
 * Created by Lukasz on 2016-12-13.
 */
public class Solution {
    private static final String FILENAME = "src\\main\\resources\\eulerproject\\level3\\problem67\\triangle.txt";

    public static void main(String[] args) {

        TriangleNumbers tn = new TriangleNumbers(FILENAME);
        System.out.println(tn.getMaximumPath());


    }


}
