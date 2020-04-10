package zadB;

public class Main {
    public static void main(String[] args) {

        String[] tab = new String[4];

        if (args.length == 4) {
            tab = args;
            for(int i=0; i<4; i++) {
                System.out.println(tab[i]);
            }
        } else {
            System.out.println("Give exacly 4 arguments.");
        }

    }
}