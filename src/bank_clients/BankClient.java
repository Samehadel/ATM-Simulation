/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_clients;

import bank_cards.Card;
import java.sql.Date;

/**
 *
 * @author ALKODS
 */
public class BankClient {

    private Date birthDate; 
    private String name;
    private long nationalId;
    private Card clientCard;
    
    //Getters
    public Date getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public long getNationalId() {
        return nationalId;
    }

    public Card getClientCard() {
        return clientCard;
    }

        
    //Setters
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationalId(long nationalId) {
        this.nationalId = nationalId;
    }    
    
    public void SetClientCard(Card cleintCard) {
        this.clientCard = clientCard;
    }    
        
}
