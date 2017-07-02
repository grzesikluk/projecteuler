package eulerproject.level4.problem96;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Lukasz on 2017-07-02.
 */
public class FileReaderTest {

    private static String FILE = "src\\test\\java\\eulerproject\\level4\\problem96\\testfile.txt";
    @Test
    public void testOpen() throws Exception {
        FileReader fr = new FileReader(FILE);
        fr.read();
        Assert.assertEquals("Grid 01", fr.getFileContent().get(0));
        Assert.assertEquals("Grid 02", fr.getFileContent().get(10));
    }

    @Test
    public void testReadNext() throws Exception {
        FileReader fr = new FileReader(FILE);
        fr.read();

        Assert.assertNotEquals(fr.getNext(), fr.getNext() );
        Assert.assertNotEquals(fr.getNext(), fr.getNext() );
        Assert.assertNull(fr.getNext());

    }

}