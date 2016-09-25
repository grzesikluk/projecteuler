package eulerproject.level3.problem59;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Lukasz on 2016-09-24.
 */
public class Solution {
    static List<String> encodedMessage;
    private static IntStream encodedIntMessageStream;
    private static int[] encodedIntMessage;
    private static List<String> commonWords;

    public static final String FILENAME = "C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\main\\java\\eulerproject\\level3\\problem59\\cipher.txt";
    public static final String FILENAME_CW = "C:\\Users\\Lukasz\\IdeaProjects\\projecteuler\\src\\main\\java\\eulerproject\\level3\\problem59\\common_words.txt";
    public static final double THRESHOLD = 0.5;

    public static void readAllFiles() throws IOException {
        encodedMessage = Files.readAllLines(Paths.get(FILENAME));
        encodedIntMessageStream = encodedMessage.stream().map(a -> Arrays.asList(a.split(","))).flatMap(a -> a.stream()).mapToInt(a -> Integer.parseInt(a));
        encodedIntMessage = encodedIntMessageStream.toArray();

        //read common words
        commonWords = Files.readAllLines(Paths.get(FILENAME_CW));

    }

    public static char[] decodeMesage(char[] key, int[] intArray) {
        char[] decodedMessage = new char[intArray.length];
        int keyLen = key.length;

        for (int i = 0; i < intArray.length; i++) {
            decodedMessage[i] = (char) ((char) intArray[i] ^ key[i % keyLen]);
        }
        return decodedMessage;
    }

    public static boolean checkIfDecodedProperly(char[] message) throws IOException {
        int counter = 0;
        String str = new String(message);

        for (String s : commonWords) {
            if (str.toLowerCase().contains(s.toLowerCase()))
                counter++;
        }

        return (double) counter / (double) commonWords.size() > THRESHOLD;
    }

    public static char[] getNextKey(char[] key) {

        char[] nextKey = new char[key.length];

        for (int i = 0; i < nextKey.length; i++)
            nextKey[i] = key[i];

        int k = nextKey.length - 1;

        while (k >= 0) {
            if (nextKey[k] < 'z') {
                nextKey[k] = (char) (nextKey[k] + 1);
                return nextKey;
            } else {
                nextKey[k] = 'a'; //reset
                k--;
            }
        }

        return null;

    }

    public static long sumOfAllAscii (char[] message ){
        long result = 0;

        for(int i=0;i<message.length;i++)
            result+=message[i];
        return result;

    }


    public static void main(String[] args) throws IOException {
        readAllFiles();
        char[] key = new char[]{'a', 'a', 'a'};
        char[] decodedMessage = null;

        while ((key = getNextKey(key)) != null) {
            decodedMessage = decodeMesage(key, encodedIntMessage);

            if (checkIfDecodedProperly(decodedMessage)) {
                System.out.println(decodedMessage);
                System.out.println(sumOfAllAscii(decodedMessage) );
            }

        }

    }
}
