import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

public class Pencil implements Shape {
    private Color c;
    private float strokeWidth;
    private ArrayList<Integer> pencilShapeX;
    private ArrayList<Integer> pencilShapeY;

    Pencil(Color c, float strokeWidth) {
        this.c = c;
        this.strokeWidth = strokeWidth;
        pencilShapeX = new ArrayList<>();
        pencilShapeY = new ArrayList<>();
    }

    void addPoint(int x, int y) {
        pencilShapeX.add(x);
        pencilShapeY.add(y);
    }

    @Override
    public void draw(Graphics2D g2) {
        if(pencilShapeX.size()<2) return;
        GeneralPath pencilPath = new GeneralPath(GeneralPath.WIND_EVEN_ODD, pencilShapeX.size());
        pencilPath.moveTo(pencilShapeX.get(0), pencilShapeY.get(0));
        for (int i = 0; i < pencilShapeX.size(); i++) {
            pencilPath.lineTo(pencilShapeX.get(i), pencilShapeY.get(i));
        }
        g2.setColor(c);
        g2.setStroke(new BasicStroke(strokeWidth));
        g2.draw(pencilPath);
    }
}
