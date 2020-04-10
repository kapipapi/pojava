package przyklad5;

import java.util.*;

public class Example5 {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Double> wzrost = new ArrayList<Double>();
        int n = 30;

        // Dodawanie do listy kolejnych liczb z rokładu normalnego
        for(int i=0; i<n; i++)
            wzrost.add(177.4+5*rand.nextGaussian());

        // Sortowanie listy - uwaga, ta metoda modyfikuję listę
        Collections.sort(wzrost);

        // Iteracja po liście i wypisanie elementów na ekran
        for(Double w : wzrost)
            System.out.printf("%.1f cm\n",w);

        // Deklaracja i inicjalizacji listy list
        List<ArrayList<Integer>> tabliczka = new ArrayList<ArrayList<Integer>>();
        int m = 10;
        for(int i=0; i<m; i++){
            tabliczka.add(new ArrayList<Integer>()); // Dodawanie kolejnych, nowych list integerów do listy
            for(int j=0; j<m; j++)
                tabliczka.get(i).add((i+1)*(j+1)); // Wypełnianie listy integerów iloczynami
        }

        // Iteracja po liście list i wypisanie wszystkich elementów w m wierszach
        System.out.println();
        for(ArrayList<Integer> list : tabliczka) {
            for(Integer cell : list)
                System.out.printf("%3d ", cell);
            System.out.println();
        }

        List<String> zakupy = new LinkedList<String>();
        zakupy.add("pieczywo");
        zakupy.add("mleko 3.2%");
        zakupy.add("ser zolty");
        zakupy.add("jajka");
        zakupy.add("chipsy");
        zakupy.add("pomidory");
        zakupy.add("papryka czerwona");

        System.out.println();
        for(String item : zakupy)
            System.out.println(item);

        // Nadpisywanie elementów listy metodą set()
        zakupy.set(1, "mleko 1.2%");
        zakupy.set(2, "ser bialy");
        zakupy.set(6, "papryka zielona");
        zakupy.remove(4);  // Usunięcie czwartego elementu listy

        System.out.println();
        for(String item : zakupy)
            System.out.println(item);
    }
}
