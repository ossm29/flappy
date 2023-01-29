package View;

import Model.*;

public class Avancer extends Thread {

    /** ATTRIBUTS */
    /* Vue dans laquelle on fait avancer*/
    View vue;
    /* Parcours à faire déflier */
    Path path;

    /** CONSTANTES*/
    /* vitesse de défilement du parcours */
    public static final int speedAvancer = 4000;

    /** CONSTRUCTEUR à partir d'un parcours et d'une vue
     * @param path : parcours
     * @param vue : vue
     */
    public Avancer(Path path, View vue) {
        this.path = path;
        this.vue = vue;
    }

    @Override
    public void run() {
        while(true) {
            /*pour avancer, on incrémente la position d'un pas*/
            this.path.position += Model.step;
            /* on redéssine la vue*/
            vue.repaint();

            /*entre chaque pas, on fait une courte pause*/
            try {
                Thread.sleep(speedAvancer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
