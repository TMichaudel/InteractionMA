/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author thiba
 */
public class SymboleAgent extends Thread{
    private int posX;
    private int posY;
    private int posFinaleX;
    private int posFinaleY;
    private Grille grille;
    private Symboles symbole;
    private boolean isSatisfied;

    public SymboleAgent(int posX, int posY, int posFinaleX, int posFinaleY, Grille grille, Symboles symbole) {
        this.isSatisfied=false;
        this.posX = posX;
        this.posY = posY;
        this.posFinaleX = posFinaleX;
        this.posFinaleY = posFinaleY;
        this.grille = grille;
        this.symbole = symbole;
        grille.setCase(posX, posY, this);
    }
    
    @Override
    public void run(){
        while(!grille.isComplete){
            System.out.println(grille.getCase(posX+1, posY));
            if((posX<posFinaleX)&&(grille.getCase(posX+1, posY).equals(Symboles.VIDE))) {
                posX++;
                grille.setCase(posX, posY, this);
                grille.setCaseVide(posX-1, posY);
            }
            else if((posX>posFinaleX)&&(grille.getCase(posX-1, posY).equals(Symboles.VIDE))) {
                posX--;
                grille.setCase(posX, posY, this);
                grille.setCaseVide(posX+1, posY);
            }
            else if((posY<posFinaleY)&&(grille.getCase(posX, posY+1).equals(Symboles.VIDE))) {
                posY++;
                grille.setCase(posX, posY, this);
                grille.setCaseVide(posX, posY-1);
            }
            else if((posY>posFinaleY)&&(grille.getCase(posX, posY-1).equals(Symboles.VIDE))) {
                posY++;
                grille.setCase(posX, posY, this);
                grille.setCaseVide(posX, posY+1);
            }
            else {
                System.out.println("aa");
                System.out.println(grille.getCase(posX+1, posY));
                System.out.println(grille.getCase(posX+1, posY).equals(Symboles.VIDE));
            }
            
            grille.affichage();
            if((posX==posFinaleX)&&(posY==posFinaleY)){
                isSatisfied=true;
            }
        }
    }

    public Symboles getSymbole() {
        return symbole;
    }
    
    

}
