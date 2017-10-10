/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.OutgoingMessageDAO.logger;
import entity.IncomingMessage;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class IncomingMessageDAO {
    
    private Connection cn = null;
    private ResultSet rs = null;
    private static IncomingMessageDAO instance ;
    
    public static IncomingMessageDAO getInstance(){
        if( instance == null){
            instance = new IncomingMessageDAO();
        }
        
        return instance;
    }
    
    public void getIncomingMessage() throws SQLException{
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            String query = "select * from usrsms.migrate_incoming_message";
            
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int client_id = rs.getInt("client_id");
                String username = rs.getString("username");
                Date receivedDate = rs.getDate("received_date");
                int total = rs.getInt("total");
                int positivos = rs.getInt("positivos");
                logger.info((Object)(" lee: "+ username+ " total de: "+ total));
                insertIncomingMessage(client_id, username, receivedDate, total, positivos);
            }
            
        }catch(Exception e){
            logger.info((Object)(" Limpiando outgoing messages "));
        } finally {
            cn.close();
            if(ps != null){
                ps.close();
            }            
        }     

    }
    
    public void insertIncomingMessage(int client_id, String username, Date receivedDate, int total, int positivos) 
            throws SQLException{
        Connection cn2 = Conexion.getInstancia().miConexion2();
        PreparedStatement ps = null;
        try{
            String query = "insert into incoming_message(enterprise_id,corporate_id,"
                    + "received_date,total,positive) values(?,?,?,?,?)";
            
            ps = cn2.prepareStatement(query);
            ps.setInt(1, client_id);
            ps.setString(2, username);
            ps.setDate(3, receivedDate);
            ps.setInt(4,total);
            ps.setInt(5,positivos);
        
            ps.executeUpdate();
            logger.info((Object)(" inserta: "+ username+ " total de: "+ total));
        }catch(Exception ex){
            logger.info((Object)(" Error: "+ ex.getMessage()));
        }finally{
            if(cn2 != null){
                cn2.close();
            }            
            if(ps != null){
                ps.close();
            }
        }
    }
}
