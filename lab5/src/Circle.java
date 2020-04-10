import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle implements Shape {

    private int x, y;
    private double r;
    private Color c;
    private float strokeWidth;
    private boolean fill;

    Circle(int x, int y, double r, Color c, float strokeWidth, boolean fill) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(c);
        g2.setStroke(new BasicStroke(strokeWidth));
        if(fill) g2.fill(new Ellipse2D.Double(x - r, y - r, 2.0 * r, 2.0 * r));
        else g2.draw(new Ellipse2D.Double(x - r, y - r, 2.0 * r, 2.0 * r));
    }
}
