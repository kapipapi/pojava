import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("WUT file reader");
        try {
            File my_file = new File("./file_reader/src/test.txt");
            Scanner scanner = new Scanner(my_file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.println("Exception error: " + e);
        } finally {
            System.out.println("Thank you for choosing our services.");
        }
    }
}
