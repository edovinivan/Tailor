/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "SETUPNAME")
public class SetupName implements Serializable {
    @Id
    @Column(name = "SETUPNAME")    
    Integer setupname;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "VAL")
    Integer val;

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
    
    

    public SetupName() {
    }

    public SetupName(int s) {
        setupname = s;
    }

    public Integer getSetupname() {
        return setupname;
    }

    public void setSetupname(Integer setupname) {
        this.setupname = setupname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
