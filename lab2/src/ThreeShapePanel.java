import javax.swing.*;
import java.awt.*;

public class ThreeShapePanel extends JPanel {

    private Color[] colors = new Color[3];

    ThreeShapePanel() {
        shake_colors();
    }

    void shake_colors() {
        for(int i=0; i<colors.length; i++){
            colors[i] = Color.getHSBColor((float)Math.random(),1,1);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(colors[0]);
        g.drawRect(200, 150, 100, 234);

        g.setColor(colors[1]);
        g.drawRect(321, 23, 32, 43);

        g.setColor(colors[2]);
        g.drawRect(244, 12, 40, 432);
    }
}
