package przyklad1;

public class Kolo implements Figura {

    double r;

    public Kolo(double r) {
        this.r = r;
    }

    @Override
    public double obliczObwod() {
        return 2*PI*r;
    }

    @Override
    public double obliczPole() {
        return PI*r*r;
    }
}