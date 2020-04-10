import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolygonDrawer extends JFrame implements ChangeListener, ActionListener {

    private Canvas canvas;

    private JSlider no_vertices_slider, rotation_slider, stroke_width_slider, polygon_size_slider;

    private JRadioButton regular_radio, random_radio;

    private JButton bg_button, fg_button;

    private PolygonDrawer() throws HeadlessException {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

//        SET CANVAS PANEL
        canvas = new Canvas();
        this.add(canvas, BorderLayout.CENTER);

//        SET TOP PANEL
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1, 2));

        no_vertices_slider = new JSlider(1, 10, 3);
        no_vertices_slider.addChangeListener(this);
        top.add(no_vertices_slider);

        rotation_slider = new JSlider(0, 62831, 0);
        rotation_slider.addChangeListener(this);
        top.add(rotation_slider);

        this.add(top, BorderLayout.PAGE_START);

//        SET LEFT PANEL
        JPanel left = new JPanel();
        left.setLayout(new GridLayout(2, 1));

        regular_radio = new JRadioButton("Regular");
        regular_radio.setSelected(true);
        regular_radio.addActionListener(this);
        left.add(regular_radio);

        random_radio = new JRadioButton("Random");
        random_radio.addActionListener(this);
        left.add(random_radio);

        ButtonGroup radio_group = new ButtonGroup();
        radio_group.add(regular_radio);
        radio_group.add(random_radio);

        this.add(left, BorderLayout.LINE_START);

//        SET RIGHT PANEL
        JPanel right = new JPanel();
        right.setLayout(new GridLayout(2, 1));

        stroke_width_slider = new JSlider(1, 10, canvas.width);
        stroke_width_slider.setOrientation(SwingConstants.VERTICAL);
        stroke_width_slider.addChangeListener(this);
        right.add(stroke_width_slider);

        polygon_size_slider = new JSlider(0, 300, canvas.R);
        polygon_size_slider.setOrientation(SwingConstants.VERTICAL);
        polygon_size_slider.addChangeListener(this);
        right.add(polygon_size_slider);

        this.add(right, BorderLayout.LINE_END);

//        SET BOTTOM PANEL
        JPanel bottom = new JPanel();

        bg_button = new JButton("background");
        bg_button.addActionListener(this);
        bottom.add(bg_button);

        fg_button = new JButton("stroke");
        fg_button.addActionListener(this);
        bottom.add(fg_button);

        this.add(bottom, BorderLayout.PAGE_END);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == no_vertices_slider) {
            canvas.vertices = no_vertices_slider.getValue();
        } else if (e.getSource() == rotation_slider) {
            canvas.fi = (float)(rotation_slider.getValue() * 1e-4);
        } else if (e.getSource() == stroke_width_slider) {
            canvas.width = stroke_width_slider.getValue();
        } else if (e.getSource() == polygon_size_slider) {
            canvas.R = polygon_size_slider.getValue();
        }

        canvas.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regular_radio) {
            canvas.regular = true;
            System.out.println("REGULAR");
        } else if (e.getSource() == random_radio) {
            canvas.regular = false;
        } else if (e.getSource() == bg_button) {
            canvas.bg = JColorChooser.showDialog(this, "set bg color", canvas.bg);
        } else if (e.getSource() == fg_button) {
            canvas.fg = JColorChooser.showDialog(this, "set fg color", canvas.fg);
        }

        canvas.repaint();
    }

    public static void main(String[] args) {
        PolygonDrawer frame = new PolygonDrawer();
        frame.setVisible(true);
    }

}
