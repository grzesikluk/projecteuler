package eulerproject.tools.permutation;

import java.util.LinkedList;

/**
 * Created by Lukasz on 2016-08-28.
 */
public class PermutationImpl<T> implements Permutation<T> {

    public void generate(int k, LinkedList<T> input, Listener listener) {
        if (k == 0) {
            listener.activate(input);
        } else {
            for (int i = 0; i <= k; i++) {
                generate(k - 1, input, listener);
                if (i < k) {
                    swap(input, i, k);
                    reverse(input, k - 1);
                }

            }

        }

    }

    private void swap(LinkedList<T> input, int a_pos, int b_pos) {

        if ((a_pos != b_pos) && (a_pos < input.size() && b_pos < input.size())) {
            T temp = input.get(a_pos);
            input.set(a_pos, input.get(b_pos));
            input.set(b_pos, temp);
        }

    }

    private void reverse(LinkedList<T> input, int k) {

        int i = 0;
        int j = k;
        while (i < j) {

            swap((LinkedList<T>) input, i, j);
            i++;
            j--;

        }
    }


}
