package eulerproject.level4.problem79;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Lukasz on 2016-11-03.
 */
public class SolutionTest {

    @Before
    public void init() throws IOException {
        Solution.getFileContent("C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\test\\java\\eulerproject\\level4\\problem79\\testfile.txt");
    }

    @Test
    public void testGetMiddleChar() throws Exception {

        Assert.assertEquals('2', Solution.getMiddleChar('1','3'));
        Assert.assertEquals('4', Solution.getMiddleChar('3','5'));
        Assert.assertEquals('8', Solution.getMiddleChar('7','9'));
        Assert.assertEquals(' ', Solution.getMiddleChar('1','2'));
    }

    @Test
    public void testDecodePassword() throws Exception {

        Assert.assertEquals("123456789", Solution.decodePassword(1));

    }



}