package przyklad1;

public class Auto implements Pojazd {

    double[] predkosc;

    public Auto() {
        predkosc = new double[3];
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void ustawPredkosc(double[] v) {
        predkosc = v;
    }
}
