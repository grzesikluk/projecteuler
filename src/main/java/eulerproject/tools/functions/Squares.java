package eulerproject.tools.functions;

import javafx.util.Pair;

import java.util.List;
import java.util.Set;

/**
 * Created by Lukasz on 2017-03-07.
 */
public interface Squares {
    Set<Integer> getIrrationalSquares(int max);

    Pair<List<Integer>, List<Integer>> getSquareRootDigits(int k, int maxLength);
}
