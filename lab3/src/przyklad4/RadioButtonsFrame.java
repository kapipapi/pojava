package przyklad4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonsFrame extends JFrame implements ActionListener {

    static final String[] COLOR_NAMES = {"red", "green", "blue"};
    static final Color[] COLORS = {Color.red, Color.green, Color.blue};
    static final Color INIT_COLOR = COLORS[0];

    JRadioButton radio1;
    JRadioButton radio2;
    JRadioButton radio3;

    public RadioButtonsFrame() throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(300,100);
        this.getContentPane().setBackground(INIT_COLOR);
        this.setLayout(new FlowLayout());

        radio1 = new JRadioButton(COLOR_NAMES[0]);
        radio1.setSelected(true);
        radio1.setActionCommand("0");
        radio1.addActionListener(this);
//        radio1.setBackground(COLORS[0]);
        this.add(radio1);

        radio2 = new JRadioButton(COLOR_NAMES[1]);
        radio2.setActionCommand("1");
        radio2.addActionListener(this);
//        radio2.setBackground(COLORS[1]);
        this.add(radio2);

        radio3 = new JRadioButton(COLOR_NAMES[2]);
        radio3.setActionCommand("2");
        radio3.addActionListener(this);
//        radio3.setBackground(COLORS[2]);
        this.add(radio3);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = Integer.parseInt(e.getActionCommand());
        Color new_color = COLORS[index];
        this.getContentPane().setBackground(new_color);
    }

    public static void main(String[] args) {
        RadioButtonsFrame frame = new RadioButtonsFrame();
        frame.setVisible(true);
    }

}
