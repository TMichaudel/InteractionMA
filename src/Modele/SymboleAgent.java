/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiba
 */
public class SymboleAgent extends Thread {

    private int posX;
    private int posY;
    private int posFinaleX;
    private int posFinaleY;
    private Grille grille;
    private Symboles symbole;
    private boolean isSatisfied;

    public SymboleAgent(int posX, int posY, int posFinaleX, int posFinaleY, Grille grille, Symboles symbole) {
        this.isSatisfied = false;
        this.posX = posX;
        this.posY = posY;
        this.posFinaleX = posFinaleX;
        this.posFinaleY = posFinaleY;
        this.grille = grille;
        this.symbole = symbole;
        grille.setCase(posX, posY, this);
    }

    @Override
    public void run() {
        while (!grille.isComplete) {
            if ((posX < posFinaleX) && (grille.getCase(posX + 1, posY).equals(Symboles.VIDE))) {
                posX++;
                grille.setCase(posX, posY, this);
                grille.setCaseVide(posX - 1, posY);
            } else if ((posX > posFinaleX) && (grille.getCase(posX - 1, posY).equals(Symboles.VIDE))) {
                posX--;
                grille.setCase(posX, posY, this);
                grille.setCaseVide(posX + 1, posY);
            } else if ((posY < posFinaleY) && (grille.getCase(posX, posY + 1).equals(Symboles.VIDE))) {
                posY++;
                grille.setCase(posX, posY, this);
                grille.setCaseVide(posX, posY - 1);
            } else if ((posY > posFinaleY) && (grille.getCase(posX, posY - 1).equals(Symboles.VIDE))) {
                posY--;
                grille.setCase(posX, posY, this);
                grille.setCaseVide(posX, posY + 1);
            } else {
                if (posX < posFinaleX) {
                    grille.addMessage(new Message(MessageTypes.DEPLACEMENT, this.getSymbole(),
                            grille.getCase(posX + 1, posY), posX + 1, posY, grille.getIdMessage()));
                    grille.incrementIdMessage();
                } else if (posX > posFinaleX) {
                    grille.addMessage(new Message(MessageTypes.DEPLACEMENT, this.getSymbole(),
                            grille.getCase(posX - 1, posY), posX - 1, posY, grille.getIdMessage()));
                    grille.incrementIdMessage();
                }
                if (posY < posFinaleY) {
                    grille.addMessage(new Message(MessageTypes.DEPLACEMENT, this.getSymbole(),
                            grille.getCase(posX, posY + 1), posX, posY + 1, grille.getIdMessage()));
                    grille.incrementIdMessage();
                } else if (posY > posFinaleY) {
                    grille.addMessage(new Message(MessageTypes.DEPLACEMENT, this.getSymbole(),
                            grille.getCase(posX, posY - 1), posX, posY - 1, grille.getIdMessage()));
                    grille.incrementIdMessage();
                }
            }

            grille.affichage();
            if ((posX == posFinaleX) && (posY == posFinaleY)) {
                isSatisfied = true;
            }
            grille.checkVictory();
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SymboleAgent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosFinaleX() {
        return posFinaleX;
    }

    public int getPosFinaleY() {
        return posFinaleY;
    }
    
    public Symboles getSymbole() {
        return symbole;
    }

}
