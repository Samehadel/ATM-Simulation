/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package money_operations_package;

import bank_cards.Card;
import bank_clients.AccountHolder;
import database_dao.OperationsDAO;
import java.sql.SQLException;
import machine_releated_package.MachineOperations;

/**
 *
 * @author ALKODS
 */
public class PrepaidCardOperations extends MoneyOperations{
    OperationsDAO dao;     

    //Cons
    public PrepaidCardOperations() {
        this.dao = OperationsDAO.getInstance();
    }
    
    @Override
    public void withdraw(Card card, double amount) throws SQLException {
        
        double availableMoney = card.getDepositAmount();
        
        System.out.println("Avilable Money: " + availableMoney);
        
        if(availableMoney >= amount){
            //Apply changes to Database
            
            String query = "UPDATE prepaid_cards SET deposit_amount = deposit_amount - " + amount + " WHERE card_number = '" + card.getCardNumber() + "'";
            
            //Excute Update Query
            dao.excuteOperationUpdate(query);
            
            //Invoke Machine-related Code
            MachineOperations.releaseMoney(amount);
        }else{
            //Operation Failed
            System.out.println("Available Money Not Enough...");
        }
    }

    @Override
    public void deposit(Card card, double amount) throws SQLException {
        //Prepare SQL for Excution   
        String query = "UPDATE prepaid_cards SET deposit_amount = deposit_amount + " + amount + " WHERE card_number = '" + card.getCardNumber() + "'";
        
        //Excute Query
        dao.excuteOperationUpdate(query);
        
        //Informing User...
        System.out.println("Deposit Of: " + amount + "$ Done Successfully...");
    }

    @Override
    public void transfer(Card source, AccountHolder destination, double amount) throws SQLException {
        double availableMoney = source.getDepositAmount();
        String query1, query2;
        
        
        if(amount <= availableMoney){
            //Prepare Queries For Excution
            query1 = "UPDATE prepaid_cards SET deposit_amount = deposit_amount - " + amount + " WHERE card_number = '" + source.getCardNumber() + "'";
            query2 = "UPDATE account_holders SET deposit_amount = deposit_amount + " + amount + " WHERE account_number = '" + destination.getAccountNumber() + "'";
            
            //Query Excution            
            dao.excuteOperationUpdate(query1, query2);  
            
            //Informing User...
            System.out.println("Transfer Done Sucessfully...");
        }else
            System.out.println("Available Money Not Enough...");
    }
    
}
