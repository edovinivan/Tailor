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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ZADACHANASTILDOP")
public class ZadachaNastilDop implements Serializable {
    @Id
    @Column(name = "ZADACHANASTILDOP")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHANASTILDOP_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHANASTILDOP_ID", sequenceName = "GEN_ZADACHANASTILDOP_ID")
    Integer zadachanastildop;
    
    @Column(name = "ZADACHANASTIL")
    Integer zadachanastil;
    
    @Column(name = "LIGHT")
    Integer light;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "KOLSLOI")
    Integer kolsloi;
    
    @Column(name = "KOLSLOIDOP")
    Integer kolsloidop;

    public Integer getKolsloidop() {
        if(kolsloidop == null)
            return 0;
        return kolsloidop;
    }

    public void setKolsloidop(Integer kolsloidop) {
        this.kolsloidop = kolsloidop;
    }
    
    public Integer getKolsloi() {
        if(kolsloi == null)
            return 0;
        return kolsloi;
    }

    public void setKolsloi(Integer kolsloi) {
        this.kolsloi = kolsloi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public ZadachaNastilDop(Integer znp) {
        zadachanastildop = znp;
    }

    public ZadachaNastilDop() {
    }

    public Integer getZadachanastildop() {
        return zadachanastildop;
    }

    public void setZadachanastildop(Integer zadachanastildop) {
        this.zadachanastildop = zadachanastildop;
    }

    public Integer getZadachanastil() {
        return zadachanastil;
    }

    public void setZadachanastil(Integer zadachanastil) {
        this.zadachanastil = zadachanastil;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    
    
    
}
