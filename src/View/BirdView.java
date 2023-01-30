package View;

import Model.Bird;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/** Classe gérant le dessin des oiseaux dans le décor */

public class BirdView {
    Random rand = new Random();

    /** ATTRIBUTS */
    /*attribut principal*/
    private ArrayList<Bird> birds;

    /** CONSTRUCTEUR */
    public BirdView() {
        this.birds = new ArrayList<Bird>();
    }

    /** ajoute un oiseau à la liste */
    public void addBird(Bird bird) {
        this.birds.add(bird);
    }

    /** retire un oiseau de la liste */
    public void removeBird(Bird bird) {
        birds.remove(bird);
    }

    /** fonction génératrice d'oiseaux
     * ajoute 1 fois sur 5 un oiseau à la liste
     * méthode appelée dans le thread Avancer
     */
    public void generateBird() {
        /* on génère un nombre entre 0 et 4, si il est égal à 4 on ajoute un oiseau*/
        if(rand.nextInt(5) == 4) {
            birds.add(new Bird(this));
        }
    }

    /** méthode de dessin des oiseaux
     * @param g objet graphique
     */
    public void drawBird(Graphics g) {
        for(Bird bird : birds) {
            /* On récupère l'image associée à l'état de l'oiseau*/
            Image image = new ImageIcon("ressources/bird"+bird.getEtat()+".png").getImage();
            /* on dessine l'image dans g*/
            g.drawImage(image,bird.getPosition(),bird.getHauteur(),60,60,null);
        }
    }

}
