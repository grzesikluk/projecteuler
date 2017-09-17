package eulerproject.level4.problem93;

public enum Operator
{

    plus("+"), minus("-"), div("/"), mul("*");

    private String signature;

    Operator(String s)
    {
        signature = s;
    }

    public static Operator getRandom()
    {
        int k = (int) Math.floor((Math.random() * (Operator.values().length)) + 0);
        return Operator.values()[k];
    }

    @Override
    public String toString()
    {
        return signature;
    }
}
