public class Solution {

    public static final int MAX = 10000000;
    public static final int MODULO = 1000000;


    public static void main(String[] args) {

        PartitionsNumbers partitionsNumbers = new PartitionsNumbersModuloIntImpl(MODULO);

        for(int i = 2; i< MAX; i++) {
            if(partitionsNumbers.partitionFunction(i) == 0) {
                System.out.println(i);
                break;
            }

        }

    }
}
