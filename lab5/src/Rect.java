import java.awt.*;

class Rect implements Shape {

    private int x, y, w, h;
    private Color c;
    private float strokeWidth;
    private boolean fill;

    Rect(int x, int y, int w, int h, Color c, float strokeWidth, boolean fill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.c = c;
        this.strokeWidth = strokeWidth;
        this.fill = fill;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(c);
        g2.setStroke(new BasicStroke(strokeWidth));
        if (fill) g2.fillRect(x, y, w, h);
        else g2.drawRect(x, y, w, h);
    }
}
