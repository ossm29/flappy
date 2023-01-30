package Model;
/** Classe qui hérite de Thread qui fait redescendre progressivement flappy*/
public class Fly extends Thread {

    /* Attribut modele */
    Model model;

    /**CONSTRUCTEUR de fly à partir d'un modèle*/
    public Fly(Model m) {
        this.model = m;
    }

    /* méthode run thread */
    @Override
    public void run() {
        /*boucle infinie pour faire chuter flappy*/
        while(!model.GameOver) {
            model.fall();
            /*pause entre chaque chute*/
            try {
                Thread.sleep(Model.fallspeed);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
