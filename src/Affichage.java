import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Affichage extends JPanel {

    /** CONSTANTES */
    public static final int HEIGHT = 400;
    public static final int WIDTH = 600;
    public static int HAUTEUR = 300;
    public static int SAUT = 30;


    /** CONSTRUCTEUR */
    public Affichage() {
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.addMouseListener(new ReagirClick());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(50,HAUTEUR,15,90);
    }

    public class ReagirClick implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
                HAUTEUR = HAUTEUR - SAUT;
                repaint(45,HAUTEUR-5,25,130); //on redessine la zone autour du cercle avec une marge de 5px
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

    }

}
