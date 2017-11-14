package eulerproject.tools.statistics;

public interface ExpectedValueAggregator<T extends Number>
{
    void clear();
    double getExpectedValue();
    void increment(T key);

}
