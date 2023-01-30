package Model;

import View.BirdView;

import java.util.Random;

public class Bird extends Thread {
    /** ATTRIBUTS */
    /*indique le temps (en millisecondes) entre chaque mise à jour de l’affichage pour l’oiseau*/
    private int delai;
    /*permet de savoir dans quelle position est l’oiseau*/
    private int etat;
    /*définit la hauteur de l’oiseau dans la fenêtre graphique*/
    private int hauteur;
    /*définit l’abscisse de l’oiseau dans la fenêtre graphique*/
    private int position;

    private BirdView birdView = new BirdView();

    Random rand = new Random();

    /** CONSTRUCTEUR de l'oiseau , paramètre vueOiseau
     * choisit une valeur aléatoire pour le délai et la hauteur.
     * la position est fixée de manière à ce que l’oiseau soit complètement à droite, au delà de la fenêtre visible
     * */
    public Bird(BirdView bw) {
        /* délai aléatoire entre 100 et 200 ms */
        this.delai = rand.nextInt(100,200);
        /* on initialise l'état à 0 */
        this.etat = 0;
        /* hauteur aléatoire entre 0,2 et 0,8 fois la hauteur de la fenêtre */
        this.hauteur = rand.nextInt((int) (0.2* Model.HEIGHT), (int) (0.8*Model.HEIGHT));
        /* abscisse au delà de la fenêtre visible */
        this.position = Model.WIDTH+3;
        /* liaison à vueOiseau */
        this.birdView = bw;
        this.birdView.addBird(this);
    }

    /**GETTERS*/

    /* getter de délai */
    public int getDelai() {
        return this.delai;
    }
    /* getter d'état */
    public int getEtat() {
        return this.etat;
    }
    /* getter de hauteur */
    public int getHauteur() {
        return this.hauteur;
    }
    /* getter de position */
    public int getPosition() {
        return this.position;
    }

    /** Methode isHERE : renvoi vrai si l'oiseau n'a pas encore fini de traverser l'écran
     * renvoi faux si l'oiseau a complètement traversé la zone visible
     */
    public boolean isHere() {
        return (this.position > -200);
    }

    /** Methode updateEtat : met à jour l'état de l'oiseau (augmente de 0 à 8 puis retourne à 0) */
    public void updateEtat() {
        this.etat = (this.etat+1)%8;
    }

    /* méthode run thread */
    @Override
    public void run() {
        while (this.isHere()) {
            /* déplace l'oiseau de 10 pixels à chaque appel */
            this.position -= 10;
            /* met l'état à jour */
            this.updateEtat();
            /* pause de delai entre chaque mise à jour*/
            try {
                Thread.sleep(delai);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /* l’oiseau doit être retiré de la liste lorsque son thread s’arrête */
        this.birdView.removeBird(this);
    }

}
