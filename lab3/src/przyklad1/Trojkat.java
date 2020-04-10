package przyklad1;

import przyklad1.Figura;

public class Trojkat implements Figura {

    double bokA, bokB, bokC;

    public Trojkat(double bokA, double bokB, double bokC) {
        this.bokA = bokA;
        this.bokB = bokB;
        this.bokC = bokC;
    }

    @Override
    public double obliczObwod() {
        return bokA + bokB + bokC;
    }

    @Override
    public double obliczPole() {
        double p = obliczObwod() / 2;
        return Math.sqrt(p*(p-bokA)*(p-bokB)*(p-bokC));
    }
}
