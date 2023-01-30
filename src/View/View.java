package View;

import Controller.Controller;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/** Classe qui contient ce qui est relatif à l’affichage : gère la façon dont l’état du modèle est rendu visible à l’utilisateur */
public class View extends JPanel {

    /* Attribut modele (pour accéder à l’état du modèle et modifier l'affichage en conséquence) */
    public Model model;
    /* Attribut parcours pour afficher la ligne brisée*/
    public Path path;
    /* thread de rafraichissement d'affichage*/
    public Repaint refresh;

    public BirdView birdView;

    /** CONSTRUCTEUR de la vue à partir d'un modèle
     * @param m de type Model.Model
     */
    public View(Model m, Path p,BirdView BW) {
        this.model = m;
        this.path = p;
        this.birdView = BW;
        this.setPreferredSize(new Dimension(Model.WIDTH,Model.HEIGHT));
    }

    /** méthode qui permet d'ajouter un contrôleur à l'affichage
     * @param c de type Controller.Controller à lier à l'affichage
     */
    public void setController(Controller c) {
        /*ajoute un listener de la souris (pour détecter clics)*/
        this.addMouseListener(c);
        /*ajoute un listener du clavier (pour détecter ESPACE) */
        this.addKeyListener(c);
    }

    /** méthode qui permet d'ajouter le thread de rafraichissement à l'affichage
     * @param R de type View.Repaint à lier à l'affichage
     */
    public void setRefresh(Repaint R) {
        this.refresh = R;
    }

    /** fonction de dessin du parcours
     * @param g objet graphique
     */
    public void drawPath(Graphics g) {
        /*on récupère la liste des points du parcours*/
        ArrayList<Point> points = path.getPath();
        /*on dessine une ligne de chaque point à son suivant*/
        for(int i = 0; i < points.size()-1;i++) {
            g.drawLine(points.get(i).x,points.get(i).y,points.get(i+1).x,points.get(i+1).y);
        }
    }

    /** fonction de dessin du score
     * @param g objet graphique
     */
    public void drawScore(Graphics g) {
        /* on dessine un carré blanc à l'endroit où on écrira le score*/
        g.clearRect(10,10,90,30);
        /* on écrit le score */
        g.drawString("SCORE : "+this.path.getPosition(),20,30);

    }

    /** fonction de dessin sur la fenêtre
     * @param g objet graphique
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        /*dessin de l'ovale*/
        g.drawOval(Model.flappyX, model.getFlappyY(), Model.FlappyW,Model.FlappyH);
        /*dessin de la ligne brisée*/
        this.drawPath(g);
        if(this.birdView != null) {
            this.birdView.drawBird(g);
        }
        /* affichage du score */
        this.drawScore(g);
    }

}
