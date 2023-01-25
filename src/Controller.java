import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener, KeyListener {

    Model model;
    View view;

    /* Constructeur du controleur à partir d'une vue */
    public Controller(Model model,View v) {
        this.model = model;
        this.view = v;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        model.jump();
        view.repaint(45, model.getflappyY()-5,25,130); //on redessine la zone autour du cercle avec une marge de 5px
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.jump();
            view.repaint(45, model.getflappyY()-5,25,130); //on redessine la zone autour du cercle avec une marge de 5px
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}


}
