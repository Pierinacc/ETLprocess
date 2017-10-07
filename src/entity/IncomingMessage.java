/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author DELL
 */
public class IncomingMessage {

    private int id;
    private int enterpriseId;
    private String corporateId;
    private Date receivedDate;
    private int total;
    private int positive;

    public IncomingMessage(int enterpriseId, String corporateId, Date receivedDate, int total, int positive) {
        this.enterpriseId = enterpriseId;
        this.corporateId = corporateId;
        this.receivedDate = receivedDate;
        this.total = total;
        this.positive = positive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }
    
    
    
}
