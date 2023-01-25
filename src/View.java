import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class View extends JPanel {


    /** CONSTANTES */
    public static final int HEIGHT = 400;
    public static final int WIDTH = 600;
    public static final int FlappyW = 15; // Flappy Width
    public static final int FlappyH = 90; // Flappy Height


    public Model model;


    /** CONSTRUCTEUR */
    public View(Model m) {
        this.model = m;
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));

    }

    public void setController(Controller c) {
        this.addMouseListener(c);
        this.addKeyListener(c);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50, model.getflappyY(),FlappyW,FlappyH);
    }


}
