package eulerproject.level4.problem79;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static eulerproject.level4.problem79.Solution.decodePassword;
import static eulerproject.level4.problem79.Solution.getFileContent;
import static eulerproject.level4.problem79.Solution.getMiddleChar;

/**
 * Created by Lukasz on 2016-11-03.
 */
public class SolutionTest {

    @Before
    public void init() throws IOException {
        getFileContent("C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\test\\java\\eulerproject\\level4\\problem79\\testfile.txt");
    }

    @Test
    public void testGetMiddleChar() throws Exception {

        Assert.assertEquals('2',getMiddleChar('1','3'));
        Assert.assertEquals('4',getMiddleChar('3','5'));
        Assert.assertEquals('8',getMiddleChar('7','9'));
        Assert.assertEquals(' ',getMiddleChar('1','2'));
    }

    @Test
    public void testDecodePassword() throws Exception {

        Assert.assertEquals("123456789",decodePassword(1));

    }



}