import java.awt.*;

public class Line implements Shape {

    private int x1, y1, x2, y2;
    private Color color;
    private float strokeWidth;

    Line(int x1, int y1, int x2, int y2, Color c, float strokeWidth) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = c;
        this.strokeWidth = strokeWidth;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.setStroke(new BasicStroke(strokeWidth));
        g2.drawLine(x1, y1, x2, y2);
    }
}
