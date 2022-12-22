/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.Uchet;

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
@Table(name = "U_OPERATION")
public class UOperation implements Serializable {
    @Id
    @Column(name = "U_OPERATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_U_OPERATION_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_U_OPERATION_ID", sequenceName = "GEN_U_OPERATION_ID")
    Integer uoperation;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;
    
    @Column(name = "PM")
    Integer pm;

    @Override
    public String toString() {
        return getName();
    }
    
    

    public UOperation(Integer u) {
        uoperation = u;
    }

    public UOperation() {
    }

    public Integer getUoperation() {
        return uoperation;
    }

    public void setUoperation(Integer uoperation) {
        this.uoperation = uoperation;
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

    public Integer getPm() {
        return pm;
    }

    public void setPm(Integer pm) {
        this.pm = pm;
    }
    
    
    
    
    
}
