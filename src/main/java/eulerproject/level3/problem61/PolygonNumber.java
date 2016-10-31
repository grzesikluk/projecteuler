package eulerproject.level3.problem61;

/**
 * Created by Lukasz on 2016-10-31.
 */

public class PolygonNumber {

    public enum polyTypes {TRI, SQU, PEN, HEX, HEP, OCT};

    int val;
    polyTypes type;

    PolygonNumber(polyTypes t, int v) {
        val = v;
        type = t;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public polyTypes getType() {
        return type;
    }

    public void setType(polyTypes type) {
        this.type = type;
    }


    public String getFirstTwoDigits() {
        String kStr = Integer.toString(val);
        return (kStr.length() == 4) ? kStr.substring(0, 2) : "";
    }

    public String getLastTwoDigits() {
        String kStr = Integer.toString(val);
        return (kStr.length() == 4) ? kStr.substring(2, 4) : "";
    }

    @Override
    public String toString() {
        return "["+val+":"+type+"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PolygonNumber that = (PolygonNumber) o;

        if (val != that.val) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}


