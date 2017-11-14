package eulerproject.tools.sequences;

public class SequenceGeneratorImplA080040 implements SequenceGeneratorIterative<Long>
{
    private static long a0 = 2;
    private static long a1 = 2;
    private long an;
    private long an_1;
    private long an_2;
    private long n = 0;

    public SequenceGeneratorImplA080040()
    {
        an_2 = a0;
        an_1 = a1;
    }

    @Override
    public Long getNext()
    {
        if (n == 0)
            an = SequenceGeneratorImplA080040.a0;
        else if (n == 1)
            an = SequenceGeneratorImplA080040.a1;
        else {
            an = 2 * an_1 + 2 * an_2;
            an_2 = an_1;
            an_1 = an;
        }
        n++;

        return an;
    }
}
