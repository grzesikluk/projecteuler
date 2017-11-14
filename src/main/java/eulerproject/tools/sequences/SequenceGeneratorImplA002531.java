package eulerproject.tools.sequences;

public class SequenceGeneratorImplA002531 implements SequenceGeneratorIterative<Long>
{
    private long an;
    private long n = 0;
    private SequenceGeneratorIterative<Long> sg;

    public SequenceGeneratorImplA002531()
    {
        sg = new SequenceGeneratorImplA080040();
    }

    @Override
    public Long getNext()
    {
        long den = (long) (2 * Math.pow(2, Math.floor(n / 2)));
        an = sg.getNext() / den;
        n++;

        return an;
    }
}
