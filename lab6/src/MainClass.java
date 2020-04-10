import sun.plugin.javascript.navig.Image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

class Prostokat implements Runnable {

    private int xPos = 50;
    private int yPos = 50;

    private int xVel = 0;
    private int yVel = 0;

    private int width = 20;
    private int height = 20;
    private Color color = Color.BLACK;

    private boolean animateWithPictures = false;
    private BufferedImage[] image;
    private int frame = 0;
    private boolean loop = true;

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setX(int xPos) {
        this.xPos = xPos;
    }

    public void setY(int yPos) {
        this.yPos = yPos;
    }

    public int getXvel() {
        return xVel;
    }

    public int getYvel() {
        return yVel;
    }

    public void setXvel(int xVel) {
        this.xVel = xVel;
    }

    public void setYvel(int yVel) {
        this.yVel = yVel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paint(Graphics g) {
        if (!this.animateWithPictures) {
            g.setColor(getColor());
            g.fillRect(xPos, yPos, getWidth(), getHeight());
        } else {
            g.drawImage(image[frame], getX(), getY(), null);
        }
    }

    public void update() {
        this.xPos += this.xVel;
        this.yPos += this.yVel;
    }

    public void setImages() {
        this.animateWithPictures = true;
        image = new BufferedImage[75];
        for (int i = 0; i < 74; i++) {
            try {
                String path = "lab6/src/img/dijkstra-" + i + ".png";
                image[i] = ImageIO.read(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            frame++;
            if (frame > 74) frame = 0;
        }
    }
}

class UpdatePanelRysowania extends Thread {

    private PanelRysowania panel;

    UpdatePanelRysowania(PanelRysowania panel) {
        this.panel = panel;
    }

    public void run() {
        while (true) {
            try {
                sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Prostokat p : this.panel.prostakaty) {
                p.update();
            }
            this.panel.repaint();
        }
    }
}

class PanelRysowania extends JPanel {

    private static final long serialVersionUID = 1L;
    List<Prostokat> prostakaty = new ArrayList<Prostokat>();
    UpdatePanelRysowania update;

    public PanelRysowania() {
        update = new UpdatePanelRysowania(this);
        update.start();
    }

    public void dodajLosowyProstokat() {
        Random r = new Random();

        Prostokat p = new Prostokat();
        p.setX(r.nextInt(550));
        p.setY(r.nextInt(550));
        p.setXvel(r.nextInt(10) * (r.nextFloat() > 0.5 ? -1 : 1));
        p.setYvel(r.nextInt(10) * (r.nextFloat() > 0.5 ? -1 : 1));
        p.setWidth(r.nextInt(80));
        p.setHeight(r.nextInt(80));
        p.setColor(new Color(r.nextInt(255), r.nextInt(255),
                r.nextInt(255), r.nextInt(255)));

        prostakaty.add(p);
    }

    public void dodajProstokat(int x, int y, int width, int height, Color c) {
        Prostokat p = new Prostokat();
        p.setX(x);
        p.setY(y);
        p.setWidth(width);
        p.setHeight(height);
        p.setColor(c);

        prostakaty.add(p);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Prostokat pr : prostakaty) {
            pr.paint(g);
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}

public class MainClass {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame f = new JFrame("Prostokaty");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                PanelRysowania panel = new PanelRysowania();

                panel.dodajProstokat(100, 100, 80, 160, Color.BLUE);
                panel.prostakaty.get(0).setXvel(1);
                panel.prostakaty.get(0).setImages();
                Thread t1 = new Thread(panel.prostakaty.get(0));
                t1.start();

                for (int i = 1; i < 10; i++) panel.dodajLosowyProstokat();

                f.add(panel);
                f.setSize(600, 600);
                f.setVisible(true);
            }
        });

    }

}

