/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.Uchet;

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
import javax.persistence.Transient;
import org.example.logic.Operator;
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "U_OPERDOC")
public class UOperDoc implements Serializable {
    
    @Id
    @Column(name = "U_OPERDOC")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_U_OPERDOC_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_U_OPERDOC_ID", sequenceName = "GEN_U_OPERDOC_ID")
    Integer uoperdoc;
    
    @ManyToOne
    @JoinColumn(name = "OPERATOR")
    Operator operator;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date dates;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "COMMS")
    String comms;
    
    @Column(name = "STATUS")
    Integer status;

    
    @Column(name = "MINUTEST", insertable=false, updatable=false)
    Integer minutest;

    public Integer getMinutest() {
        return minutest;
    }
  
    
    
    public UOperDoc(Integer u) {
        uoperdoc = u;
    }

    public UOperDoc() {
    }

    public Integer getUoperdoc() {
        return uoperdoc;
    }

    public void setUoperdoc(Integer uoperdoc) {
        this.uoperdoc = uoperdoc;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComms() {
        return comms;
    }

    public void setComms(String comms) {
        this.comms = comms;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
    
    
    
}
