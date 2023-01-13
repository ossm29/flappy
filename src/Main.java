import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame test = new JFrame("Test dessin");
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.add(new Affichage());
        test.pack();
        test.setVisible(true);
    }

    public static JFrame creerFenetre(String nom) {
        JFrame fenetre = new JFrame(nom);
        return fenetre;
    }

    public static void ajouteComposant(JFrame fenetre, JPanel composant) {
        fenetre.add(composant);
        fenetre.pack();
        fenetre.setVisible(true);
    }
}