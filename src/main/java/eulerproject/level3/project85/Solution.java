package eulerproject.level3.problem85;

/**
 * Created by grzesikl on 23/02/2017.
 */
public class Solution {
    public final static int MAX = 100000;
    public final static int SEARCHED = 22229;

    public static void main(String[] args) {
        int m_found, n_found, distance;

        m_found = 1;
        n_found = 1;
        distance = SEARCHED;


        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                int noRect = getNoOfRectangles(i, j);

                if (distance > calcDistance(noRect)) {
                    m_found = i;
                    n_found = j;
                    distance = calcDistance(noRect);
                    System.out.println(m_found + " " + n_found + " " + distance);
                }
//                else if(distance<calcDistance(noRect))
//                    break;

            }

        }

        System.out.println(m_found + " " + n_found + " " +m_found * n_found);


    }

    public static int getNoOfRectangles(int m, int n) {
        return m * (m + 1) * n * (n + 1) / 4;
    }

    public static int calcDistance(int dist) {
        return Math.abs(SEARCHED - dist);
    }
}
