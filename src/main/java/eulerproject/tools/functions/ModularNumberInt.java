package eulerproject.tools.functions;

public class ModularNumberInt {
    private int modulo;
    private int value;

    public ModularNumberInt(int modulo, int value) {
        this.modulo = modulo;
        this.value = value % modulo;
    }

    public ModularNumberInt addModular(int a) {
        return new ModularNumberInt(modulo, a + value);
    }

    public ModularNumberInt multiplyModular(int a) {
        return new ModularNumberInt(modulo, a * value);
    }

    @Override
    public int hashCode() {
        int result = (modulo ^ (modulo >>> 32));
        result = 31 * result + (value ^ (value >>> 32));
        return result;
    }

    public boolean equals(Object o) {
        if (o instanceof ModularNumberInt) {

            ModularNumberInt other = (ModularNumberInt) o;
            if (modulo != other.modulo)
                return false;

            return this.value % modulo == other.value % modulo;
        } else {
            return false;
        }
    }

    public ModularNumberInt powerModular(int power) {

        int resultValue = value;

        for (int i = 1; i < power; i++)
            resultValue = (resultValue * value) % modulo;

        return new ModularNumberInt(modulo, resultValue);

    }

    public int getValue() {
        return value;
    }

}
