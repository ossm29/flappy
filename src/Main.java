import Controller.Controller;
import Model.*;
import View.*;

import javax.swing.*;

/** Classe principale */
public class Main {
    /** fonction main qui lance le programme */
    public static void main(String[] args) {

        /* On construit un objet de chaque classe (Modèle Vue Contrôleur) et on les relie : */
        /* construction du modèle */
        Model M = new Model();

        /* construction du chemin */
        Path P = new Path();

        /*construction de la vue */
        View V = new View(M,P);
        /*on associe la vue au modèle*/
        M.view = V;
        /* construction du controleur */
        Controller C = new Controller(M,V);
        /*ajout du contrôleur à l'affichage */
        V.setController(C);

        /*création du vol à partir du modèle*/
        Fly F = new Fly(M);

        /* création du défilement à partir du parcours et de la vue */
        Avancer avancer = new Avancer(P,V);

        /* création d'une fenêtre d'affichage */
        JFrame window = new JFrame("Flappy "+Model.WIDTH+"x"+Model.HEIGHT);
        /* la fermeture de la fenêtre doit arrêter le programme */
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* ajout de l'affichage à la fenêtre */
        window.add(V);
        /* la taille de la fenêtre doit être ≥ à celle de son contenu */
        window.pack();

        /* affichage de la fenêtre */
        window.setVisible(true);

        /* démarrage du vol */
        F.start();
        /* démarrage du défilement */
        avancer.start();

    }

}