import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

class DestroyAfter implements Runnable {

    private int span;

    DestroyAfter(int seconds) {
        this.span = seconds;
        this.run();
    }

    @Override
    public void run() {
        for(int i=span; i>=0; i--) {
            span--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Span time is over!");
        System.exit(0);
    }
}

public class Zadanie1 {

    private static JPanel colorPanel;
    private static JLabel hueLabel;
    private static JFrame mainFrame;
    private static SwingWorker hue_worker;
    private static JButton btn;
    private static JSlider hue_slider;

    private static float hue = 0;

    private static ActionListener start = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            starWorker();
            btn.addActionListener(stop);
            btn.removeActionListener(start);
            hue_slider.setEnabled(false);
        }
    };

    private static  ActionListener stop = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            hue_worker.cancel(true);
            btn.addActionListener(start);
            btn.removeActionListener(stop);
            hue_slider.setEnabled(true);
        }
    };

    public static void initFrame() {
        mainFrame = new JFrame("Swing Worker");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(2, 1));

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        colorPanel = new JPanel();
        mainFrame.add(colorPanel);

        hueLabel = new JLabel(String.format("hue value: %.2f", hue*179));
        colorPanel.add(hueLabel);

        btn = new JButton("Start counter");
        btn.addActionListener(start);

        hue_slider = new JSlider(0,1000,(int)hue*1000);
        hue_slider.addChangeListener(e ->{
            hue = (float)hue_slider.getValue()/1000;
            colorPanel.setBackground(Color.getHSBColor(hue, 1, 1));
            hueLabel.setText(String.format("hue value: %.2f",hue*179));
        });
        colorPanel.add(hue_slider);

        mainFrame.add(btn);
        mainFrame.setVisible(true);
    }

    private static void starWorker() {
        hue_worker = new SwingWorker() {

            boolean stop = false;
            float step = 0.01f;

            @Override
            protected Object doInBackground() throws Exception {
                while (!stop) {
                    if (hue >= 1) hue = 0;
                    else hue += step;
                    Thread.sleep(10);
                    publish(hue);
                }
                return null;
            }

            @Override
            protected void process(List chunks) {
                float hue = (float) chunks.get(chunks.size() - 1);
                colorPanel.setBackground(Color.getHSBColor(hue, 1, 1));
                hueLabel.setText(String.format("hue value: %.2f",hue*179));
                hue_slider.setValue((int)(hue*1000));
            }
        };

        hue_worker.execute();
    }

    public static void main(String[] args) {
        initFrame();
        DestroyAfter destroyer = new DestroyAfter(20);
        destroyer.run();
    }
}