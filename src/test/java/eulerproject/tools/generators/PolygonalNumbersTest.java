package eulerproject.tools.generators;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-01-01.
 */
public class PolygonalNumbersTest {
    @Test
    public void getTriangularNumber() throws Exception {
        int[] output = {0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153, 171, 190, 210, 231, 253, 276, 300, 325, 351, 378};

        for (int i = 0; i < output.length; i++) {
            Assert.assertEquals(output[i], PolygonalNumbers.getTriangularNumber(i));
        }
    }

    @Test
    public void getSquareNumber() throws Exception {
        int[] output = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100};

        for (int i = 0; i < output.length; i++) {
            Assert.assertEquals(output[i], PolygonalNumbers.getSquareNumber(i));
        }
    }

    @Test
    public void getPentagonalNumber() throws Exception {
        int[] output = {0, 1, 5, 12, 22, 35, 51, 70, 92, 117, 145, 176, 210, 247, 287, 330};

        for (int i = 1; i < output.length; i++) {
            Assert.assertEquals(output[i], PolygonalNumbers.getPentagonalNumber(i));
        }
    }

    @Test
    public void getHexagonallNumber() throws Exception {

        int[] output = {0, 1, 6, 15, 28, 45, 66, 91, 120, 153, 190, 231, 276, 325, 378, 435, 496, 561, 630, 703, 780, 861, 946};

        for (int i = 0; i < output.length; i++) {
            Assert.assertEquals(output[i], PolygonalNumbers.getHexagonallNumber(i));
        }
    }

    @Test
    public void getHeptagonalNumber() throws Exception {

        int[] output = {0, 1, 7, 18, 34, 55, 81, 112, 148, 189, 235, 286, 342, 403, 469, 540, 616, 697, 783, 874, 970, 1071, 1177, 1288, 1404, 1525, 1651};

        for (int i = 0; i < output.length; i++) {
            Assert.assertEquals(output[i], PolygonalNumbers.getHeptagonalNumber(i));
        }
    }

    @Test
    public void getOctagonalNumber() throws Exception {
        int[] output = {0, 1, 8, 21, 40, 65, 96, 133, 176, 225, 280, 341, 408, 481, 560, 645, 736, 833, 936};

        for (int i = 0; i < output.length; i++) {
            Assert.assertEquals(output[i], PolygonalNumbers.getOctagonalNumber(i));
        }
    }

}