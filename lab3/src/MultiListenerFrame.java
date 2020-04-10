import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiListenerFrame extends JFrame implements ActionListener, ChangeListener {

    JPanel to_change;
    JPanel slider_panel, button_panel, radio_panel, field_panel;

    JSlider slider;
    JButton button;
    JRadioButton radio1, radio2, radio3, radio4;
    JTextField field;


    public MultiListenerFrame() throws HeadlessException {

        this.setSize(400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

//        SLIDER PANEL
        slider_panel = new JPanel();

        slider = new JSlider(0,100,0);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        slider_panel.add(slider);

        this.add(slider_panel, BorderLayout.PAGE_START);

//        BUTTON PANEL
        button_panel = new JPanel();

        button = new JButton("ustaw kolor");
        button.addActionListener(this);
        button_panel.add(button);

        this.add(button_panel, BorderLayout.PAGE_END);

//        RADIO BUTTONS PANEL
        radio_panel = new JPanel();
        radio_panel.setLayout(new GridLayout(4,1));

        radio1 = new JRadioButton("góra");
        radio1.setActionCommand("top");
        radio1.addActionListener(this);
        radio_panel.add(radio1);

        radio2 = new JRadioButton("dół");
        radio2.setActionCommand("bottom");
        radio2.addActionListener(this);
        radio_panel.add(radio2);

        radio3 = new JRadioButton("lewa");
        radio3.setActionCommand("left");
        radio3.addActionListener(this);
        radio_panel.add(radio3);

        radio4 = new JRadioButton("prawa");
        radio4.setActionCommand("right");
        radio4.addActionListener(this);
        radio_panel.add(radio4);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);
        group.add(radio4);

        this.add(radio_panel, BorderLayout.LINE_START);

//        FIELD PANEL
        field_panel = new JPanel();

        field = new JTextField("wartość");
        field_panel.add(field);

        this.add(field_panel, BorderLayout.LINE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button){
            Color new_color = JColorChooser.showDialog(this, "set color" , Color.red);
            to_change.setBackground(new_color);
        } else {
            switch (e.getActionCommand()) {
                case "top":
                    to_change = slider_panel;
                    break;
                case "bottom":
                    to_change = button_panel;
                    break;
                case "left":
                    to_change = radio_panel;
                    break;
                case "right":
                    to_change = field_panel;
                    break;
                default:
                    to_change = (JPanel) this.getContentPane();
                    break;
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        field.setText(""+slider.getValue());
    }
}
