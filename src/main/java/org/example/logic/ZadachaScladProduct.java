/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
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
@Table(name = "ZADACHASCLADPRODUCT")
public class ZadachaScladProduct implements Serializable {
    @Id
    @Column(name = "ZADACHASCLADPRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHASCLADPRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHASCLADPRODUCT_ID", sequenceName = "GEN_ZADACHASCLADPRODUCT_ID")
    Integer zadachascladproduct;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHAPRODUCT")
    ZadachaProduct zadachaproduct;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHA")
    Zadacha zadacha;
    
    @Column(name = "NASTIL")
    Integer nastil;

    public Integer getNastil() {
        return nastil;
    }

    public void setNastil(Integer nastil) {
        this.nastil = nastil;
    }
    
    

    public Zadacha getZadacha() {
        return zadacha;
    }

    public void setZadacha(Zadacha zadacha) {
        this.zadacha = zadacha;
    }
    
    

    public ZadachaScladProduct(Integer zsp) {
        zadachascladproduct = zsp;
    }

    public ZadachaScladProduct() {
    }

    public Integer getZadachascladproduct() {
        return zadachascladproduct;
    }

    public void setZadachascladproduct(Integer zadachascladproduct) {
        this.zadachascladproduct = zadachascladproduct;
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
