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
        encodedIntMessageStream = encodedMessage.stream().map(a -> Arrays.asList(a.split(","))).flatMap(a -> a.stream()).mapToInt(a->Integer.parseInt(a));
        encodedIntMessage = encodedIntMessageStream.toArray();

        //read common words
        commonWords = Files.readAllLines(Paths.get(FILENAME_CW));

    }

    public static char[] decodeMesage(char[] key, int[] intArray) {
        char[] decodedMessage = new char[intArray.length];
        int keyLen = key.length;

        for(int i =0;i<intArray.length; i++){
            decodedMessage[i] = (char) ((char)intArray[i]^key[i%keyLen]);
        }
        return decodedMessage;
    }

    public static boolean checkIfDecodedProperly(char[] message) throws IOException {
        int counter=0;
        String str = new String(message);

        for(String s:commonWords) {
            if (str.contains(s))
                counter++;
        }

        return (double)counter/(double)commonWords.size()>THRESHOLD;

    }


    public static void main(String[] args) throws IOException {
        readAllFiles();

        char[] message = decodeMesage(new char[]{'a','b','c'},encodedIntMessage);

        if(checkIfDecodedProperly(message))
            System.out.println(message);

    }
}
