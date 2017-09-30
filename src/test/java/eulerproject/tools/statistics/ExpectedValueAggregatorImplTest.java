package eulerproject.tools.statistics;

import org.assertj.core.data.Percentage;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpectedValueAggregatorImplTest
{
    @Test
    public void getExpectedValue() throws Exception
    {
        ExpectedValueAggregatorImpl expectedValueAggregator = new ExpectedValueAggregatorImpl();

        expectedValueAggregator.increment(0L);
        expectedValueAggregator.increment(1L);
        expectedValueAggregator.increment(2L);
        expectedValueAggregator.increment(2L);
        expectedValueAggregator.increment(2L);
        expectedValueAggregator.increment(3L);
        expectedValueAggregator.increment(3L);
        expectedValueAggregator.increment(3L);
        expectedValueAggregator.increment(4L);
        expectedValueAggregator.increment(4L);

        assertThat(expectedValueAggregator.getExpectedValue()).isCloseTo(2.4, Percentage.withPercentage(1.0));

    }
}