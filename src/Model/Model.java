package Model;

import View.View;

/** Classe Model.Model : définit l’ensemble des données qui caractérisent l’état de  l'interface */
public class Model {


    /* CONSTANTES */
    /** largeur fenêtre */
    public static final int WIDTH = 800;
    /** hauteur fenêtre */
    public static final int HEIGHT = 500;
    /** temps de pause entre chaque chute (en millisecondes) */
    public static final int fallspeed = 100;
    /** largeur ovale */
    public static final int FlappyW = 15;
    /** longueur ovale */
    public static final int FlappyH = 90;
    /** incrément de la position */
    public static final int step = 3;

    /** position en abscisse de l'ovale */
    public static final int flappyX = (int) (0.2 * WIDTH);

    /** ATTRIBUT VUE POUR APPELER REPAINT*/
    public View view;
    public Path path;

    /** VARIABLES */

    /* variable hauteur de l'ovale qu'on initialise au milieu*/
    public int flappyY = (int) (0.5 * HEIGHT);

    /* variable taille du saut */
    public int jumpSize = 30;
    /* variable taille de la chute */
    public int fallSize = 10;

    /** CONSTRUCTEUR */


    /** getter qui retourne la hauteur de notre ovale */
    public int getFlappyY() {
        return this.flappyY;
    }

    /** fonction permettant d'augmenter la hauteur de l'ovale en restant dans les dimensions de l'affichage */
    public void jump() {
        /*si on reste dans l'affichage, on augmente la hauteur de flappy*/
        if(flappyY-jumpSize > 0) {
            flappyY -= jumpSize;
        }
    }

    /** fonction permettant de diminuer la hauteur de l'ovale en restant dans les dimensions de l'affichage */
    public void fall() {
        /*si on reste dans l'affichage, on diminue la hauteur de flappy*/
        if(flappyY+fallSize < HEIGHT-FlappyH) {
            flappyY += fallSize;
        }
        /*on rafraichit la vue après la chute*/
        view.repaint();
    }
}
