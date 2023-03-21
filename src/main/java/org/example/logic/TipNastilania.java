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
@Table(name = "TIPNASTILANIA")
public class TipNastilania implements Serializable {
    @Id
    @Column(name = "TIPNASTILANIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_TIPNASTILANIA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_TIPNASTILANIA_ID", sequenceName = "GEN_TIPNASTILANIA_ID")
    Integer tipnastilania;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    public TipNastilania(Integer t) {
        tipnastilania = t;
    }

    public TipNastilania() {
    }

    public Integer getTipnastilania() {
        return tipnastilania;
    }

    public void setTipnastilania(Integer tipnastilania) {
        this.tipnastilania = tipnastilania;
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
