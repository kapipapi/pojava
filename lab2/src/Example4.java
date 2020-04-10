import java.awt.*;

public class Example4 {
    public static void main(String[] args) {
        CloseableFrame frame = new CloseableFrame("Example3");

        DrawablePanel panel = new DrawablePanel();
        panel.setBackground(Color.white);
        frame.add(panel);

        frame.setVisible(true);
    }
}
