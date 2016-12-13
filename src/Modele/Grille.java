/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author thiba
 */
public class Grille {

    private SymboleAgent[][] grille;
    private int taille = 5;
    public boolean isComplete;
    private int idMessage;
    private ArrayList<Message> listeMessages;

    public Grille() {
        grille = new SymboleAgent[taille][taille];
        idMessage=0;
        isComplete = false;
        listeMessages=new ArrayList();
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j] = new SymboleAgent(i, j, 0, 0, this, Symboles.VIDE);
            }
        }
    }

    public SymboleAgent[][] getGrille() {
        return grille;
    }

    public Symboles getCase(int x, int y) {
        if ((x < taille) && (x >= 0) && (y < taille) && (y >= 0)) {
            return grille[x][y].getSymbole();
        } else {
            return Symboles.OBSTACLE;
        }
    }

    public void setCase(int x, int y, SymboleAgent agent) {
        grille[x][y] = agent;
    }

    public void setCaseVide(int x, int y) {
        grille[x][y] = new SymboleAgent(x, y, 0, 0, this, Symboles.VIDE);
    }

    public int getIdMessage() {
        return idMessage;
    }
    
    public void incrementIdMessage(){
        idMessage++;
    }
    
    public void addMessage(Message m){
        listeMessages.add(m);
    }
    public void affichage() {
        System.out.println("__________");
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                switch (grille[i][j].getSymbole()) {
                    case VIDE:
                        System.out.print(" ");
                        break;
                    case SOLEIL:
                        System.out.print("#");
                        break;
                    case LUNE:
                        System.out.print("C");
                        break;
                    case ETOILE:
                        System.out.print("*");
                        break;
                    case SABLIER:
                        System.out.print("X");
                        break;
                    case BOUCLIER:
                        System.out.print("B");
                        break;
                    case OBSTACLE:
                        System.out.print("!");
                        break;
                    default:
                        System.out.print(" ");
                        break;
                }
                System.out.print("|");
            }
            System.out.println("");
        }
    }
}
