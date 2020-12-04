/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cards_information_extractor;

import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author ALKODS
 */
public interface GeneralInfoExtractor {
    
    //Abstract Methods
    public void extractCardPassword() throws SQLException;
    
    public void extractCVV() throws SQLException;
    
    public void extractCardExpireDate() throws SQLException;
    
    public void extractDepositAmount() throws SQLException;
    
}
