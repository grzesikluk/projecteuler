package eulerproject.tools.generators;

/**
 * Created by Lukasz on 2016-10-30.
 */
public class PolygonalNumbers {

    public static int getTriangularNumber(int k) {
        return k*(k+1)/2;
    }

    public static int getSquareNumber(int k) {
        return k*k;
    }

    public static int getPentagonalNumber(int k) {
        return k*(3*k-1)/2;
    }

    public static int getHexagonallNumber(int k) {
        return k*(2*k-1);
    }

    public static int getHeptagonalNumber(int k) {
        return k*(5*k-3)/2;
    }

    public static int getOctagonalNumber(int k) {
        return k*(3*k-2);
    }

}
