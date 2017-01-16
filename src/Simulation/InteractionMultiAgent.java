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
        //4 agents avec un obstacle sur le chemin du symbole Soleil (#)
        /*Grille grille = new Grille(); 
        SymboleAgent soleil = new SymboleAgent(0,3,0,1,grille,Symboles.SOLEIL); //#
        SymboleAgent sablier = new SymboleAgent(1,2,4,4,grille,Symboles.SABLIER);   //X
        SymboleAgent bouclier = new SymboleAgent(0, 2, 0,2,grille,Symboles.BOUCLIER);   //B
        SymboleAgent etoile = new SymboleAgent(2,3,3,0,grille,Symboles.ETOILE); //*
        grille.affichage();
        System.out.println("Debut execution");
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(soleil);
        sleep(100);
        executor.execute(sablier);
        sleep(100);
        executor.execute(etoile);
        sleep(100);
        executor.execute(bouclier);
        sleep(100);*/
        
        //7 agents allant dans multiples positions
        /*Grille grille = new Grille();
        SymboleAgent soleil = new SymboleAgent(0,3,0,1,grille,Symboles.SOLEIL); //#
        SymboleAgent sablier = new SymboleAgent(1,2,4,4,grille,Symboles.SABLIER);   //X
        SymboleAgent bouclier = new SymboleAgent(0, 2, 0,2,grille,Symboles.BOUCLIER);   //B
        SymboleAgent etoile = new SymboleAgent(2,3,3,0,grille,Symboles.ETOILE); //*
        SymboleAgent roue = new SymboleAgent(4,2,1,2,grille,Symboles.ROUE); //O
        SymboleAgent mail = new SymboleAgent(3,4,1,0,grille,Symboles.MAIL); //@
        SymboleAgent vague  = new SymboleAgent(1,4,0,3,grille,Symboles.VAGUE);  //~


        grille.affichage();
        System.out.println("Debut execution");
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(soleil);
        sleep(100);
        executor.execute(sablier);
        sleep(100);
        executor.execute(etoile);
        sleep(100);
        executor.execute(bouclier);
        sleep(100);
        executor.execute(roue);
        sleep(100);
        executor.execute(mail);
        sleep(100);
        executor.execute(vague);
        sleep(100);*/
        
        //7 agents. Le Symbole Vague ~ demande au bouclier B de se décaler, ce qui n'est pas possible
        //Il va alors se déplacer pour demander à un autre (le symbole Rond O) de se décaler.
        Grille grille = new Grille();
        SymboleAgent soleil = new SymboleAgent(0,3,0,1,grille,Symboles.SOLEIL); //#
        SymboleAgent sablier = new SymboleAgent(1,2,4,4,grille,Symboles.SABLIER);   //X
        SymboleAgent bouclier = new SymboleAgent(0, 2, 0,2,grille,Symboles.BOUCLIER);   //B
        SymboleAgent etoile = new SymboleAgent(2,3,3,0,grille,Symboles.ETOILE); //*
        SymboleAgent roue = new SymboleAgent(4,2,1,2,grille,Symboles.ROUE); //O
        SymboleAgent mail = new SymboleAgent(3,4,2,0,grille,Symboles.MAIL); //@
        SymboleAgent vague  = new SymboleAgent(0,4,0,0,grille,Symboles.VAGUE);  //~


        grille.affichage();
        System.out.println("Debut execution");
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(soleil);
        sleep(100);
        executor.execute(sablier);
        sleep(100);
        executor.execute(etoile);
        sleep(100);
        executor.execute(bouclier);
        sleep(100);
        executor.execute(roue);
        sleep(100);
        executor.execute(mail);
        sleep(100);
        executor.execute(vague);
        sleep(100);
    }
    
}
