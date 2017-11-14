package eulerproject.tools.trigonometry;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HeronianTriangleTest
{


    @Test
    public void testIsAlmostEquillateral()
    {
        assertThat(new Triangle(3, 4, 4).isAlmostEquillateral()).isTrue();
        assertThat(new Triangle(4, 3, 4).isAlmostEquillateral()).isTrue();
        assertThat(new Triangle(4, 4, 3).isAlmostEquillateral()).isTrue();
        assertThat(new Triangle(5, 4, 4).isAlmostEquillateral()).isTrue();
        assertThat(new Triangle(4, 5, 4).isAlmostEquillateral()).isTrue();
        assertThat(new Triangle(4, 6, 4).isAlmostEquillateral()).isFalse();
    }

    @Test
    public void testPerimeter() throws Exception
    {
        List<List<Double>> inputOutputValues = Arrays.asList(

                Arrays.asList(2.0, 1.0, 1.0, 16.0, 12.0),
                Arrays.asList(3.0, 1.0, 1.0, 36.0, 48.0),
                Arrays.asList(3.0, 2.0, 1.0, 36.0, 60.0)

        );

        for (List<Double> checkValues : inputOutputValues) {
            IsoscelesHeronianTriangle triangle =
                    new IsoscelesHeronianTriangle(checkValues.get(0).intValue(), checkValues.get(1).intValue(), checkValues.get(2).intValue());
            assertThat(triangle.perimeter()).isEqualTo(checkValues.get(3).intValue());
            assertThat(triangle.area()).isEqualTo(checkValues.get(4).intValue());
            assertThat(triangle.isAreaInt()).isTrue();
            System.out.println(triangle);
        }
    }
}