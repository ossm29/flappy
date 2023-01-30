package View;

import Model.*;

/** Classe qui implémente un thread pour faire avancer la position */
public class Avancer extends Thread {

    /** ATTRIBUTS */
    /* Vue dans laquelle on fait avancer*/
    View vue;
    /* Parcours à faire défiler */
    Path path;

    Model model;



    /** CONSTANTES*/
    /* vitesse de défilement du parcours définie par le temps de pause entre chaque pas*/
    public static final int speedAvancer = 4500;

    /** CONSTRUCTEUR à partir d'un parcours et d'une vue
     * @param path : parcours
     * @param vue : vue
     */
    public Avancer(Path path, View vue, Model model) {
        /*on initialise les 3 attributs avec les paramètres*/
        this.path = path;
        this.vue = vue;
        this.model = model;
    }

    /* méthode run thread */
    @Override
    public void run() {
        while(!model.GameOver) {
            /*pour avancer, on incrémente la position d'un pas*/
            this.path.position += Model.step;

            /*ajoute un oiseau dans le décor avec une probabilité de 20%*/
            this.vue.birdView.generateBird();

            /* on redéssine la vue*/
            vue.refresh.setEdited();

            /*entre chaque pas, on fait une courte pause*/
            try {
                Thread.sleep(speedAvancer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
