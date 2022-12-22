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
@Table(name = "OPERATION")
public class Operation implements Serializable {
    @Id
    @Column(name = "OPERATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERATION_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_OPERATION_ID", sequenceName = "GEN_OPERATION_ID")
    Integer operation;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del; 
    
    @ManyToOne
    @JoinColumn(name = "OPERATIONGRUPPA")
    OperationGruppa operationgruppa;

    public OperationGruppa getOperationgruppa() {
        return operationgruppa;
    }

    public void setOperationgruppa(OperationGruppa operationgruppa) {
        this.operationgruppa = operationgruppa;
    }
    
    

    public Operation(Integer o) {
        operation = o;
    }

    public Operation() {
    }

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
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
