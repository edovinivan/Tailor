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
@Table(name = "TIPNASTILA")
public class TipNastila implements Serializable {
    @Id
    @Column(name = "TIPNASTILA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_TIPNASTILA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_TIPNASTILA_ID", sequenceName = "GEN_TIPNASTILA_ID")
    Integer tipnastila;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    public TipNastila(Integer t) {
        tipnastila = t;
    }

    public TipNastila() {
    }

    public Integer getTipnastila() {
        return tipnastila;
    }

    public void setTipnastila(Integer tipnastila) {
        this.tipnastila = tipnastila;
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
