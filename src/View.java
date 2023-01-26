import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class View extends JPanel {

    /* Attribut modele (pour accéder à l’état du modèle et modifier l'affichage en conséquence) */
    public Model model;


    /** CONSTRUCTEUR de la vue à partir d'un modèle
     * @param m de type Model
     */
    public View(Model m) {
        this.model = m;
        this.setPreferredSize(new Dimension(Model.WIDTH,Model.HEIGHT));

    }

    /** méthode qui permet d'ajouter un contrôleur à l'affichage
     * @param c de type Controller à lier à l'affichage
     */
    public void setController(Controller c) {
        /*ajoute un listener de la souris (pour détecter clics)*/
        this.addMouseListener(c);
        /*ajoute un listener du clavier (pour détecter ESPACE) */
        this.addKeyListener(c);
    }

    /** fonction de dessin sur la fenêtre
     * @param g objet graphique
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*dessin de l'ovale*/
        g.drawOval(50, model.getflappyY(),Model.FlappyW,Model.FlappyH);
    }


}
