package eulerproject.level4.problem84;

/**
 * Created by grzesikl on 26/05/2017.
 */
public class DicePairImpl implements DicePair {

    private int sidesNumber;
    private int doublesInRow;
    private boolean wasThrown = false;
    private boolean threeDoubles = false;

    DicePairImpl(int sides) {
        if (sides < 2)
            throw new IllegalArgumentException("Amount of sides is to small");

        sidesNumber = sides;
        doublesInRow = 0;
    }

    @Override
    public int throwIt() {
        int k = throwDices();

        if (k == 2 * sidesNumber) {
            doublesInRow++;

            if (doublesInRow == 3) {
                threeDoubles = true;
                doublesInRow = 0;
            }

        } else {
            doublesInRow = 0;
        }

        return k;
    }

    private int throwDices() {
        wasThrown = true;
        return 2 + (int) (Math.random() * (sidesNumber * 2 - 1));
    }

    @Override
    public boolean isThrown() {
        return wasThrown;
    }

    @Override
    public boolean isDoubleDiceThreeTimes() {
        return threeDoubles;
    }

    @Override
    public int howManyDoubleDiceInRow() {
        return doublesInRow;
    }
}
