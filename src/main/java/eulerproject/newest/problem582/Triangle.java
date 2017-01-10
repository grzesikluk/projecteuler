package eulerproject.newest.problem582;

/**
 * Created by Lukasz on 2016-12-23.
 */
public class Triangle {
    private int a,b,c,n;


    public Triangle(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public boolean checkConditionAngle() {
        return (a*a + b*b + a*b) == c*c ;

    }

    public boolean checkConditionSides() {
        return a<= b && b<=c && c<=n && (a+b)>c && (b-a)<=100;
    }

    @Override
    public String toString() {
        return "[a="+a+" b="+b+" c="+c+"]";
    }
}
