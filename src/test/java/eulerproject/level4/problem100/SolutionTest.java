package eulerproject.level4.problem100;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;


public class SolutionTest {
    @Test
    public void testGetPossibleNumberOfDiscs() throws Exception {

        IntStream.range(0,100).map(i->Solution.getPossibleNumberOfDiscs(i)).forEach(System.out::println);

    }

    @Test
    public void testGetBlueDiscNumber() throws Exception {

        Assert.assertEquals(15,Solution.getBlueDiscNumber(21));
        Assert.assertEquals(85,Solution.getBlueDiscNumber(120));
    }



}