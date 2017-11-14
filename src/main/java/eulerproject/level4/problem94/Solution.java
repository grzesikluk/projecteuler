package eulerproject.level4.problem94;

import eulerproject.tools.sequences.SequenceGeneratorImplA002530;
import eulerproject.tools.sequences.SequenceGeneratorImplA002531;
import eulerproject.tools.sequences.SequenceGeneratorIterative;
import eulerproject.tools.trigonometry.IsoscelesHeronianTriangle;

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    private static int MAX = 1000_000_000;

    public static void main(String[] args)
    {
        Set<Integer> results = new HashSet<>();
        IsoscelesHeronianTriangle t;
        long v;
        long u;
        SequenceGeneratorIterative<Long> vGenerator = new SequenceGeneratorImplA002531();
        SequenceGeneratorIterative<Long> uGenerator = new SequenceGeneratorImplA002530();

        do {
            v = vGenerator.getNext();
            u = uGenerator.getNext();

            t = new IsoscelesHeronianTriangle((int) v, (int) u, 1);

            if (t.area() > 0) {
                t.reduce();

                if (t.perimeter() > MAX)
                    break;
                if (t.isAlmostEquillateral()) {
                    System.out.println(t + " " + t.getGCD() + " v=" + v + " u=" + u);
                    results.add(t.perimeter());
                }
            }
        } while (true);

        System.out.println(results.stream().mapToInt(s -> s).sum());
    }
}
