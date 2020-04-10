import javax.swing.*;
import java.awt.*;

public class DrawablePanel extends JPanel {

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        g.drawRect(0, 0, 100, 100);
    }
}
