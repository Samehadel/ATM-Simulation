/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_cards;

import java.sql.Date;
import money_operations_package.MoneyOperations;

/**
 *
 * @author ALKODS
 */
public abstract class Card {
    
    private short cardPassword; 
    private String cardNumber;
    private short CVV;
    private Date cardExpireDate; 
    private double depositAmount; 
    
    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    //Abastract Methds
    public abstract MoneyOperations getOperationInstance();
    

    //Getters
    public short getCardPassword() {
        return cardPassword;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public short getCVV() {
        return CVV;
    }

    public Date getCardExpireDate() {
        return cardExpireDate;
    }

    public double getDepositAmount() {
        return depositAmount;
    }
    
    
    //Setter
    public void setCardPassword(short cardPassword) {
        this.cardPassword = cardPassword;
    }
    
    public void setCVV(short CVV) {
        this.CVV = CVV;
    }

    public void setCardExpireDate(Date cardExpireDate) {
        this.cardExpireDate = cardExpireDate;
    }
    
    public void setDepositAmount(double depositAmount) {    
        this.depositAmount = depositAmount;
    }

}
