package eulerproject.newest.problem583;

/**
 * Created by Lukasz on 2016-12-24.
 */
public class HeronEnvelope {
    private int sideX, sideY, flap;
    private double h, d, e;

    public HeronEnvelope(int sideX, int sideY, int flap) {
        this.sideX = sideX;
        this.sideY = sideY;
        this.flap = flap;

        h = Math.sqrt(flap*flap-(sideX*sideX)/4.0);
        d = Math.sqrt(sideX*sideX+sideY*sideY);
        e = Math.sqrt((sideX*sideX)/4.0+(sideY+h)*(sideY+h));

    }


    public boolean checkIfProperEnv() {
        return flap*flap+(sideX*sideX)/4 <= sideY*sideY;
    }

    public boolean checkIfAllDiagonalsIntegral() {
        return (d % 1 == 0) && (e % 1 == 0);
    }

    public int getPerimeter() {
        return sideX+sideY*2+flap*2;
    }

    @Override
    public String toString() {
        return "[x="+sideX+" y="+sideY+" flap="+flap+ " per="+getPerimeter() +"]";
    }
}
