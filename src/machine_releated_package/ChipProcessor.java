/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine_releated_package;

import money_operations_package.MoneyOperations;
import bank_cards.Card;
import bank_cards.DebitCard;
import bank_cards.PrepaidCard;
import bank_clients.AccountHolder;
import java.sql.SQLException;
import java.util.Scanner;
import main_package.Main;

/**
 *
 * @author ALKODS
 */
public class ChipProcessor {
    
    private String cardNum;
    private short password; 
    private Card card;
    private boolean run = true;
    private Scanner scanner;
    
    public ChipProcessor(String cardNum, short password) {
        this.cardNum = cardNum;
        this.password = password;
        
        //Initialize scnner object
        this.scanner = new Scanner(System.in);        
    }
    
    
    public void startProcess() throws SQLException{
        checkChipInfo();
        applyProcess();
    }
    
    private void checkChipInfo() throws SQLException{
        card = extractCardType();
        
        if(card.getCardPassword() != password){
            Main.run = true;
            this.run = false;
            System.out.println("Wrong Password");
        }
    }
    
    private Card extractCardType() throws SQLException{
        String debitStart = "4500";
        String prepaidStart = "3200";
        
        //Extract firts 4 digits from card Number
        String compareTo = cardNum.substring(0, 4);

        if(compareTo.equals(debitStart))
            return new DebitCard(cardNum);
        else if(compareTo.equals(prepaidStart))
            return new PrepaidCard(cardNum);
        else
            return null;
    }

    private void applyProcess() throws SQLException {
        MoneyOperations operationsObj = card.getOperationInstance();
        
        if(run){
            System.out.println("Press W for withdraw, Press D for deposit or Press T for transfer");
            String c = scanner.next().toLowerCase();
            
            while(!c.equals("t") && !c.equals("w") && !c.equals("d")){
                System.out.println("Worng char...");
                c = scanner.next().toLowerCase();
            }
            switch(c){
                case "w":{
                    //Displaying...
                    System.out.println("Enter Withdrawn amount...");
                    
                    //User Response...
                    double amount = scanner.nextDouble();
                    
                    //Invoke Withdraw Method
                    operationsObj.withdraw(card, amount);
                    
                    break;
                }
                case "d":{
                    //Displaying...
                    System.out.println("Please, put the money on machine...");
                    
                    //Machine Response...
                    double amount = MachineOperations.readDepositAmount();
                    
                    operationsObj.deposit(card, amount);
                    
                    break;
                }
                case "t":{
                    //Displaying...
                    System.out.println("Enter the amount to be transfered..");
                    
                    //User Response...
                    double amount = scanner.nextDouble();
                    
                    //Displaying...
                    System.out.println("Enter account number...");     
                    
                    //User Response...
                    String accountNumber = scanner.next();
                    
                    //Create AccountHolder object
                    AccountHolder destination = new AccountHolder(accountNumber);
                    
                    operationsObj.transfer(card, destination, amount);
                    
                    break;
                }
            }
        }
    }   
}
