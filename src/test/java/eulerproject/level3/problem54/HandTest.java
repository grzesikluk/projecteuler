package eulerproject.level3.problem54;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by grzesikl on 13/09/2016.
 */
public class HandTest {


    @Test
    public void testIsThreeOfAKind() throws Exception {
        Assert.assertTrue(new Hand("9S 9C 9D QS KC").isThreeOfAKind());
        Assert.assertFalse(new Hand("9S 9C 9D QS QC").isThreeOfAKind());
        Assert.assertTrue(new Hand("QC 3C JS 3D 3S").isThreeOfAKind());

    }

    @Test
    public void testIsStraight() throws Exception {
        Assert.assertTrue(new Hand("9S 10S JS QS KC").isStraight());
        Assert.assertFalse(new Hand("2C 3C 5C 4C 6C").isStraight());
        Assert.assertTrue(new Hand("2C 3C 5S 4C 6C").isStraight());
        Assert.assertFalse(new Hand("QS JD QH QC KS").isStraight());

    }

    @Test
    public void testIsFlush() throws Exception {
        Assert.assertTrue(new Hand("9S 10S 4S KS AS").isFlush());
        Assert.assertTrue(new Hand("2C 5C AC QC JC").isFlush());
        Assert.assertFalse(new Hand("QS JD QH QC KS").isFlush());

    }

    @Test
    public void testIsFullHouse() throws Exception {
        Assert.assertTrue(new Hand("9S 9D 9H KC KS").isFullHouse());
        Assert.assertTrue(new Hand("AS QD AH AC QS").isFullHouse());
        Assert.assertFalse(new Hand("QS JD QH QC KS").isFullHouse());

    }

    @Test
    public void testIsFourOfAKind() throws Exception {
        Assert.assertTrue(new Hand("9S 9D 9H 9C KS").isFourOfAKind());
        Assert.assertTrue(new Hand("QS QD QH QC KS").isFourOfAKind());
        Assert.assertFalse(new Hand("QS JD QH QC KS").isFourOfAKind());
    }

    @Test
    public void testIsStraightFlush() throws Exception {
        Assert.assertTrue(new Hand("9S 10S JS QS KS").isStraightFlush());
        Assert.assertTrue(new Hand("JH QH 8H 9H 10H").isStraightFlush());
        Assert.assertFalse(new Hand("2H 3H 4H 5D 6H").isStraightFlush());
    }

    @Test
    public void testIsRoyalFlush() throws Exception {
        Assert.assertTrue(new Hand("10S JS QS KS AS").isRoyalFlush());
        Assert.assertTrue(new Hand("10H JH QH KH AH").isRoyalFlush());
        Assert.assertFalse(new Hand("9H JH QH KH AH").isRoyalFlush());
    }

    @Test
    public void testToString() throws Exception {

        Hand hand = new Hand("10S 4C 6D JS AC");
        Assert.assertEquals("[4C, 6D, 10S, JS, AC]", hand.toString());
    }

    @Test
    public void testIsTwoPairs() throws Exception {
        Assert.assertTrue(new Hand("9S 9C QD QS KC").isTwoPairs());
        Assert.assertTrue(new Hand("QC 3C JS QD 3S").isTwoPairs());
        Assert.assertFalse(new Hand("9S 9C 9D QS QC").isTwoPairs());
        Assert.assertFalse(new Hand("9S 9C 9D 4S QC").isTwoPairs());
        Assert.assertFalse(new Hand("9S 8C 3D 4S QC").isTwoPairs());
    }

    @Test
    public void testIsOnePair() throws Exception {
        Assert.assertTrue(new Hand("9S 9C QD AS KC").isOnePair());
        Assert.assertTrue(new Hand("AC 3C JS QD 3S").isOnePair());
        Assert.assertFalse(new Hand("9S 9C 9D QS QC").isOnePair());
        Assert.assertFalse(new Hand("9S 9C 4D 4S QC").isOnePair());
        Assert.assertFalse(new Hand("9S 8C 3D 4S QC").isOnePair());
    }

    @Test
    public void testCompareTo() throws Exception {
        Assert.assertTrue(new Hand("9S 9C QD AS KC").compareTo(new Hand("9S 9C QD AS KC")) == 0);
        Assert.assertTrue(new Hand("9S 9C 9D AS KC").compareTo(new Hand("9S 9C QD AS KC")) > 0);
        Assert.assertTrue(new Hand("9S 9C QD AS KC").compareTo(new Hand("9S 9C 9D 9S KC")) < 0);
        Assert.assertTrue(new Hand("2S 3S 4S 5S 6C").compareTo(new Hand("9S 9C 9D AS KC")) > 0);
        Assert.assertTrue(new Hand("2S 3S 4S 5S 6C").compareTo(new Hand("9S 9C 9D AS AC")) < 0);
        Assert.assertTrue(new Hand("9S 9C QD AS KC").compareTo(new Hand("8S 8C QD AS KC")) > 0);
        Assert.assertTrue(new Hand("9S 9C QD QS KC").compareTo(new Hand("8S 8C KD AS KC")) < 0);
        Assert.assertTrue(new Hand("9S 9C 9D QS KC").compareTo(new Hand("JS JC JD 2S 2C")) < 0);

        Assert.assertTrue(new Hand("5H 5C 6S 7S KD").compareTo(new Hand("2C 3S 8S 8D TD")) < 0);
        Assert.assertTrue(new Hand("5D 8C 9S JS AC").compareTo(new Hand("2C 5C 7D 8S QH")) > 0);
        Assert.assertTrue(new Hand("2D 9C AS AH AC").compareTo(new Hand("3D 6D 7D TD QD")) < 0);
        Assert.assertTrue(new Hand("4D 6S 9H QH QC").compareTo(new Hand("3D 6D 7H QD QS")) > 0);
        Assert.assertTrue(new Hand("2H 2D 4C 4D 4S").compareTo(new Hand("3C 3D 3S 9S 9D")) > 0);

    }

    @Test
    public void testCompareHighestCards() throws Exception {
        Assert.assertTrue(new Hand("9S 9C QD AS KC").compareHighestCards(new Hand("8S 8C QD AS KC")) > 0);
        Assert.assertTrue(new Hand("9S 9C QD QS KC").compareHighestCards(new Hand("8S 8C KD AS KC")) < 0);
        Assert.assertTrue(new Hand("9S 9C 9D QS KC").compareHighestCards(new Hand("JS JC JD 2S 2C")) < 0);
    }
}