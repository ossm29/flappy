package Model;
/** Classe qui hérite de Thread qui fait redescendre progressivement flappy*/
public class Fly extends Thread {

    /* Attribut modele */
    Model model;

    /**CONSTRUCTEUR de fly à partir d'un modèle*/
    public Fly(Model m) {
        this.model = m;
    }

    @Override
    public void run() {
        /*boucle infinie pour faire chuter flappy*/
        while(true) {
            model.fall();
            /*pause entre chaque chute*/
            try {
                Thread.sleep(Model.sleeptime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}