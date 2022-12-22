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
@Table(name = "ZADACHADOPSCLADPRODUCT")
public class ZadachaDopScladProduct implements Serializable {
    @Id
    @Column(name = "ZADACHADOPSCLADPRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHADOPSCLADPRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHADOPSCLADPRODUCT_ID", sequenceName = "GEN_ZADACHADOPSCLADPRODUCT_ID")
    Integer zadachadopscladproduct;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHA")
    Zadacha zadacha;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;

    public ZadachaDopScladProduct(Integer z) {
        zadachadopscladproduct = z;
    }

    public ZadachaDopScladProduct() {
    }

    public Integer getZadachadopscladproduct() {
        return zadachadopscladproduct;
    }

    public void setZadachadopscladproduct(Integer zadachadopscladproduct) {
        this.zadachadopscladproduct = zadachadopscladproduct;
    }

    public Zadacha getZadacha() {
        return zadacha;
    }

    public void setZadacha(Zadacha zadacha) {
        this.zadacha = zadacha;
    }

    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
    }
    
    
    
    
            
            
    
}
