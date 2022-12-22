/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ZADACHAFURNITURA")
public class ZadachaFurnitura implements Serializable {
    @Id
    @Column(name = "ZADACHAFURNITURA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHAFURNITURA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHAFURNITURA_ID", sequenceName = "GEN_ZADACHAFURNITURA_ID")
    Integer zadachafurnitura;
    
    @Column(name = "ZADACHA")
    Integer zadacha;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHAPRODUCT")
    ZadachaProduct zadachaproduct;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHAKOMPLEKTOVKA")
    ZadachaKomplektovka zadachakomplektovka;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;

    public ZadachaFurnitura(Integer zf) {
        zadachafurnitura = zf;
    }

    public ZadachaFurnitura() {
    }

    public ZadachaKomplektovka getZadachakomplektovka() {
        return zadachakomplektovka;
    }

    public void setZadachakomplektovka(ZadachaKomplektovka zadachakomplektovka) {
        this.zadachakomplektovka = zadachakomplektovka;
    }

    
    
    public Integer getZadachafurnitura() {
        return zadachafurnitura;
    }

    public void setZadachafurnitura(Integer zadachafurnitura) {
        this.zadachafurnitura = zadachafurnitura;
    }

    public Integer getZadacha() {
        return zadacha;
    }

    public void setZadacha(Integer zadacha) {
        this.zadacha = zadacha;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public ZadachaProduct getZadachaproduct() {
        return zadachaproduct;
    }

    public void setZadachaproduct(ZadachaProduct zadachaproduct) {
        this.zadachaproduct = zadachaproduct;
    }

    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
    }
    
    
    
    
    
    
    
}
