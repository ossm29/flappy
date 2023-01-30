import Controller.Controller;
import Model.*;
import View.*;

import javax.swing.*;

import static java.lang.Thread.sleep;

/** Classe principale */
public class Main {
    /** fonction main qui lance le programme */
    public static void main(String[] args) {

        /* On construit un objet de chaque classe (Modèle Vue Contrôleur) et on les relie : */

        /* construction du chemin */
        Path P = new Path();

        /* construction du modèle à partir du chemin */
        Model M = new Model(P);

        /* construction de la vueOiseaux */
        BirdView birdView = new BirdView();

        /*construction de la vue à partir du modèle, du chemin et de la vueOiseaux*/
        View V = new View(M,P,birdView);
        /*on associe la vue au modèle*/
        M.view = V;
        /* construction du contrôleur à partir du modèle et de la vue */
        Controller C = new Controller(M,V);
        /*ajout du contrôleur à l'affichage */
        V.setController(C);

        /* thread de rafraichissement d'affichage */
        Repaint updater = new Repaint(M,V);
        /* On lie le thread de rafraichissement à la vue*/
        V.setRefresh(updater);

        /*création du vol à partir du modèle*/
        Fly F = new Fly(M);

        /* création du défilement à partir du parcours, de la vue et du modèle*/
        Avancer avancer = new Avancer(P,V,M);

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

        /*pause de 3 secondes avant le démarrage du jeu*/
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Bird(birdView).start();

        /* démarrage du vol */
        F.start();
        /* démarrage du défilement */
        avancer.start();

    }

}