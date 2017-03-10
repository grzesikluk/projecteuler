package eulerproject.tools.statistics;

import java.util.Arrays;

/**
 * Created by grzesikl on 08/03/2017.
 */
public class FleetingMedianArray {
    private int[] array;
    private int lastIx;

    FleetingMedianArray(int size) {
        array = new int[size];
        lastIx = 0;
    }

    FleetingMedianArray(int[] initArray) {
        array = Arrays.copyOf(initArray,initArray.length);
        Arrays.sort(array);
        lastIx = initArray.length;
    }

    public void sort() {
        Arrays.sort(array);
    }

    public int get(int i) {
        return array[i];
    }

    public void add(int i, int value) {
        array[i] = value;
    }

    /*Add with pre sorting*/
    public void add(int value) {
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

    public void remove(int value) {
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

            array[lastIx-1]=0;
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
