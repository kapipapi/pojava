import przyklad1.Kolo;
import przyklad1.Trojkat;

public class ZadanieA {
    public static void main(String[] args) {
        Kolo k = new Kolo(5);
        System.out.println(k.obliczObwod());
        System.out.println(k.obliczPole());

        Trojkat t = new Trojkat(3,4, 5);
        System.out.println(t.obliczObwod());
        System.out.println(t.obliczPole());
    }
}
