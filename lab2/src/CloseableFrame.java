import javax.swing.*;
import java.awt.*;

public class CloseableFrame extends JFrame {

    public CloseableFrame() throws HeadlessException {
        custom_setup();
    }

    public CloseableFrame(GraphicsConfiguration gc) {
        super(gc);
        custom_setup();
    }

    public CloseableFrame(String title) throws HeadlessException {
        super(title);
        custom_setup();
    }

    public CloseableFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
        custom_setup();
    }

    void custom_setup() {
        this.setSize(640, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        CloseableFrame cf = new CloseableFrame("TEST");
        cf.setVisible(true);
    }

}
