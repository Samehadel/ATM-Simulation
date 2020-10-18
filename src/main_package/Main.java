/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_package;

import machine_releated_package.ChipProcessor;
import bank_cards.Card;
import java.sql.SQLException;
import java.util.Scanner; 
import machine_releated_package.MachineOperations;
/**
 *
 * @author ALKODS
 */
public class Main {
    
    //This value can be changed by ChipProcessor Class - > checkChipInfo()
    public static boolean run = true;
    
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        
        while(run){
            run = false;
          
            System.out.println("Enter Password...");
            
            //cardNumber return by a machineOperation
            String cardNumber = MachineOperations.readChipNumber();
            
            //User Enter Password
            short password = scanner.nextShort(); 
        
            
            ChipProcessor processor = new ChipProcessor(cardNumber, password);
        
            //Walks user through the processes
            processor.startProcess();
        }
        
    }
    
}
