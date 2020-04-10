package przyklad2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class InnerClassListenerFrame extends JFrame {

    JSlider slider;
    JLabel label;

    public InnerClassListenerFrame() throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(600,50);

        slider = new JSlider(0,100,20);
        this.add(slider, BorderLayout.LINE_START);

        label = new JLabel("value: "+slider.getValue());
        this.add(label);

        slider.addChangeListener(new SliderChangeListener());
    }

    public class SliderChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            label.setText("value: "+slider.getValue());
        }
    }

    public static void main(String[] args){
        InnerClassListenerFrame frame = new InnerClassListenerFrame();
        frame.setVisible(true);
    }
}
