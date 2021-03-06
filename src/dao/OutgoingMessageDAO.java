/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class OutgoingMessageDAO {
    
    private Connection cn = null;
    private ResultSet rs = null;
    private static OutgoingMessageDAO instancia;
    
    static Logger logger = Logger.getLogger((Class)OutgoingMessageDAO.class);
    
    public static OutgoingMessageDAO getInstance(){
        if (instancia == null){
            instancia = new OutgoingMessageDAO();
        }
        
        return instancia;
    }
    
    public int clean() throws SQLException{
        int eliminado = 0;
        cn = Conexion.getInstancia().miConexion();
        Statement st = null;             
        String sqlString="delete from usrsms.outgoing_message "
                + "where date_trunc('day', fecha) <= CURRENT_DATE - 2"
                + " and UPPER(tipo) <> 'CMACSULLANA'";
        
        try{                                    
            st = cn.createStatement();
            if(st.execute(sqlString)){
                eliminado = 1;
            }
            
            logger.info((Object)(" Limpiando outgoing messages "));
            
        }catch(SQLException ex) {
            logger.info((Object)("Error al eliminar outgoingMessage: " + ex.getMessage()));
        } finally {
            cn.close();
            if(st != null){
                st.close();
            }            
        }        
        return eliminado;
    }
    
    public void executeVacuumOutgoingMessage() throws SQLException {
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String query = "VACUUM FULL usrsms.outgoing_message";
        
        try {
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            logger.info((Object)"Ejecuto Vaccum:");
        } catch (SQLException ex) {
            logger.info((Object)"ERROR VACUUM: "+ ex.getMessage());
        } finally {
            cn.close();
            if (ps != null) {
                ps.close();
            }
        }
        
    }
    public void executeVacuumMessages() throws SQLException {
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String query = "VACUUM FULL usrsms.messages";
        
        try {
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            logger.info((Object)"Ejecuto Vaccum:");
        } catch (SQLException ex) {
            logger.info((Object)"ERROR VACUUM: "+ ex.getMessage());
        } finally {
            cn.close();
            if (ps != null) {
                ps.close();
            }
        }
        
    }
    public void executeVacuumIncomingMessage() throws SQLException {
        cn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        String query = "VACUUM FULL usrsms.incoming_message";
        
        try {
            ps = cn.prepareStatement(query);
            ps.executeUpdate();
            logger.info((Object)"Ejecuto Vaccum:");
        } catch (SQLException ex) {
            logger.info((Object)"ERROR VACUUM: "+ ex.getMessage());
        } finally {
            cn.close();
            if (ps != null) {
                ps.close();
            }
        }
        
    }
}
