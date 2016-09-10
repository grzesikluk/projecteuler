package eulerproject.level2.problem48;
import java.math.BigInteger;

/**
 * Created by Lukasz on 2016-08-31.
 */
public class Solution {
    public static void main(String[] args) {
    BigInteger accumulator = new BigInteger("0");
        for(int i=1;i<1000;i++) {
            BigInteger multiplicator = new BigInteger(new Integer(i).toString());
            BigInteger result = new BigInteger("1");

            for(int j=1;j<=i;j++) {
                result = result.multiply(multiplicator);
            }

            accumulator=accumulator.add(result);

        }

        String value =    accumulator.toString();
        System.out.println(value.substring(value.length()-10,value.length()));
    }



}
