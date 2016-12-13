/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.Date;

/**
 *
 * @author thiba
 */
public class Message {
    MessageTypes type;
    Symboles emetteur;
    Symboles recepteur;
    int libX;
    int libY;
    int id;
    Date date;

    public Message(MessageTypes type, Symboles emetteur, Symboles recepteur, int libX, int libY, int id) {
        this.type = type;
        this.emetteur = emetteur;
        this.recepteur = recepteur;
        this.libX = libX;
        this.libY = libY;
        this.id = id;
        this.date = new Date();
    }
    
    
}
