import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    boolean regular = true;

    int width = 1;
    int vertices = 3;
    int R = 100;
    float fi = 0;

    int[] X, Y;

    Color bg = Color.white, fg = Color.BLACK;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(bg);
        g2.fillRect(0, 0, getWidth(), getHeight());

        X = new int[vertices];
        Y = new int[vertices];

        if (regular) {
            drawRegularPolygon();
        } else {
            drawRandomPolygon();
        }

        g2.setColor(fg);
        g2.setStroke(new BasicStroke(width));
        g2.drawPolygon(X, Y, vertices);

    }

    void drawRegularPolygon() {
        for (int i = 0; i < vertices; i++) {
            X[i] = (int) (getWidth() / 2 + R * Math.cos(fi + 2 * Math.PI * i / vertices));
            Y[i] = (int) (getHeight() / 2 + R * Math.sin(fi + 2 * Math.PI * i / vertices));
        }
    }

    void drawRandomPolygon() {
        for (int i = 0; i < vertices; i++) {
            X[i] = (int) (getWidth() / 2 + 2 * R * (Math.random() - .5));
            Y[i] = (int) (getHeight() / 2 + 2 * R * (Math.random() - .5));
        }
    }

}
