package eulerproject.level4.problem84;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lukasz on 2017-05-26.
 */
public class BoardTest {

    Board board;
    ChanceCards chanceCards;
    ComunityChestCards comunityChestCards;

    @Before
    public void init() {
        board = new Board();
        chanceCards = new ChanceCards();
        comunityChestCards = new ComunityChestCards();

    }
    @Test
    public void testMove() throws Exception {

        Assert.assertEquals("A1", board.move(1).name);
        Assert.assertEquals("CC1", board.move(1).name);
        Assert.assertEquals("H2", board.move(-3).name);

    }

    @Test
    public void moveToNextByCard() throws Exception {
        Assert.assertEquals("GO", board.moveToNextByCard("GO").name); //reset position
        Assert.assertEquals("GO", board.moveToNextByCard("").name);
        Assert.assertEquals("U1", board.moveToNextByCard("U").name);
        Assert.assertEquals("R2", board.moveToNextByCard("R").name);
        Assert.assertEquals("R3", board.moveToNextByCard("R").name);
        Assert.assertEquals("R4", board.moveToNextByCard("R").name);
        Assert.assertEquals("R1", board.moveToNextByCard("R").name);
        Assert.assertEquals("CC1", board.moveToNextByCard("-3").name);
        Assert.assertEquals("H2", board.moveToNextByCard("-3").name);

    }

}