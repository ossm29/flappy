package Controller;

import Model.Model;
import View.View;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** Classe controleur : gère les modifications de l’état du modèle */
public class Controller implements MouseListener, KeyListener {

    /* ATTRIBUTS */
    Model model;
    View view;

    /* Constructeur du contrôleur à partir d'une vue et d'un modèle */
    public Controller(Model model, View v) {
        this.model = model;
        this.view = v;

    }

    /** fonction qui déclenche le saut lors d'un clic de l'utilisateur */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(model.GameOver) {
            /* si la partie est perdue on retire le Listener*/
            view.removeMouseListener(this);
        } else {
            /* sinon le clic déclenche un saut*/
            model.jump();
            /* mise à jour de l'affichage*/
            view.refresh.setEdited();
        }
    }

    /** fonction qui déclenche le saut lors d'un appui sur la touche ESPACE de l'utilisateur */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            /* si la partie est perdue on retire le Listener*/
            if(model.GameOver) {
                view.removeMouseListener(this);
            } else {
                /* sinon le clic déclenche un saut*/
                model.jump();
                /* mise à jour de l'affichage*/
                view.refresh.setEdited();
            }
        }
    }

    /* Fonctions de gestion d'évènements non utiles */
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}


}
