package eulerproject.level4.problem84;

public class BoardField {

    String name;
    int number;

    public BoardField(String n, int i) {
        name = n;
        number = i;
    }

    @Override
    public String toString() {
        return name + " " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardField that = (BoardField) o;

        if (number != that.number) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + number;
        return result;
    }
}
