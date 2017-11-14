package eulerproject.tools.sequences;

public class SequenceGeneratorImplA002530 implements SequenceGeneratorIterative<Long>
{

    private long an;
    private long an_1 = 3;
    private long an_2 = 1;
    private long an_3 = 1;
    private long an_4 = 0;
    private long n = 0;

    public SequenceGeneratorImplA002530() {}

    @Override
    public Long getNext()
    {
        if (n == 0)
            an = an_4;
        else if (n == 1)
            an = an_3;
        else if (n == 2)
            an = an_2;
        else if (n == 3)
            an = an_1;
        else {
            an = 4 * an_2 - an_4;
            an_4 = an_3;
            an_3 = an_2;
            an_2 = an_1;
            an_1 = an;
        }
        n++;
        return an;
    }
}
