/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Modele.Grille;
import Modele.SymboleAgent;
import Modele.Symboles;

/**
 *
 * @author thiba
 */
public class InteractionMultiAgent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grille grille = new Grille();
        SymboleAgent soleil = new SymboleAgent(0,3,0,1,grille,Symboles.SOLEIL);
        SymboleAgent sablier = new SymboleAgent(1,2,4,4,grille,Symboles.SABLIER);
        SymboleAgent etoile = new SymboleAgent(2,3,3,0,grille,Symboles.ETOILE);
        soleil.run();
        sablier.run();
        etoile.run();
        grille.affichage();
    }
    
}
