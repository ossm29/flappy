package Model;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/** Classe Path qui décrit le parcours*/
public class Path {
    public static final Random rand = new Random();

    /*la distance minimale entre les abscisses des points du parcours*/
    public int minX_dist = 120;
    public ArrayList<Point> path;

    /** Constructeur*/
    public Path() {
        this.path = new ArrayList<Point>();
        /*On place le premier point au niveau du départ de flappy*/
        Point start = new Point(Model.flappyX,Model.HEIGHT/2);
        this.path.add(start);
        /* On récupère le dernier point de la liste*/
        Point lastPoint = path.get(0);

        while(lastPoint.x < Model.WIDTH) {
            /* On récupère le dernier point de la liste*/

            lastPoint = path.get(path.size()-1);

            /*On ajoute un point éloigné en x d'au moins minX_dist et d'ordonnée aléatoire (on prévoit une marge de la taille de flappy entre chaque extrémité de l'écran*/
            path.add(new Point(lastPoint.x+rand.nextInt(minX_dist,2*minX_dist), rand.nextInt(Model.FlappyH,Model.HEIGHT-Model.FlappyH)));

            //System.out.println(lastPoint.x+","+lastPoint.y+"\n");

        }
    }

    /** getter qui retourne la liste de points du parcours */
    public ArrayList<Point> getPath() {
        return path;
    }


}
