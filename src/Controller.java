import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener, KeyListener {

    /* ATTRIBUTS */
    Model model;
    View view;

    /* Constructeur du contrôleur à partir d'une vue et d'un modèle */
    public Controller(Model model,View v) {
        this.model = model;
        this.view = v;

    }

    /** fonction qui déclenche le saut lors d'un clic de l'utilisateur */
    @Override
    public void mouseClicked(MouseEvent e) {
        model.jump();
        view.repaint(45, model.getflappyY()-5,25,130); //on redessine la zone autour du cercle avec une marge de 5px
    }

    /** fonction qui déclenche le saut lors d'un appui sur la touche ESPACE de l'utilisateur */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.jump();
            view.repaint(45, model.getflappyY()-5,25,130); //on redessine la zone autour du cercle avec une marge de 5px
        }
    }

    /* Fonctions de gestion d'évènements non utiles */
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
