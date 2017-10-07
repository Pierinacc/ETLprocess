/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.IncomingMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public ArrayList<IncomingMessage> getIncomingMessage(){
        cn = Conexion.getInstancia().miConexion();
        ArrayList list = new ArrayList<IncomingMessage>();
        PreparedStatement ps = null;
        try{
            String query = "select * from usrsms.migrate_incoming_message";
            
            ps = cn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                IncomingMessage incomingMessage = new IncomingMessage(                        
                        rs.getInt("client_id"),
                        rs.getString("username"),
                        rs.getDate("received_date"),
                        rs.getInt("total"),
                        rs.getInt("positivos")
                );
                
                list.add(incomingMessage);
            }
            
        }catch(Exception e){
            
        } finally {
            cn.close();
            if(ps != null){
                ps.close();
            }            
        }     
            
        return list;
    }
}
