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
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ZADACHAPRODUCT")
public class ZadachaProduct implements Serializable {
    @Id
    @Column(name = "ZADACHAPRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHAPRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHAPRODUCT_ID", sequenceName = "GEN_ZADACHAPRODUCT_ID")
    Integer zadachaproduct;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHA")
    Zadacha zadacha;
    
    @ManyToOne
    @JoinColumn(name = "MODELPRODUCT")
    ModelProduct modelproduct;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "QTY1")
    BigDecimal qty1;
    
    @Formula("coalesce((select sum(sp.ves) from scladproduct sp inner join zadachascladproduct zsp on zsp.scladproduct = sp.scladproduct where zsp.zadachaproduct = zadachaproduct),0)")
    BigDecimal all_qty;

    public BigDecimal getAll_qty() {
        return all_qty;
    }

    public void setAll_qty(BigDecimal all_qty) {
        this.all_qty = all_qty;
    }
    
    public ZadachaProduct(Integer zp) {
        zadachaproduct = zp;
    }

    public ZadachaProduct() {
    }

    public Integer getZadachaproduct() {
        return zadachaproduct;
    }

    public void setZadachaproduct(Integer zadachaproduct) {
        this.zadachaproduct = zadachaproduct;
    }

    public Zadacha getZadacha() {
        return zadacha;
    }

    public void setZadacha(Zadacha zadacha) {
        this.zadacha = zadacha;
    }

    public ModelProduct getModelproduct() {
        return modelproduct;
    }

    public void setModelproduct(ModelProduct modelproduct) {
        this.modelproduct = modelproduct;
    }

    

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getQty1() {
        return qty1;
    }

    public void setQty1(BigDecimal qty1) {
        this.qty1 = qty1;
    }

    
    
}
