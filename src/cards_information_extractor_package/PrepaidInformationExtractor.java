/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards_information_extractor_package;

import bank_cards.PrepaidCard;
import database_related_package.OperationsDAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ALKODS
 */
public class PrepaidInformationExtractor implements GeneralInfoExtractor{

    private PrepaidCard card;
    private OperationsDAO dao;
    
    //Cons
    public PrepaidInformationExtractor(PrepaidCard card) {
        this.card = card;
        dao = OperationsDAO.getInstance();
    }
    
    @Override
    public void extractCardPassword() throws SQLException {

        //Prepare SQL Query To Get Actual Password
        String query = "SELECT * FROM prepaid_cards WHERE card_number = '" + card.getCardNumber() + "'";

        //Excute The Query
        ResultSet result = dao.excuteOperationQuery(query);
        result.next();
        
        short password = result.getShort("card_password");
        
        //Close Connection To Database
        dao.close();;
        
        //Set Card Paasword
        card.setCardPassword(password);
    }

    @Override
    public void extractCVV() throws SQLException {

        //Prepare SQL Query To Get Actual Password
        String query = "SELECT * FROM prepaid_cards WHERE card_number = '" + card.getCardNumber() + "'";

        //Excute The Query
        ResultSet result = dao.excuteOperationQuery(query);
        result.next();
        
        short cvv = result.getShort("cvv");
        
        //Close Connection To Database
        dao.close();;
        
        //Set Card CVV
        card.setCVV(cvv);    
    }

    @Override
    public void extractCardExpireDate() throws SQLException {
        //Prepare SQL Query To Get Actual Password
        String query = "SELECT * FROM prepaid_cards WHERE card_number = '" + card.getCardNumber() + "'";

        //Excute The Query
        ResultSet result = dao.excuteOperationQuery(query);
        result.next();
        
        Date expireDate = result.getDate("expire_date");
        
        //Close Connection To Database
        dao.close();;
        
        //Set Card Expire Date
        card.setCardExpireDate(expireDate); 
    }

    @Override
    public void extractDepositAmount() throws SQLException {
        //Prepare SQL Query To Get Actual Password
        String query = "SELECT * FROM prepaid_cards WHERE card_number = '" + card.getCardNumber() + "'";

        //Excute The Query
        ResultSet result = dao.excuteOperationQuery(query);
        result.next();
        
        double depositAmount = result.getDouble("deposit_amount");
        
        //Close Connection To Database
        dao.close();;
        
        //Set Card Deposit Amount
        card.setDepositAmount(depositAmount); 
    }
    
}
