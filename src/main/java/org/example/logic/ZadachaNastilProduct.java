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
@Table(name = "ZADACHANASTILPRODUCT")
public class ZadachaNastilProduct implements Serializable {
    @Id
    @Column(name = "ZADACHANASTILPRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHANASTILPRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHANASTILPRODUCT_ID", sequenceName = "GEN_ZADACHANASTILPRODUCT_ID")
    Integer zadachanastilproduct;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHANASTIL")
    ZadachaNastil zadachanastil;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHASCLADPRODUCT")
    ZadachaScladProduct zadachascladproduct;

    public ZadachaNastilProduct(Integer znp) {
        zadachanastilproduct = znp;
    }

    public ZadachaNastilProduct() {
    }

    public Integer getZadachanastilproduct() {
        return zadachanastilproduct;
    }

    public void setZadachanastilproduct(Integer zadachanastilproduct) {
        this.zadachanastilproduct = zadachanastilproduct;
    }

    public ZadachaNastil getZadachanastil() {
        return zadachanastil;
    }

    public void setZadachanastil(ZadachaNastil zadachanastil) {
        this.zadachanastil = zadachanastil;
    }

    public ZadachaScladProduct getZadachascladproduct() {
        return zadachascladproduct;
    }

    public void setZadachascladproduct(ZadachaScladProduct zadachascladproduct) {
        this.zadachascladproduct = zadachascladproduct;
    }
    
    
    
    
    
}
