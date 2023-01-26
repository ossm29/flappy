/** Classe Model : définit l’ensemble des données qui caractérisent l’état de  l'interface */
public class Model {

    /* CONSTANTES */

    /** largeur fenêtre */
    public static final int WIDTH = 600;
    /** hauteur fenêtre */
    public static final int HEIGHT = 400;
    /** largeur ovale */
    public static final int FlappyW = 15;
    /** longueur ovale */
    public static final int FlappyH = 90; // Flappy Height

    /** VARIABLES */

    /* variable hauteur de l'ovale*/
    private int flappyY = 300;
    /* variable taille du saut */
    public int jumpSize = 30;

    /** getter qui retourne la hauteur de notre ovale */
    public int getflappyY() {
        return this.flappyY;
    }

    /** fonction permettant d'augmenter la hauteur de l'ovale en restant dans les dimensions de l'affichage */
    public void jump() {
        if(flappyY-jumpSize > 0) {
            flappyY -= jumpSize;
        }
    }
}
