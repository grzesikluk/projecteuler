package eulerproject.level4.problem91;

import java.awt.*;

public class Line {

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    private double a;
    private double b;


    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Line(Point p1, Point p2) {
        a = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        b = p1.getY() - p1.getX() * (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
    }

    public double getY(double x) {
        return a * x + b;
    }

    @Override
    public String toString() {
        String aStr = (a < 0) ? "" + a : "" + a;
        String bStr = (b < 0) ? "" + b : "+" + b;

        return "y = " + aStr + "x " + bStr;
    }


    public double getPerpAFactor() {
        return -1 / a;
    }

    public Line getPerpLine(Point p) {
        double a = getPerpAFactor();

        double b = p.getY() - a * p.getX();
        return new Line(a, b);
    }

    public boolean isSolution(Point p) {
        return (p.getY() == ((a * p.getX()) + b));
    }


}
