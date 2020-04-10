import javax.swing.*;
import java.awt.*;

public class Example3 {
    public static void main(String[] args) {
        CloseableFrame frame = new CloseableFrame("Example3");
        frame.setLayout(new GridLayout(1,2));

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.cyan);
        frame.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.yellow);
        frame.add(panel2);

        JLabel label1 = new JLabel("panel1");
        panel1.add(label1);

        JLabel label2 = new JLabel("panel2");
        label2.setForeground(Color.red);
        panel2.add(label2);

        frame.setVisible(true);
    }
}
