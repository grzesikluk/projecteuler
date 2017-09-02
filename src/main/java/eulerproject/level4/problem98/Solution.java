package eulerproject.level4.problem98;

import eulerproject.tools.generators.SquareNumbers;
import eulerproject.tools.primes.Primes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        Set<Set<String>> anagramsSets= convertWordListToAnagramSet(words,hashMap);

        Set<Integer> sizes = anagramsSets.stream().map(set->set.toArray(new String[]{}).length).collect(Collectors.toSet());

        System.out.println(getSquareNumbers(sizes).size());
//        System.out.println(anagramsSets.stream().flatMap(s->s.stream()).filter(s->s.length()==max).collect(Collectors.toList()));
        System.out.println(anagramsSets.size());
    }

    public static int getMaxLen(Set<Set<String>> anagrams)
    {
        return anagrams.stream().flatMap(set->set.stream()).mapToInt(s->s.length()).max().getAsInt();

    }

    public static int getMinLen(Set<Set<String>> anagrams)
    {
        return anagrams.stream().flatMap(set->set.stream()).mapToInt(s->s.length()).min().getAsInt();
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

    public static List<String> getSquareNumbers(Set<Integer> sizes)
    {
        List<String> result = new ArrayList<>();
        long k = 1;
        String squareString;
        int max = sizes.stream().mapToInt(s->s).max().getAsInt();

        while ((squareString = new Long(SquareNumbers.getNumber(k)).toString()).length() <= max) {
            if (sizes.contains(squareString.length())) {
                result.add(squareString);
            }
            k++;
        }
        return result;
    }

    public static List<String> getStringAnagrams(List<String> strings, String inputString, final Map<Character, Integer> hashMap)
    {
        return strings.stream().filter(s -> isStringAnagram(s, inputString, hashMap)).collect(Collectors.toList());
    }

    public static boolean isStringAnagram(final String input, final String other, final Map<Character, Integer> hashMap)
    {
        if (input.length() != other.length())
            return false;

        final int[] inputHash = {1};
        input.chars().forEach(c -> inputHash[0] *= hashMap.get(new Character((char) c)));

        final int[] otherHash = {1};
        other.chars().forEach(c -> otherHash[0] *= hashMap.get(new Character((char) c)));

        return (inputHash[0] == otherHash[0]);
    }

    public static Map<Character, Integer> createHashMap()
    {
        Primes primes = new Primes(10000);
        primes.init();
        Map<Character, Integer> result = new HashMap<>();
        final int[] lastPrime = {2};

        IntStream.range('A', 'Z' + 1).forEach(c -> {
            lastPrime[0] = primes.getNextPrime(lastPrime[0]);
            result.put(new Character((char) c), primes.getNextPrime(lastPrime[0]));
        });
        return result;
    }

    public static Map<Character, Character> assignLetters(String word, String number)
    {
        Map<Character, Set<Character>> setMap = new HashMap<>();
        Map<Character, Character> resultMap = new HashMap<>();

        if (word.length() != number.length())
            return resultMap;

        IntStream.range(0, word.length()).forEach(i -> {
            setMap.put(word.charAt(i), new HashSet<>());
        });
        IntStream.range(0, number.length()).forEach(i -> {
            setMap.get(word.charAt(i)).add(number.charAt(i));
        });

        if (setMap.values().stream().mapToInt(s -> s.size()).filter(s -> s != 1).sum() != 0) {
            setMap.clear();
        }

        setMap.forEach((k, v) -> resultMap.put(k, (Character) v.toArray()[0]));

        return resultMap;
    }

    public static Set<Set<String>> convertWordListToAnagramSet(List<String> words, Map<Character, Integer> hashMap)
    {
        Set<Set<String>> allSetOfAnagrams = new HashSet<>();
        List<String> copyWords = new ArrayList<>(words);

        while (!copyWords.isEmpty()) {
            String word = copyWords.get(0);
            Set<String> anagramList = getStringAnagrams(copyWords, word, hashMap).stream().collect(Collectors.toSet());
            copyWords.removeAll(anagramList);
            allSetOfAnagrams.add(anagramList);
        }

        return allSetOfAnagrams.stream().filter(set -> set.size() > 1).collect(Collectors.toSet());
    }
}
