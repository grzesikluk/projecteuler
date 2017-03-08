package eulerproject.newest.problem593;

import java.util.Arrays;

/**
 * Created by grzesikl on 08/03/2017.
 */
public class MedianArray {
    private double[] array;
    private int lastIx;

    MedianArray(int size) {
        array = new double[size];
        lastIx = 0;
    }

    MedianArray(double[] initArray) {
        array = Arrays.copyOf(initArray,initArray.length);
        Arrays.sort(array);
        lastIx = initArray.length;
    }

    public void sort() {
        Arrays.sort(array);
    }

    public double get(int i) {
        return array[i];
    }

    public void add(int i, double value) {
        array[i] = value;
    }

    /*Add with pre sorting*/
    public void add(double value) {
        int i = 0;

        while (array[i] <= value && i < lastIx)
            i++;

        if (i >= lastIx) {
            lastIx++;
            array[i] = value;
        } else {
            int j = lastIx;
            lastIx++;

            while (j > i) {
                array[j] = array[j - 1];
                j--;
            }
            array[i] = value;
        }
    }

    public void remove(double value) {
        int j = 0;
        while (array[j] != value && j < lastIx) {
            j++;
        }

        if (j == lastIx)
            return;
        else {
            int i = j + 1;
            while (i < lastIx) {
                array[i - 1] = array[i];
                i++;
            }

            lastIx--;
        }
    }

    public double median() {

        int middle = lastIx / 2;

        if (lastIx % 2 == 1) {
            return array[middle];
        } else {
            return (array[middle - 1] + array[middle]) / 2.0;
        }
    }

}
