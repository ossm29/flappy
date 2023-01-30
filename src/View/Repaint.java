package View;

import Model.Model;

/** thread d'affichage qui s'éxécute au moins 24 fois par seconde afin de fluidifier l'affichage */
public class Repaint extends Thread {
    /** ATTRIBUTS */
    /* booleen qui indique si le modèle a été modifié */
    private boolean edited;
    private Model model;
    private View view;

    /** CONSTRUCTEUR du thread à partir d'un modèle et d'une vue */
    public Repaint(Model m, View v) {
        /* on initialise les attributs avec les paramètres */
        this.edited = false;
        this.model = m;
        this.view = v;
        /* on lance le thread dans le constructeur */
        this.start();
    }

    /* méthode run thread */
    @Override
    public void run() {
        /*tant que la partie est en cours*/
        while (!model.GameOver) {
            /* si le modèle a été modifié*/
            if(edited) {
                view.repaint();
                edited = false;
            }
            /*on dessine 24 fois par seconde*/
            try {
                Thread.sleep(1000/24);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* méthode qui permet aux threads d'alerter que le modèle est modifié */
    public void setEdited() {
        this.edited = true;
    }


}
