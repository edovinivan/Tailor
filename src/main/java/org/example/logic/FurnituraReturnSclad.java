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
@Table(name = "FURNITURARETURNSCLAD")
public class FurnituraReturnSclad implements Serializable {
    @Id
    @Column(name = "FURNITURARETURNSCLAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_FURNITURARETURNSCLAD_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_FURNITURARETURNSCLAD_ID", sequenceName = "GEN_FURNITURARETURNSCLAD_ID")
    Integer furniturareturnsclad;
    
    @ManyToOne
    @JoinColumn(name = "CHEX")   
    RabotnikGruppa chex;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")   
    ScladProduct scladproduct;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCTF")   
    ScladProductF scladproductf;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "TEXTS")    
    String texts;

    public FurnituraReturnSclad(Integer f) {
        furniturareturnsclad = f;
    }

    public FurnituraReturnSclad() {
    }

    public Integer getFurniturareturnsclad() {
        return furniturareturnsclad;
    }

    public void setFurniturareturnsclad(Integer furniturareturnsclad) {
        this.furniturareturnsclad = furniturareturnsclad;
    }

    public RabotnikGruppa getChex() {
        return chex;
    }

    public void setChex(RabotnikGruppa chex) {
        this.chex = chex;
    }

    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }
    
    
    
    
    
}
