package eulerproject.level4.problem98;

import eulerproject.tools.generators.SquareNumbers;
import eulerproject.tools.primes.Primes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution
{
    private static final String FILE = "src/main/java/eulerproject/level4/problem98/p098_words.txt";

    public static void main(String[] args) throws IOException
    {
        WordReader wordReader = new WordReader(FILE);
        Map<Character, Integer> hashMap = createHashMap();

        List<String> words = wordReader.read();

        int min = getMinLen(words);
        int max = getMaxLen(words);

        System.out.println(getSquareNumbers(min, max));
    }

    public static int getMaxLen(List<String> words)
    {
        return words.stream().mapToInt(s -> s.length()).max().getAsInt();
    }

    public static int getMinLen(List<String> words)
    {
        return words.stream().mapToInt(s -> s.length()).min().getAsInt();
    }

    public static List<String> getSquareNumbers(int min, int max)
    {
        List<String> result = new ArrayList<>();
        long k = 1;
        String squareString;

        while ((squareString = new Long(SquareNumbers.getNumber(k)).toString()).length() <= max) {
            if ((squareString.length() >= min) && (squareString.length() <= max)) {
                result.add(squareString);
            }
            k++;
        }
        return result;
    }

    public static List<String> getStringOfLength(List<String> strings, final int length)
    {
        return strings.stream().filter(s -> s.length() == length).collect(Collectors.toList());
    }

    public static List<String> getStringAnagrams(List<String> strings, String inputString, final Map<Character, Integer> hashMap)
    {
        return strings.stream().filter(s->isStringAnagram(s,inputString,hashMap)).collect(Collectors.toList());
    }

    public static boolean isStringAnagram(final String input, final String other, final Map<Character, Integer> hashMap)
    {
        if(input.length() != other.length())
            return false;

        final int[] inputHash = {1};
        input.chars().forEach(c-> inputHash[0] *= hashMap.get(new Character((char)c)));

        final int[] otherHash = {1};
        other.chars().forEach(c-> otherHash[0] *= hashMap.get(new Character((char)c)));

        return (inputHash[0] == otherHash[0]);
    }

    public static Map<Character, Integer> createHashMap()
    {
        Primes primes = new Primes(1000);
        primes.init();
        Map<Character, Integer> result = new HashMap<>();
        final int[] lastPrime = {2};

        IntStream.range('A', 'Z' + 1).forEach(c -> {
            lastPrime[0] = primes.getNextPrime(lastPrime[0]);
            result.put(new Character((char) c), primes.getNextPrime(lastPrime[0]));
        });
        return result;
    }
}
