package Model;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/** Classe Path qui décrit le parcours*/
public class Path {
    /* création objet random*/
    public static final Random rand = new Random();

    /*la distance minimale entre les abscisses des points du parcours*/
    public int minX_dist = Model.WIDTH/2;

    /** ATTRIBUTS */
    /* liste de points du parcours*/
    public ArrayList<Point> path;

    /*variables*/
    public int position;


    /** Constructeur du parcours (liste de points de la ligne brisée) */
    public Path() {

        /* initialisation de la position */
        this.position = 0;

        this.path = new ArrayList<Point>();
        /*On place le premier point au niveau du départ de flappy*/
        Point start = new Point(Model.flappyX,Model.HEIGHT/2);
        this.path.add(start);
        /*on ajoute un point pour commencer le jeu par une petite ligne droite*/
        this.path.add(new Point(start.x+minX_dist,Model.HEIGHT/2));
        /* on initialise le parcours avec des points d'abscisse croissante */
        initPath();
    }

    /** Methode initPath
     * initialise le parcours avec des points d'abscisse croissante
     */
    public void initPath() {

        /* On récupère 2e point de la liste (après la ligne droite initialisée). */
        Point lastPoint = path.get(1);

        while(lastPoint.x < Model.WIDTH) {
            /* On récupère le dernier point de la liste*/

            lastPoint = path.get(path.size()-1);

            /*On ajoute un point éloigné en x d'au moins minX_dist et d'ordonnée aléatoire (on prévoit une marge de la taille de flappy entre chaque extrémité de l'écran*/
            path.add(new Point(lastPoint.x+rand.nextInt(minX_dist,2*minX_dist), rand.nextInt(Model.HEIGHT/3,2*Model.HEIGHT/3)));

            //System.out.println(lastPoint.x+","+lastPoint.y+"\n");

        }
    }

    /** getter qui retourne la liste de points visibles du parcours */
    public ArrayList<Point> getPath() {

        /* on soustrait la valeur position à la valeur d’abscisse des points */
        for(Point point : path) {
            point.x -= position;
        }

        /*on élimine de la liste les points qui ne sont plus visibles :    */
        /* si le 2e point n'est plus visible*/
        if(path.get(1).x < 0) {
            /*on élimine le premier point */
            path.remove(0);
        }

        /*on récupère le dernier point*/
        Point lastPoint = path.get(path.size()-1);

        /*si le dernier point est visible, on génère un nouveau point*/
        if(lastPoint.x < Model.WIDTH) {
            path.add(new Point(lastPoint.x+rand.nextInt(minX_dist,2*minX_dist), rand.nextInt(Model.HEIGHT/3,2*Model.HEIGHT/3)));
        }

        return path;
    }

    /** getter qui retourne la variable position du parcours */
    public int getPosition() {
        return this.position;
    }


}
