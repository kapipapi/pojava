import javax.swing.*;
import java.awt.*;

public class Example2 {
    public static void main(String[] args) {
        CloseableFrame frame = new CloseableFrame("Example2");

        JButton b1 = new JButton("Button");
        frame.add(b1);

        JButton b2 = new JButton("Guzik");
        frame.add(b2);

        JLabel label = new JLabel("Etykietka :)");
        frame.add(label);

        JTextField field = new JTextField("Pole tekstowe");
        frame.add(field);

        frame.getContentPane().setBackground(Color.red);
        frame.setLayout(new GridLayout(4,1));
        frame.setVisible(true);

    }
}
