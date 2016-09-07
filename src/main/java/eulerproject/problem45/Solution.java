package eulerproject.problem45;

import java.util.HashSet;

/**
 * Created by Lukasz on 2016-08-30.
 */
public class Solution {

    private static final long MAX = 100000;
    private static HashSet<Long> triangles = new HashSet<Long>();
    private static HashSet<Long> pentagonal = new HashSet<Long>();
    private static HashSet<Long> hexagonal = new HashSet<Long>();

    static {
        for(long i=1;i<MAX;i++) {
            triangles.add(i*(i+1)/2);
            pentagonal.add(i*(3*i-1)/2);
            hexagonal.add(i*(2*i-1));
        }

    }



    public static void main(String[] args) {
        long p =    40755L;

        while(true) {
            p++;
            if (isTrianPentaHex(p)) {
                System.out.println(p);
                break;

            }

        }


    }


    public static boolean isTrianPentaHex(Long k) {
        return triangles.contains(k) && pentagonal.contains(k) && hexagonal.contains(k);
    }


}
