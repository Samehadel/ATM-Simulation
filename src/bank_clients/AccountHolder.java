/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_clients;

/**
 *
 * @author ALKODS
 */
public class AccountHolder extends BankClient{
    private String accountNumber;
    private double depositAmount;

    //Cons
    public AccountHolder(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    
    //Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    //Setters
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }
    
    
}
