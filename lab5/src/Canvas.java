import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

    private boolean drawing = false;

    public enum ShapeEnum {PENCIL, LINE, RECT, CIRCLE, ERASER}

    private boolean pressed = false;
    private int mOriginX = -1, mOriginY = -1;
    private int mNowX, mNowY;

    private Color drawingColor = Color.black;
    private float strokeWidth = 1;
    private ShapeEnum drawingShape = ShapeEnum.PENCIL;
    private ArrayList<Shape> shapes;

    private boolean fill = false;

    Canvas() {
        shapes = new ArrayList<>();
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    void setShape(ShapeEnum s) {
        drawingShape = s;
    }

    ShapeEnum getShape() {
        return drawingShape;
    }

    void setColor(Color c) {
        drawingColor = c;
    }

    Color getColor() {
        return drawingColor;
    }

    void clearCanvas() {
        shapes.clear();
        repaint();
    }

    void setFill(boolean state) {
        fill = state;
    }

    boolean getFill() {
        return fill;
    }

    void setStrokeWidth(int width) {
        strokeWidth = width;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        drawing = true;
        for (Shape s : shapes) {
            s.draw(g2);
        }
        drawing = false;

        if (pressed) {
            g2.setColor(drawingColor);
            g2.setStroke(new BasicStroke(strokeWidth));
            switch (drawingShape) {
                case LINE:
                    g2.drawLine(mOriginX, mOriginY, mNowX, mNowY);
                    break;
                case RECT:
                    if (fill) {
                        if (mNowX - mOriginX > 0) g2.fillRect(mOriginX, mOriginY, mNowX - mOriginX, mNowY - mOriginY);
                        else g2.fillRect(mNowX, mNowY, mOriginX - mNowX, mOriginY - mNowY);
                    } else {
                        if (mNowX - mOriginX > 0) g2.drawRect(mOriginX, mOriginY, mNowX - mOriginX, mNowY - mOriginY);
                        else g2.drawRect(mNowX, mNowY, mOriginX - mNowX, mOriginY - mNowY);
                    }
                    break;
                case CIRCLE:
                    double tmpR = Math.sqrt(Math.pow(mOriginX - mNowX, 2) + Math.pow(mOriginY - mNowY, 2));
                    if (fill) g2.fill(new Ellipse2D.Double(mOriginX - tmpR, mOriginY - tmpR, 2.0 * tmpR, 2.0 * tmpR));
                    else g2.draw(new Ellipse2D.Double(mOriginX - tmpR, mOriginY - tmpR, 2.0 * tmpR, 2.0 * tmpR));
                    break;
            }
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (drawing) return;
        pressed = true;
        mOriginX = e.getX();
        mOriginY = e.getY();
        if (drawingShape == ShapeEnum.PENCIL) {
            shapes.add(new Pencil(drawingColor, strokeWidth));
        }
        if (drawingShape == ShapeEnum.ERASER) {
            shapes.add(new Pencil(Color.white, strokeWidth));
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (drawing) return;
        mNowX = e.getX();
        mNowY = e.getY();
        if (drawingShape == ShapeEnum.PENCIL || drawingShape == ShapeEnum.ERASER) {
            Pencil tmp = (Pencil) shapes.get(shapes.size() - 1);
            tmp.addPoint(mNowX, mNowY);
        }
        this.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (drawing) return;
        pressed = false;
        switch (drawingShape) {
            case LINE:
                shapes.add(new Line(mOriginX, mOriginY, e.getX(), e.getY(), drawingColor, strokeWidth));
                break;
            case RECT:
                if (e.getX() - mOriginX > 0)
                    shapes.add(new Rect(mOriginX, mOriginY, e.getX() - mOriginX, e.getY() - mOriginY, drawingColor, strokeWidth, fill));
                else
                    shapes.add(new Rect(e.getX(), e.getY(), mOriginX - e.getX(), mOriginY - e.getY(), drawingColor, strokeWidth, fill));
                break;
            case CIRCLE:
                double tmpR = Math.sqrt(Math.pow(mOriginX - e.getX(), 2) + Math.pow(mOriginY - e.getY(), 2));
                shapes.add(new Circle(mOriginX, mOriginY, tmpR, drawingColor, strokeWidth, fill));
                break;
        }
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
