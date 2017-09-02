package eulerproject.level4.problem98;

import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class SolutionTest
{

    private static Map<Character, Integer> map = Solution.createHashMap();

    @Test
    public void testGetStringAnagrams() throws Exception
    {
        WordReader wordReader = new WordReader("src/test/java/eulerproject/level4/problem98/testFile.txt");
        assertThat(Solution.getStringAnagrams(wordReader.read(),"BLEA", map)).contains("ABLE", "BLEA", "LEAB");

    }


    @Test
    public void testIsStringAnagram() throws Exception
    {
        assertTrue(Solution.isStringAnagram("RARE", "ARER", map));
        assertFalse(Solution.isStringAnagram("BARE", "ARER", map));
        assertTrue(Solution.isStringAnagram("RARE", "REAR", map));
        assertFalse(Solution.isStringAnagram("RARE", "RER", map));
    }

    @Test
    public void testCreateHashMap() throws Exception
    {
        System.out.println(Solution.createHashMap());
    }
}