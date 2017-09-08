package eulerproject.level4.problem98;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class SolutionTest
{
    @Test
    public void testAnagramsFromReplacementMap() throws Exception
    {
        List<List<Integer>> replacementMap = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0),
                Arrays.asList(3),
                Arrays.asList(2)
                );
         assertThat(Solution.anagramsFromReplacementMap("SURE",replacementMap)).isEqualTo("USER");


        List<List<Integer>> replacementMap2 = Arrays.asList(
                Arrays.asList(4),
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(0),
                Arrays.asList(2, 3)
        );

        assertThat(Solution.anagramsFromReplacementMap("SHEET",replacementMap2)).isEqualTo("THESE");
    }

    @Test
    public void testGetCharIndexes() throws Exception
    {
        assertThat(Solution.getCharIndexes('S', "SEEMS")).contains(0, 4);
        assertThat(Solution.getCharIndexes('E', "SEEMS")).contains(1, 2);
        assertThat(Solution.getCharIndexes('A', "SEEMS")).isEmpty();
    }

    @Test
    public void testReplacementMap() throws Exception
    {

        assertThat(Solution.replacementMap("SURE", "USER")).
                isEqualTo(Arrays.asList(
                        Arrays.asList(1),
                        Arrays.asList(0),
                        Arrays.asList(3),
                        Arrays.asList(2)));

        assertThat(Solution.replacementMap("THESE", "SHEET")).
                isEqualTo(Arrays.asList(Arrays.asList(4),
                        Arrays.asList(1),
                        Arrays.asList(2, 3),
                        Arrays.asList(0),
                        Arrays.asList(2, 3)));
    }

    @Test
    public void testConvertWordListToAnagramSet() throws Exception
    {
        assertThat(Solution.convertWordListToAnagramSet(Arrays.asList("ABAC", "ASDF", "FDAS", "AABC", "FDAA", "AA", "BB", "AB", "BA"), map)
                .size()).isEqualTo(3);
    }

    @Test
    public void testGetSquareNumbers() throws Exception
    {
        assertThat(Solution.getSquareNumbers(1, 1).size()).isEqualTo(3);
        assertThat(Solution.getSquareNumbers(2, 2).size()).isEqualTo(6);
        assertThat(Solution.getSquareNumbers(1, 2).size()).isEqualTo(9);
    }

    @Test
    public void testAssignLetters() throws Exception
    {
        assertThat(Solution.assignLetters("BABA", "1234")).isEmpty();
        assertThat(Solution.assignLetters("BACA", "1232")).containsValues('1', '2', '3');
        assertThat(Solution.assignLetters("BACAA", "12322")).containsValues('1', '2', '3');
        assertThat(Solution.assignLetters("BACCA", "12332")).containsValues('1', '2', '3');
    }

    private static Map<Character, Integer> map = Solution.createHashMap();

    @Test
    public void testGetStringAnagrams() throws Exception
    {
        WordReader wordReader = new WordReader("src/test/java/eulerproject/level4/problem98/testFile.txt");
        assertThat(Solution.getStringAnagrams(wordReader.read(), "BLEA", map)).contains("ABLE", "BLEA", "LEAB");
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