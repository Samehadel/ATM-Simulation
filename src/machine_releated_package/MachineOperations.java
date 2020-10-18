/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package machine_releated_package;

/**
 *
 * @author ALKODS
 */
public class MachineOperations {

    public static double readDepositAmount() {
        double num = Math.floor(Math.random() * 1000);
        
        while(!(num % 10 == 0))
            num--;
        
        return num;    
    }
    
    public static void releaseMoney(double amount){
        System.out.println("Releasing " + amount + "$... Please Wait While Processing...");
    }
    
    public static String readChipNumber(){
        return "4500522614241287";
    }
    
}
