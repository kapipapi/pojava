import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MedianFrame extends JFrame implements ActionListener {

    private JTextField field;
    private JButton add_buttomn, median_button;
    private JLabel array_label, median_label;

    private List<Double> numbers = new ArrayList<Double>();

    private MedianFrame() {
        setSize(300,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1,3));

        field = new JTextField();
        top.add(field);

        add_buttomn = new JButton("ADD");
        add_buttomn.addActionListener(this);
        top.add(add_buttomn);

        median_button = new JButton("MEDIAN");
        median_button.addActionListener(this);
        top.add(median_button);

        this.add(top, BorderLayout.PAGE_START);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,1));

        array_label = new JLabel("");
        bottom.add(array_label);

        median_label = new JLabel("0");
        bottom.add(median_label);

        this.add(bottom, BorderLayout.PAGE_END);
    }

    private void printArray() {
        String list = "";
        for(double n : numbers) {
            list += n+", ";
        }
        array_label.setText(list);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add_buttomn) {
            try {
                numbers.add(Double.parseDouble(field.getText()));
                Collections.sort(numbers);
                printArray();
            } catch (NumberFormatException exception) {
                System.out.println("Input have to be number!");
            } finally {
                field.setText("");
            }
        }

        if(e.getSource() == median_button) {
            if(numbers.size() % 2 == 0) {
                double n1 = numbers.get(numbers.size()/2);
                double n2 = numbers.get(numbers.size()/2 -1);
                median_label.setText(""+(n1+n2)/2);
            } else {
                median_label.setText(numbers.get((numbers.size()-1)/2).toString());
            }
        }
    }

    public static void main(String[] args) {
        MedianFrame frame = new MedianFrame();
        frame.setVisible(true);
    }
}
