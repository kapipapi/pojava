package zadC;

public class Taxi extends Auto {

    float[] zarobki = new float[12];

    Taxi() {
        for(int i=0; i<zarobki.length; i++) {
            zarobki[i] = (float)Math.random();
        }
    }

    float srZarobki() {
        float sum = 0;
        for(int i=0; i < zarobki.length; i++) {
            sum += zarobki[i];
        }
        return sum / zarobki.length;
    }

    public static void main(String[] args) {
        Taxi t = new Taxi();
        System.out.println(t.srPrzebieg());
        System.out.println(t.srZarobki());

    }
}