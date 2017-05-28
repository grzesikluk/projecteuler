package eulerproject.level4.problem84;

/**
 * This interface should be how the state full dice will behave.
 */
public interface DicePair {

    public int throwIt();

    public boolean isThrown();

    public boolean isDoubleDiceThreeTimes();

    public int howManyDoubleDiceInRow();

    public int getLastFirst();

    public int getLastSecond();

}
