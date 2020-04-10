import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingFrame extends JFrame implements ActionListener {

    private Canvas canvas;
    private JButton b_rect, b_circle;
    JLabel color_label;
    JComboBox strokeWidthOption;

    private DrawingFrame() throws HeadlessException {
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        canvas = new Canvas();
        canvas.setSize(200, 200);
        add(canvas, BorderLayout.CENTER);

//        SHAPES PANEL
        JPanel shapes_buttons = new JPanel();
        shapes_buttons.setLayout(new FlowLayout());

        JButton b_pencil = new JButton("Pencil");
        b_pencil.setActionCommand("pencil");
        b_pencil.addActionListener(this);
        shapes_buttons.add(b_pencil);

        JButton b_line = new JButton("Line");
        b_line.setActionCommand("line");
        b_line.addActionListener(this);
        shapes_buttons.add(b_line);

        b_rect = new JButton("Rectangle");
        b_rect.setActionCommand("rect");
        b_rect.addActionListener(this);
        shapes_buttons.add(b_rect);

        b_circle = new JButton("Circle");
        b_circle.setActionCommand("circle");
        b_circle.addActionListener(this);
        shapes_buttons.add(b_circle);

        JButton b_eraser = new JButton("Eraser");
        b_eraser.setActionCommand("eraser");
        b_eraser.addActionListener(this);
        shapes_buttons.add(b_eraser);

        add(shapes_buttons, BorderLayout.PAGE_START);

//        SETTINGS PANEL
        JPanel setting = new JPanel();
        setting.setLayout(new FlowLayout());

        color_label = new JLabel("Color \u25A0");
        setting.add(color_label);

        JButton b_color = new JButton("Set color");
        b_color.setActionCommand("color");
        b_color.addActionListener(this);
        setting.add(b_color);

        JButton b_clear = new JButton("Clear!");
        b_clear.setActionCommand("clear");
        b_clear.addActionListener(this);
        setting.add(b_clear);

        JLabel stroke_label = new JLabel("Stroke width:");
        setting.add(stroke_label);

        String[] strokeOptions = new String[20];
        for (int i = 1; i <= 20; i++) strokeOptions[i - 1] = i + "";
        strokeWidthOption = new JComboBox(strokeOptions);
        strokeWidthOption.setSelectedIndex(0);
        strokeWidthOption.addActionListener(this);
        setting.add(strokeWidthOption);

        add(setting, BorderLayout.PAGE_END);

    }

    public static void main(String[] args) {
        DrawingFrame frame = new DrawingFrame();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == strokeWidthOption) {
            JComboBox cb = (JComboBox) e.getSource();
            int strokeWidth = Integer.parseInt((String) cb.getSelectedItem());
            canvas.setStrokeWidth(strokeWidth);
        } else {
            switch (e.getActionCommand()) {
                case "pencil":
                    canvas.setShape(Canvas.ShapeEnum.PENCIL);
                    break;
                case "line":
                    canvas.setShape(Canvas.ShapeEnum.LINE);
                    break;
                case "rect":
                    if (canvas.getShape() == Canvas.ShapeEnum.RECT) canvas.setFill(!canvas.getFill());
                    if (canvas.getFill()) b_rect.setText("Rectangle filled");
                    else b_rect.setText("Rectangle");
                    canvas.setShape(Canvas.ShapeEnum.RECT);
                    break;
                case "circle":
                    if (canvas.getShape() == Canvas.ShapeEnum.CIRCLE) canvas.setFill(!canvas.getFill());
                    if (canvas.getFill()) b_circle.setText("Circle filled");
                    else b_circle.setText("Circle");
                    canvas.setShape(Canvas.ShapeEnum.CIRCLE);
                    break;
                case "eraser":
                    canvas.setShape(Canvas.ShapeEnum.ERASER);
                    break;
                case "color":
                    canvas.setColor(JColorChooser.showDialog(this, "Set drawing color.", canvas.getColor()));
                    color_label.setForeground(canvas.getColor());
                    break;
                case "clear":
                    canvas.clearCanvas();
                    break;
                default:
                    System.err.println("NO SUCH ACTION COMMAND!");
            }
        }
    }
}
