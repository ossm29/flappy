public class Model {

    /* CONSTANTES */

    public static final int WIDTH = 600; //largeur fenêtre
    public static final int HEIGHT = 400; //hauteur fenêtre

    private int flappyY = 300;
    public int jumpSize = 30;


    public int getflappyY() {
        return this.flappyY;
    }

    public void jump() {
        if(flappyY-jumpSize > 0) {
            flappyY -= jumpSize;
        }
    }
}
