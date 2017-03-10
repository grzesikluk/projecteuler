package eulerproject.tools.functions;

import java.util.LinkedHashSet;
import java.util.Set;

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

    public ModularNumberInt powerModularOptimised(int k) {

        int resultVal = 1;

        Set<Integer> list = new LinkedHashSet<>();

        int p = -1;

        for (int i = 1; i <= k; i++) {
            resultVal = (resultVal * value) % modulo;

            if (list.contains(resultVal)) {
                p = (k - i) % list.size();
                break;
            } else
                list.add(resultVal);

        }

        resultVal =  (p < 0)?resultVal:(int) list.toArray()[p];

        return new ModularNumberInt(modulo, resultVal);

    }


    public int getValue() {
        return value;
    }

}
