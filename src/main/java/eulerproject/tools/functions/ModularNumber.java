package eulerproject.tools.functions;

public class ModularNumber {
    private long modulo;
    private long value;

    public ModularNumber(long modulo, long value) {
        this.modulo = modulo;
        this.value = value % modulo;
    }

    public ModularNumber addModular(long a) {
        return new ModularNumber(modulo, a + value);
    }

    public ModularNumber multiplyModular(long a) {
        return new ModularNumber(modulo, a * value);
    }

    @Override
    public int hashCode() {
        int result = (int) (modulo ^ (modulo >>> 32));
        result = 31 * result + (int) (value ^ (value >>> 32));
        return result;
    }

    public boolean equals(Object o) {
        if (o instanceof ModularNumber) {

            ModularNumber other = (ModularNumber) o;
            if (modulo != other.modulo)
                return false;

            return this.value % modulo == other.value % modulo;
        } else {
            return false;
        }
    }

    public ModularNumber powerModular(long power) {

        long resultValue = value;

        for (long i = 1; i < power; i++)
            resultValue = (resultValue * value) % modulo;

        return new ModularNumber(modulo, resultValue);

    }

    public long getValue() {
        return value;
    }

}
