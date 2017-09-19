/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Timestamp;

/**
 *
 * @author DELL
 */
public class OutgoingMessage {
    
    private int id;
    private String txt;
    private String tipo;
    private Timestamp fecha;
    private String msisdn;
    private int Estado;
    private Timestamp fechaEnvio;
    private int campaignId;
    private String tipoAux;
    private String balanceAux;

    public OutgoingMessage(int id, String txt, String tipo, Timestamp fecha, String msisdn, int Estado, int campaignId) {
        this.id = id;
        this.txt = txt;
        this.tipo = tipo;
        this.fecha = fecha;
        this.msisdn = msisdn;
        this.Estado = Estado;
        this.campaignId = campaignId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }

    public Timestamp getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Timestamp fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getTipoAux() {
        return tipoAux;
    }

    public void setTipoAux(String tipoAux) {
        this.tipoAux = tipoAux;
    }

    public String getBalanceAux() {
        return balanceAux;
    }

    public void setBalanceAux(String balanceAux) {
        this.balanceAux = balanceAux;
    }
    
    
}
