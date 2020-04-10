public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello");

        if (args.length != 0) {
            for (int i = 1; i <= Integer.parseInt(args[0]); i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("Give value of iteration.");
        }
    }
}