package eulerproject.level3.problem58;

import eulerproject.tools.Primes;

/**
 * Created by grzesikl on 20/09/2016.
 */
public class SpiralNumberArrayDiagonal {

    private int[] diagonal;
    private int max;

    private Primes primes;

    /**
     * Create the diagonas of spiral array.
     *
     * @param k - this is the array width/height. Must be odd.
     */
    SpiralNumberArrayDiagonal(int k) {
        if ((k*k +1) > Integer.MAX_VALUE || (k*k+1) < 0)
            throw
                    new IllegalArgumentException("Value too big");

        if (k > 2 && k % 2 != 0) {
            //must be bigger than 2 and odd
            max = k;
            diagonal = new int[2*k-1];

            initElements();
            primes = new Primes(k*k+1);

        } else
            throw new IllegalArgumentException("Must be odd and biger than 2");
        System.out.println("Spiral array initiated.");
    }

    /**
     * initiate values for both diagonals
     */
    private void initElements() {
        int j = 2;
        int k = 0;

        diagonal[k]=1;

        while (j < max) {

            for (int i = 1; i < 5; i++) {
               k++;
               diagonal[k] = diagonal[k-1]+j;
            }
            j+=2;
        }

    }

    public int[] getDiagonal() {

        return diagonal;
    }

    SpiralNumberArrayDiagonal(int[] initArray) {
        diagonal = initArray;
    }

    public int getElement(int a) {
        return diagonal[a];
    }

    public int getSize() {
        return diagonal.length;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++)
            sb.append("[" + diagonal[i] + "]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof SpiralNumberArrayDiagonal))
            return false;

        SpiralNumberArrayDiagonal other = (SpiralNumberArrayDiagonal) obj;

        for (int i = 0; i < diagonal.length; i++) {
            if (this.diagonal[i] != other.diagonal[i] )
                return false;
        }

        return true;
    }

    public double getPrimeRatioOnDiagonals(int k) {
        int counter = 0;

        for (int i = 0; i < 2*k-1; i++) {
            if (primes.isPrime(diagonal[i]))
                counter++;
        }

        return (double) counter / (double) (k*2-1);
    }


}
