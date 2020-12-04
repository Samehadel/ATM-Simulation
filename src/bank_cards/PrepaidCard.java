/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank_cards;

import cards_information_extractor.PrepaidInformationExtractor;
import java.sql.SQLException;
import money_operations_package.MoneyOperations;
import money_operations_package.PrepaidCardOperations;

/**
 *
 * @author ALKODS
 */
public class PrepaidCard extends Card{

    private PrepaidInformationExtractor extractor;

    public PrepaidCard(String cardNumber) throws SQLException {
        super(cardNumber);
        
        //Initialize Extractor Class
        extractor = new PrepaidInformationExtractor(this);
        
        //Call Extractor Methods
        extractInfor();
    }

    
    private void extractInfor() throws SQLException {
        extractor.extractCardPassword();
        extractor.extractCVV();
        extractor.extractCardExpireDate();
        extractor.extractDepositAmount();
    }

    @Override
    public MoneyOperations getOperationInstance() {
        return new PrepaidCardOperations();
    }
}
