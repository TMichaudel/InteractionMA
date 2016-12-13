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
    private MessageTypes type;
    private MessageTypes reponse;
    private Symboles emetteur;
    private Symboles recepteur;
    private int libX;
    private int libY;
    private int id;
    private Date date;

    public Message(MessageTypes type, Symboles emetteur, Symboles recepteur, int libX, int libY, int id) {
        this.reponse = MessageTypes.NOTANSWERED;
        this.type = type;
        this.emetteur = emetteur;
        this.recepteur = recepteur;
        this.libX = libX;
        this.libY = libY;
        this.id = id;
        this.date = new Date();
    }

    public MessageTypes getType() {
        return type;
    }

    public Symboles getEmetteur() {
        return emetteur;
    }

    public Symboles getRecepteur() {
        return recepteur;
    }

    public int getLibX() {
        return libX;
    }

    public int getLibY() {
        return libY;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }
    
    
    
}
