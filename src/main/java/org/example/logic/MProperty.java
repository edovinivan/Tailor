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
@Table(name = "M_PROPERTY")
public class MProperty implements Serializable {
    @Id
    @Column(name = "M_PROPERTY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_M_PROPERTY_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_M_PROPERTY_ID", sequenceName = "GEN_M_PROPERTY_ID")
    Integer mproperty;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    @Override
    public String toString() {
        return getName();
    }

    public MProperty(Integer m) {
        mproperty = m;
    }

    public MProperty() {
    }

    public Integer getMproperty() {
        return mproperty;
    }

    public void setMproperty(Integer mproperty) {
        this.mproperty = mproperty;
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
