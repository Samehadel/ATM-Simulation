/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package money_operations_package;

import bank_cards.Card;
import bank_clients.AccountHolder;
import java.sql.SQLException;

/**
 *
 * @author ALKODS
 */
public abstract class MoneyOperations {
    public abstract void withdraw(Card card, double amount) throws SQLException; 
    
    public abstract void deposit(Card card, double amount) throws SQLException;      
    
    public abstract void transfer(Card source, AccountHolder destination, double amount) throws SQLException;
}
