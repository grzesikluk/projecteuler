package eulerproject.level4.problem84;

/**
 * Created by grzesikl on 26/05/2017.
 */
public class DicePairImpl implements DicePair {

    private int sidesNumber;
    private int doublesInRow;
    private int lastDouble;
    private boolean wasThrown = false;
    private boolean threeDoubles = false;
    private int lastFirst;
    private int lastSecond;

    public int getLastFirst() {
        return lastFirst;
    }

    public int getLastSecond() {
        return lastSecond;
    }

    DicePairImpl(int sides) {
        if (sides < 2)
            throw new IllegalArgumentException("Amount of sides is to small");

        sidesNumber = sides;
        doublesInRow = 0;
        lastDouble = 0;
        lastFirst = 0;
        lastSecond = 0;
    }

    @Override
    public int throwIt() {
        return throwDices();
    }

    private int throwDices() {
        wasThrown = true;

        lastFirst = throwDice();
        lastSecond = throwDice();

        if (lastFirst == lastSecond) {

            if (doublesInRow > 0 && (lastDouble % (sidesNumber) == (lastFirst - 1))) {

                doublesInRow++;
                lastDouble = lastFirst;

                if (doublesInRow == 3) {
                    threeDoubles = true;
                    doublesInRow = 0;
                }

            } else {
                doublesInRow = 1;
                lastDouble = lastFirst;
                threeDoubles = false;
            }

        } else {
            lastDouble = 0;
            doublesInRow = 0;
        }


        return lastFirst + lastSecond;
    }


    private int throwDice() {
        wasThrown = true;
        return (int) (Math.random() * (sidesNumber)) + 1;
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
