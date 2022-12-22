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
@Table(name = "FURNITURASCLADOFF")
public class FurnituraScladOff implements Serializable {
    @Id
    @Column(name = "FURNITURASCLADOFF")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_FURNITURASCLADOFF_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_FURNITURASCLADOFF_ID", sequenceName = "GEN_FURNITURASCLADOFF_ID")
    Integer furniturascladoff;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "TEXTS")
    String texts;  

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

    public FurnituraScladOff(Integer f) {
        furniturascladoff = f;
    }

    public FurnituraScladOff() {
    }

    public Integer getFurniturascladoff() {
        return furniturascladoff;
    }

    public void setFurniturascladoff(Integer furniturascladoff) {
        this.furniturascladoff = furniturascladoff;
    }

    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
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
