package eulerproject.level4.problem98;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordReaderTest
{
    @Test
    public void read() throws Exception
    {
        WordReader wordReader = new WordReader("src/test/java/eulerproject/level4/problem98/testFile.txt");
        assertThat(wordReader.read()).contains("A","ABILITY","ACHIEVE");
    }

}