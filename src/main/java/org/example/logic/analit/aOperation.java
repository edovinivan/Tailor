/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.analit;

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
@Table(name = "A_OPERATION")
public class aOperation implements Serializable {
    @Id
    @Column(name = "A_OPERATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_OPERATION_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_OPERATION_ID", sequenceName = "GEN_A_OPERATION_ID")
    Integer a_operation;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "INK")
    Integer ink;

    public aOperation() {
    }

    public Integer getA_operation() {
        return a_operation;
    }

    public void setA_operation(Integer a_operation) {
        this.a_operation = a_operation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInk() {
        return ink;
    }

    public void setInk(Integer ink) {
        this.ink = ink;
    }

   
    
    
    
}
