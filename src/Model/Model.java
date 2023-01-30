package Model;

import View.View;

import javax.swing.*;
import java.awt.*;

/** Classe Model.Model : définit l’ensemble des données qui caractérisent l’état de  l'interface */
public class Model {


    /* CONSTANTES */
    /** largeur fenêtre */
    public static final int WIDTH = 800;
    /** hauteur fenêtre */
    public static final int HEIGHT = 500;
    /** temps de pause entre chaque chute (en millisecondes) */
    public static final int fallspeed = 120;
    /** largeur ovale */
    public static final int FlappyW = 40;
    /** longueur ovale */
    public static final int FlappyH = 200;
    /** incrément de la position */
    public static final int step = 2;

    /** position en abscisse de l'ovale */
    public static final int flappyX = (int) (0.2 * WIDTH);

    /** ATTRIBUT VUE POUR APPELER REPAINT*/
    public View view;
    public Path path;

    /** VARIABLES */
    /* booleen qui indique si la partie est perdue*/
    public boolean GameOver = false;

    /* variable hauteur de l'ovale qu'on initialise au milieu*/
    public int flappyY = (int) (0.5 * HEIGHT);

    /* variable taille du saut */
    public int jumpSize = 40;
    /* variable taille de la chute */
    public int fallSize = 12;

    /** CONSTRUCTEUR */
    public Model(Path path) {
        this.path = path;
    }

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
        view.refresh.setEdited();
        testPerdu();
    }

    /** fonction permettant de diminuer la hauteur de l'ovale en restant dans les dimensions de l'affichage */
    public void fall() {
        /*si on reste dans l'affichage, on diminue la hauteur de flappy*/
        if(flappyY+fallSize < HEIGHT-FlappyH) {
            flappyY += fallSize;
        }
        /*on rafraichit la vue après la chute*/
        view.refresh.setEdited();
        testPerdu();
    }

    /** méthode qui détermine si l'ovale est sorti de la ligne
     * retourne vrai si il y a collision
     */
    public boolean testPerdu() {
        /* coordonnées du centre de l'ovale */
        int xcenter = flappyX+FlappyW/2;
        int ycenter = flappyY+FlappyH/2;

        /*On laisse une marge au début de la partie, on ne peut pas perdre avant que le défilement ait commencé*/
        if(this.path.position <= 3) {
            return false;
        }

        /* on récupère les coordonnées relatives des points suivant et précédant l'ovale */
        Point precedent = new Point();
        Point suivant = new Point();
        for (int i = 0; i < this.path.getPath().size()-1;i++) {
            Point tmp = new Point(this.path.getPath().get(i));
            if(tmp.x > flappyX) {
                precedent = new Point(this.path.getPath().get(i - 1));
                suivant = new Point(tmp);
                /*lorsqu'on a trouvé les points on quitte la boucle*/
                break;
            }
        }
        /* pente de la droite qui lie les deux points */
        float m = (suivant.y-precedent.y) / (float) (suivant.x-precedent.x);
        /* valeur de l’ordonnée sur la ligne brisée au point d’abscisse correspondant à la position 0 de l’ovale (flappyX) */
        float yPath = precedent.y+ m*(xcenter-precedent.x);
        /* condition de collision (on prévoit une marge de 2 px) */
        if(!((yPath > ycenter - (float) FlappyH/2) && (yPath < ycenter+ (float) FlappyH/2 ))) {
            /* la partie est perdue */
            GameOver = true;
            /* On affiche un message avec le score de la partie */
            JOptionPane.showMessageDialog(view, "GAME OVER ! \n SCORE :"+path.position);
        }
        return GameOver;

    }
}
