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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "TIPMODEL")
public class TipModel implements Serializable {
    @Id
    @Column(name = "TIPMODEL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_TIPMODEL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_TIPMODEL_ID", sequenceName = "GEN_TIPMODEL_ID")
    Integer tipmodel;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;
    
    @Column(name = "KOEF")
    BigDecimal koef;

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }
    
    

    @Override
    public String toString() {
        return getName();
    }

    public TipModel(Integer t) {
        tipmodel = t;
    }

    public TipModel() {
    }

    public Integer getTipmodel() {
        return tipmodel;
    }

    public void setTipmodel(Integer tipmodel) {
        this.tipmodel = tipmodel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
    
}
