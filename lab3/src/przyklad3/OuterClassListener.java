package przyklad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class OuterClassListener extends JFrame {

    JComboBox<String> list;

    public OuterClassListener() throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(300,100);

        String[] colors = {"red", "green", "blue"};
        list = new JComboBox<>(colors);
        list.addItemListener(new ComboBoxItemListener((JPanel)this.getContentPane()));
        this.add(list, BorderLayout.PAGE_START);
        this.getContentPane().setBackground(Color.red);
    }

    public class ComboBoxItemListener implements ItemListener {

        JPanel panel;

        public ComboBoxItemListener(JPanel panel) {
            this.panel = panel;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                String color = (String)e.getItem();
                Color new_bg;
                switch(color) {
                    case "red":
                        new_bg = Color.red;
                        break;
                    case "green":
                        new_bg = Color.green;
                        break;
                    case "blue":
                        new_bg = Color.blue;
                        break;
                    default:
                        new_bg = Color.black;
                        break;
                }
                panel.setBackground(new_bg);
            }
        }
    }

    public static void main(String[] args) {
        OuterClassListener frame = new OuterClassListener();
        frame.setVisible(true);
    }

}
