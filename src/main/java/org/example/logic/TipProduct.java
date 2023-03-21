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
@Table(name = "TIPPRODUCT")
public class TipProduct implements Serializable {
    @Id
    @Column(name = "TIPPRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_TIPPRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_TIPPRODUCT_ID", sequenceName = "GEN_TIPPRODUCT_ID")
    Integer tipproduct;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    public TipProduct(Integer tp) {
        tipproduct = tp;
    }

    public TipProduct() {
    }

    public Integer getTipproduct() {
        return tipproduct;
    }

    public void setTipproduct(Integer tipproduct) {
        this.tipproduct = tipproduct;
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
