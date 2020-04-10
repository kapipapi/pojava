import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class zadB {
    public static void main(String[] args) {
        CloseableFrame frame = new CloseableFrame("HEHE");
            frame.setLayout(new GridLayout(1,2));

        ThreeShapePanel panel1 = new ThreeShapePanel();
            panel1.setBackground(Color.white);
        frame.add(panel1);

        JPanel panel2 = new JPanel();
            panel2.setLayout(new GridLayout(4,1));

            JLabel label = new JLabel("Witajcie");
            panel2.add(label);

            JPanel panel3 = new JPanel();
            panel3.setLayout(new FlowLayout());

                JButton button1 = new JButton("ucieczka!");
                button1.addActionListener(e->System.exit(0));
                panel3.add(button1);

                JButton button2 = new JButton("kolorki");
                button2.addActionListener(e -> {
                    panel1.shake_colors();
                    panel1.repaint();
                });
                panel3.add(button2);

                JButton button3 = new JButton("Changes");
                button3.addActionListener(e -> {
                    frame.setTitle("powerangers");
                });
                panel3.add(button3);

            panel2.add(panel3);

            JTextField field = new JTextField("HEHE");
            field.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}
                @Override
                public void keyPressed(KeyEvent e) {}
                @Override
                public void keyReleased(KeyEvent e) {
                    label.setText(field.getText());
                }
            });
            panel2.add(field);

            JSlider slider = new JSlider(0,1000,200);
            slider.addChangeListener(e -> label.setFont(label.getFont().deriveFont((float)slider.getValue()/10)));
            panel2.add(slider);

        frame.add(panel2);

        frame.setVisible(true);

    }
}
