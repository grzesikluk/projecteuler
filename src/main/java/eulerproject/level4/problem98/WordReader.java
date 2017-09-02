package eulerproject.level4.problem98;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordReader
{
    String fileName;

    public WordReader(String fileN)
    {
        fileName = fileN;
    }

    public List<String> read() throws IOException
    {
        Stream<String> stream = Files.lines(Paths.get(fileName));

        List<String> words = stream
                .map(s->s.replaceAll("\"",""))
                .map(s->s.split(","))
                .flatMap(a-> Stream.of(a)).collect(Collectors.toList());

        return words;
    }
}
