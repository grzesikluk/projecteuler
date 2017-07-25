package eulerproject.level4.problem100;


public class Solution {


    public static void main(String[] args) {

    }


    public static int getBlueDiscNumber(final int numberOfDiscs) {
        return (int)(2 + Math.sqrt(4+8*numberOfDiscs*(numberOfDiscs-1)))/4;
    }

    public static int getPossibleNumberOfDiscs(int k) {
        return (int)(16 + Math.sqrt(16*(16-4*(8-(2*k+1)*(2*k+1)))))/32;
    }

    public boolean isInt(double k) {
        return (new Double(k).intValue()-k)==0;
    }
}
