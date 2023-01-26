import javax.swing.*;

/** Classe principale */
public class Main {
    /** fonction main qui lance le programme */
    public static void main(String[] args) {

        /* On construit un objet de chaque classe (Modèle Vue Contrôleur) et on les relie : */
        /* construction du modèle */
        Model M = new Model();
        /*construction de la vue */
        View V = new View(M);
        /* construction du controleur */
        Controller C = new Controller(M,V);
        /*ajout du contrôleur à l'affichage */
        V.setController(C);

        /* création d'une fenêtre d'affichage */
        JFrame window = new JFrame("window");
        /* la fermeture de la fenêtre doit arrêter le programme */
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* ajout de l'affichage à la fenêtre */
        window.add(V);
        /* la taille de la fenêtre doit être ≥ à celle de son contenu */
        window.pack();
        /* affichage de la fenêtre */
        window.setVisible(true);
    }


}