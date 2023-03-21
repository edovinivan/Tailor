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
@Table(name = "SETUP")
public class Setup implements Serializable {
    @Id
    @Column(name = "SETUP")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SETUP_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_SETUP_ID", sequenceName = "GEN_SETUP_ID")
    Integer setup;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "VAL_STR")
    String val_str;
    
    @Column(name = "VAL_INT")
    Integer val_int;

    public Setup(Integer s) {
        setup = s;
    }

    public Setup() {
    }

    public Integer getSetup() {
        return setup;
    }

    public void setSetup(Integer setup) {
        this.setup = setup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVal_str() {
        return val_str;
    }

    public void setVal_str(String val_str) {
        this.val_str = val_str;
    }

    public Integer getVal_int() {
        return val_int;
    }

    public void setVal_int(Integer val_int) {
        this.val_int = val_int;
    }
    
    
    
    
    
}
