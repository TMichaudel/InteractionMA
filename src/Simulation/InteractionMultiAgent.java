/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Simulation;

import Modele.Grille;
import Modele.SymboleAgent;
import Modele.Symboles;
import static java.lang.Thread.sleep;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author thiba
 */
public class InteractionMultiAgent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Grille grille = new Grille();
        SymboleAgent soleil = new SymboleAgent(0,3,0,1,grille,Symboles.SOLEIL);
        SymboleAgent sablier = new SymboleAgent(1,2,4,4,grille,Symboles.SABLIER);
        //SymboleAgent bouclier = new SymboleAgent(0, 2, 0,2,grille,Symboles.BOUCLIER);
        SymboleAgent etoile = new SymboleAgent(2,3,3,0,grille,Symboles.ETOILE);
        grille.affichage();
        System.out.println("Début execution");
        ExecutorService executor = Executors.newCachedThreadPool();
        //TODO Remplacer sleep par un truc mieux
        executor.execute(soleil);
        sleep(100);
        executor.execute(sablier);
        sleep(100);
        executor.execute(etoile);
        sleep(100);
        //executor.execute(bouclier);


    }
    
}
