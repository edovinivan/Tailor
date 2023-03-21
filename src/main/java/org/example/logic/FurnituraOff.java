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
@Table(name = "FURNITURAOFF")
public class FurnituraOff implements Serializable {
    @Id
    @Column(name = "FURNITURAOFF")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_FURNITURAOFF_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_FURNITURAOFF_ID", sequenceName = "GEN_FURNITURAOFF_ID")
    Integer furnituraoff;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCTF")
    ScladProductF scladproductf;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "TEXTS")
    String texts;

    public FurnituraOff(Integer f) {
        furnituraoff = f;
    }

    public FurnituraOff() {
    }

    public Integer getFurnituraoff() {
        return furnituraoff;
    }

    public void setFurnituraoff(Integer furnituraoff) {
        this.furnituraoff = furnituraoff;
    }

    public ScladProductF getScladproductf() {
        return scladproductf;
    }

    public void setScladproductf(ScladProductF scladproductf) {
        this.scladproductf = scladproductf;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }
    
    
    
    
    
    
    
    
}
