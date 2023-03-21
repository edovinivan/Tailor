/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "OPERATIONHISTORY")
public class OperationHistory implements Serializable {
    @Id
    @Column(name = "OPERATIONHISTORY")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERATIONHISTORY_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_OPERATIONHISTORY_ID", sequenceName = "GEN_OPERATIONHISTORY_ID")
    Integer operationhistory;
    
    @ManyToOne
    @JoinColumn(name = "OPERATOR")
    Operator oper;
    
    @Column(name = "DATES")            
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date dates;
    
    @Column(name = "OPERATIONS")
    String operations;
    
    @Column(name = "DOCUMENT")
    Integer document;
    
    @Column(name = "VID")
    Integer vid;

    public OperationHistory(Integer op) {
        operationhistory = op;
    }

    public OperationHistory() {
    }

    public Integer getOperationhistory() {
        return operationhistory;
    }

    public void setOperationhistory(Integer operationhistory) {
        this.operationhistory = operationhistory;
    }

    public Operator getOper() {
        return oper;
    }

    public void setOper(Operator oper) {
        this.oper = oper;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
    
    
    
    
    
}
