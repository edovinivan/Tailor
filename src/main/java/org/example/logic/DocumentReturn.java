/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "DOCUMENTRETURN")
public class DocumentReturn implements Serializable {
    @Id
    @Column(name = "DOCUMENTRETURN")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOCUMENTRETURN_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOCUMENTRETURN_ID", sequenceName = "GEN_DOCUMENTRETURN_ID")
    Integer documentreturn;
    
    @Column(name = "TEXT")
    String text;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @ManyToOne
    @JoinColumn(name = "AGENT")
    Agent agent;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;

    public DocumentReturn(Integer dr) {
        documentreturn = dr;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    
    
    public DocumentReturn() {
    }

    public Integer getDocumentreturn() {
        return documentreturn;
    }

    public void setDocumentreturn(Integer documentreturn) {
        this.documentreturn = documentreturn;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
    }
    
    
    
    
    
    
}
