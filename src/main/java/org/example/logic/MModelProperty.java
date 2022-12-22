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
@Table(name = "M_MODELPROPERTY")
public class MModelProperty implements Serializable {
    @Id
    @Column(name = "M_MODELPROPERTY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_M_MODELPROPERTY_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_M_MODELPROPERTY_ID", sequenceName = "GEN_M_MODELPROPERTY_ID")
    Integer mmodelproperty;
    
    @Column(name = "VALUEST")
    String valuest;
    
    @ManyToOne
    @JoinColumn(name = "M_PROPERTY")
    MProperty mproperty;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;

    public MModelProperty(Integer m) {
        mmodelproperty = m;
    }

    public MModelProperty() {
    }

    public Integer getMmodelproperty() {
        return mmodelproperty;
    }

    public void setMmodelproperty(Integer mmodelproperty) {
        this.mmodelproperty = mmodelproperty;
    }

    public String getValuest() {
        return valuest;
    }

    public void setValuest(String valuest) {
        this.valuest = valuest;
    }

    public MProperty getMproperty() {
        return mproperty;
    }

    public void setMproperty(MProperty mproperty) {
        this.mproperty = mproperty;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    
    
}
