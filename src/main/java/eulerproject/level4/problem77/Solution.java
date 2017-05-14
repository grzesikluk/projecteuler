package eulerproject.level4.problem77;

import eulerproject.tools.sequences.SequenceGenerator;
import eulerproject.tools.sequences.SequenceGeneratorImplCachedA000607;

/**
 * Created by Lukasz on 2017-05-14.
 */
public class Solution {

    public static final long MAX = 10000000L;
    public static final long MAX_PART = 5000L;

    public static void main(String[] args) {
        SequenceGenerator sg = new SequenceGeneratorImplCachedA000607();
        sg.init(MAX);

        int i = 2;
        while(sg.getNumber(i) < MAX_PART)
            i++;
        System.out.println(i);

    }
}
