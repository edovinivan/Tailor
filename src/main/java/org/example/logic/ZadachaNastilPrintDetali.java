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
@Table(name = "ZADACHANASTILPRINTDETALI")
public class ZadachaNastilPrintDetali implements Serializable {
    @Id
    @Column(name = "ZADACHANASTILPRINTDETALI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHANASTILPRINTDETALI_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHANASTILPRINTDETALI_ID", sequenceName = "GEN_ZADACHANASTILPRINTDETALI_ID")
    Integer zadachanastilprintdetali;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHANASTIL")
    ZadachaNastil zadachanastil;
     
    @ManyToOne
    @JoinColumn(name = "MODELPRINTDETALI")
    ModelPrintDetali modelprintdetali;
    
    @Column(name = "QTY")
    Integer qty;

    public ZadachaNastilPrintDetali(Integer zspd) {
        zadachanastilprintdetali = zspd;
    }

    public ZadachaNastilPrintDetali() {
    }

    public Integer getZadachanastilprintdetali() {
        return zadachanastilprintdetali;
    }

    public void setZadachanastilprintdetali(Integer zadachanastilprintdetali) {
        this.zadachanastilprintdetali = zadachanastilprintdetali;
    }

    public ZadachaNastil getZadachanastil() {
        return zadachanastil;
    }

    public void setZadachanastil(ZadachaNastil zadachanastil) {
        this.zadachanastil = zadachanastil;
    }

    public ModelPrintDetali getModelprintdetali() {
        return modelprintdetali;
    }

    public void setModelprintdetali(ModelPrintDetali modelprintdetali) {
        this.modelprintdetali = modelprintdetali;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    
    
    
    
    
}
