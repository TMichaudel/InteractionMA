/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
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
        	//consulter retour des messages envoyés
        	ArrayList<Message> messagesRep = grille.getReponses(symbole);
        	boolean estDeplace = false;
        	if(!messagesRep.isEmpty()){
        		for(int i = 0;i<messagesRep.size();i++){
        			Message m = messagesRep.get(i);
        			if(m.getReponse()!=MessageTypes.NOTANSWERED) System.out.println(symbole+" a la réponse d'un message "+m.getReponse().name());
        			if(m.getReponse() == MessageTypes.NON){
        				m.setReponse(MessageTypes.TRAITE);
        			}
        			else if (m.getReponse() == MessageTypes.OUI){
        				if(grille.getCase(m.getLibX(), m.getLibX()).equals(Symboles.VIDE) && !estDeplace){
        					grille.setCaseVide(posX, posY);
        					posX=m.getLibX(); posY=m.getLibY();
        	                grille.setCase(posX, posY, this);
        	                System.out.println("Après avoir demandé, Symbole "+symbole.name()+" s'est déplacé en "+posX+","+posY);
        				}
        				m.setReponse(MessageTypes.TRAITE);
        				estDeplace=true;
        			}
        		}
        	}
        	//se déplacer
            if(!estDeplace){
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
            } 
            
            else {
            	//demander aux agents de se décaler
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
        }

            grille.affichage();
            if ((posX == posFinaleX) && (posY == posFinaleY)) {
            	if(!isSatisfied) System.out.println("Symbole "+this.getSymbole().name()+" a atteint sa position finale");
                isSatisfied = true;
            }
            grille.checkVictory();
            //Regarder messages reçus
            	ArrayList<Message> messages = grille.getMessages(symbole);
            	if(!messages.isEmpty()){
            		for(int i = 0;i<messages.size();i++){
            			Message m =messages.get(i);
            			System.out.println(symbole+" a reçu un message de la part de "+m.getEmetteur().name());
                        if(isSatisfied && m.getType()==MessageTypes.DEPLACEMENT){	
            				if(m.getLibX()==posX && m.getLibY()==posY){
	            				//Si déplacement demandé
	            				if ((grille.getCase(posX + 1, posY).equals(Symboles.VIDE))) {
	            	                posX++;
	            	                grille.setCase(posX, posY, this);
	            	                grille.setCaseVide(posX - 1, posY);
	            	                m.setReponse(MessageTypes.OUI); System.out.println("Symbole "+symbole.name()+" s'est décalé du "+m.getLibX()+","+m.getLibY());
	            	            } else if ((grille.getCase(posX - 1, posY).equals(Symboles.VIDE))) {
	            	                posX--;
	            	                grille.setCase(posX, posY, this);
	            	                grille.setCaseVide(posX + 1, posY);
	            	                m.setReponse(MessageTypes.OUI); System.out.println("Symbole "+symbole.name()+" s'est décalé du "+m.getLibX()+","+m.getLibY());
	            	            } else if ((grille.getCase(posX, posY + 1).equals(Symboles.VIDE))) {
	            	                posY++;
	            	                grille.setCase(posX, posY, this);
	            	                grille.setCaseVide(posX, posY - 1);
	            	                m.setReponse(MessageTypes.OUI); System.out.println("Symbole "+symbole.name()+" s'est décalé du "+m.getLibX()+","+m.getLibY());
	            	            } else if ((grille.getCase(posX, posY - 1).equals(Symboles.VIDE))) {
	            	                posY--;
	            	                grille.setCase(posX, posY, this);
	            	                grille.setCaseVide(posX, posY + 1);
	            	                m.setReponse(MessageTypes.OUI); System.out.println("Symbole "+symbole.name()+" s'est décalé du "+m.getLibX()+","+m.getLibY());
	            	            } else {
	            	            	System.out.println("Déplacement impossible");
	            	            	m.setReponse(MessageTypes.NON);
	            	            }
            				}
            				else{
            					System.out.println("Symbole "+symbole.name()+" était déjà décalé");
            					m.setReponse(MessageTypes.OUI);
            				}
            		}
                        else{
                        	m.setReponse(MessageTypes.NON);
                        }
            	}
            }
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
