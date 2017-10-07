/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etlprocess;

import dao.OutgoingMessageDAO;
import java.sql.SQLException;
/**
 *
 * @author DELL
 */
public class ETLprocess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        OutgoingMessageDAO.getInstance().clean();
    }
    
}
