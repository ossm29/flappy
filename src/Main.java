import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // On construit un objet de chaque classe (MVC) et on les relie
        Model M = new Model();
        View V = new View(M);
        Controller C = new Controller(M,V);
        V.setController(C);

        // On créé une fenêtre dans laquelle on ajoute la vue
        JFrame test = new JFrame("Test dessin");
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.add(V);
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