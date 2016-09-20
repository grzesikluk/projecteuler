package eulerproject.level3.problem58;

import eulerproject.tools.Primes;

/**
 * Created by grzesikl on 20/09/2016.
 */
public class SpiralNumberArray {

    private int[][] array;
    private Primes primes;

    SpiralNumberArray(int k) {
        if (k > 2 && k % 2 != 0) {
            //must be bigger than 2 and odd
            array = new int[k][k];

            initElements();
            primes = new Primes(k*k);

        } else
            throw new IllegalArgumentException("Must be odd and biger than 2");
    }

    private void initElements() {
        int x = (array.length - 1) / 2;
        int y = x;
        int i = 1;
        int progress = 2;

        //set middle one.
        array[x][y] = i;


        while (progress < array.length) {
            //first step
            y += 1;
            i++;
            array[x][y] = i;

            for (int j = 0; j < progress-1; j++) {
                i++;
                x--;
                array[x][y] = i;
            }

            for (int j = 0; j < progress; j++) {
                i++;
                y--;
                array[x][y] = i;
            }

            for (int j = 0; j < progress; j++) {
                i++;
                x++;
                array[x][y] = i;
            }
            for (int j = 0; j < progress; j++) {
                i++;
                y++;
                array[x][y] = i;
            }

            progress+=2;
//            System.out.println(this);
        }

    }

    SpiralNumberArray(int[][] initArray) {
        array = initArray;
    }

    public int getElement(int a, int b) {
        return array[a][b];
    }

    public int getSize() {
        return array.length;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {

                sb.append("[" + array[i][j] + "]");

            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof SpiralNumberArray))
            return false;

        SpiralNumberArray other = (SpiralNumberArray) obj;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (this.array[i][j] != other.array[i][j])
                    return false;
            }

        }

        return true;
    }

    /**
     * get diagonal for part of the table
     * @param k
     * @return
     */
    public int[] getSecondDiagonal(int k) {
        int[] diagonal = new int[k];

        for(int i=(array.length/2-k);i<k;i++)
            diagonal[i]=array[i+k][array.length-i-1+k];
        return diagonal;
    }

    public int[] getFirstDiagonal(int k) {
        int[] diagonal = new int[k];

        for(int i=(array.length/2-k/2);i<k;i++)
            diagonal[i]=array[i+k][i];
        return diagonal;
    }


    public double getPrimeRatioOnDiagonals(int k) {
        int counter = 0;

        int[] diag1 = getFirstDiagonal(k);
        int[] diag2 = getSecondDiagonal(k);

        for(int i=0;i<k;i++) {
            if(primes.isPrime(diag1[i]))
                counter++;
            if(primes.isPrime(diag2[i]))
                counter++;
        }

        return (double)counter/(double)(diag1.length+diag2.length-1);
    }

}
