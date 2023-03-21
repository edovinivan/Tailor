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
@Table(name = "SCLADLOSKUTSALE")
public class ScladLoskutSale implements Serializable {
    @Id
    @Column(name = "SCLADLOSKUTSALE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SCLADLOSKUTSALE_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_SCLADLOSKUTSALE_ID", sequenceName = "GEN_SCLADLOSKUTSALE_ID")
    Integer scladloskutsale;
    
    @ManyToOne
    @JoinColumn(name = "SCLADLOSKUT")
    ScladLoskut scladloskut;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "TEXTS")
    String texts;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date dates;
    
    @ManyToOne
    @JoinColumn(name = "SCLADLOSKUTSALEOP")
    ScladLoskutSaleOp scladloskutsaleop;

    public ScladLoskutSaleOp getScladloskutsaleop() {
        return scladloskutsaleop;
    }

    public void setScladloskutsaleop(ScladLoskutSaleOp scladloskutsaleop) {
        this.scladloskutsaleop = scladloskutsaleop;
    }
    
    

    public ScladLoskutSale(Integer s) {
        scladloskutsale = s;
    }

    public ScladLoskutSale() {
    }

    public Integer getScladloskutsale() {
        return scladloskutsale;
    }

    public void setScladloskutsale(Integer scladloskutsale) {
        this.scladloskutsale = scladloskutsale;
    }

    public ScladLoskut getScladloskut() {
        return scladloskut;
    }

    public void setScladloskut(ScladLoskut scladloskut) {
        this.scladloskut = scladloskut;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    
    
    
    
}
