/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_cards;

import cards_information_extractor_package.DebitInformationExtractor;
import java.sql.SQLException;
import money_operations_package.DebitCardOperations;
import money_operations_package.MoneyOperations;

/**
 *
 * @author ALKODS
 */
public class DebitCard extends Card{
    
    //Associated Bank account with this card
    private String associatedAccountNum;
    private DebitInformationExtractor extractor;
    
    public DebitCard(String cardNumber) throws SQLException {
        super(cardNumber);
        
        //Initialize Extractor Class
        extractor = new DebitInformationExtractor(this);
        
        //Call Extractor Methods
        extractInfor();
    }

    private void extractInfor() throws SQLException{
        extractor.extractCardPassword();
        extractor.extractCVV();
        extractor.extractCardExpireDate();
        extractor.extractAssociatedAccount();
        extractor.extractDepositAmount();
    }
    
    
    public String getAssociatedAccountNum() {
        return associatedAccountNum;
    }

    public void setAssociatedAccountNum(String associatedAccountNum) {
        this.associatedAccountNum = associatedAccountNum;
    }

    @Override
    public MoneyOperations getOperationInstance() {
        return new DebitCardOperations();
    }
}
