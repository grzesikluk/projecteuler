package eulerproject.tools.functions;

public class ModularNumberLong {
    private long modulo;
    private long value;

    public ModularNumberLong(long modulo, long value) {
        this.modulo = modulo;
        this.value = value % modulo;
    }

    public ModularNumberLong addModular(long a) {
        return new ModularNumberLong(modulo, a + value);
    }

    public ModularNumberLong multiplyModular(long a) {
        return new ModularNumberLong(modulo, a * value);
    }

    public ModularNumberLong addModular(ModularNumberLong a) {
        return new ModularNumberLong(modulo, a.getValue() + value);
    }

    public ModularNumberLong multiplyModular(ModularNumberLong a) {
        return new ModularNumberLong(modulo, a.getValue() * value);
    }

    @Override
    public int hashCode() {
        int result = (int) (modulo ^ (modulo >>> 32));
        result = 31 * result + (int) (value ^ (value >>> 32));
        return result;
    }

    public boolean equals(Object o) {
        if (o instanceof ModularNumberLong) {

            ModularNumberLong other = (ModularNumberLong) o;
            if (modulo != other.modulo)
                return false;

            return this.value % modulo == other.value % modulo;
        } else {
            return false;
        }
    }

    public ModularNumberLong powerModular(long power) {

        long resultValue = value;

        for (long i = 1; i < power; i++)
            resultValue = (resultValue * value) % modulo;

        return new ModularNumberLong(modulo, resultValue);

    }

    public long getValue() {
        return value;
    }

}
