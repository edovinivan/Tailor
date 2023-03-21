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

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "U_OPERJOU")
public class UOperJou implements Serializable {
    
    @Id
    @Column(name = "U_OPERJOU")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_U_OPERJOU_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_U_OPERJOU_ID", sequenceName = "GEN_U_OPERJOU_ID")
    Integer uoperjou;
    
    @ManyToOne
    @JoinColumn(name = "U_OPERDOC")
    UOperDoc uoperdoc;
    
    @Column(name = "BDATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date bdates;
            
    @Column(name = "EDATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date edates;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date dates;
    
    @Column(name = "COMMENT")
    String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    

    public UOperJou(Integer uj) {
        uoperjou = uj;
    }

    public UOperJou() {
    }

    public Integer getUoperjou() {
        return uoperjou;
    }

    public void setUoperjou(Integer uoperjou) {
        this.uoperjou = uoperjou;
    }

    public UOperDoc getUoperdoc() {
        return uoperdoc;
    }

    public void setUoperdoc(UOperDoc uoperdoc) {
        this.uoperdoc = uoperdoc;
    }

    public Date getBdates() {
        return bdates;
    }

    public void setBdates(Date bdates) {
        this.bdates = bdates;
    }

    

    public Date getEdates() {
        return edates;
    }

    public void setEdates(Date edates) {
        this.edates = edates;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    
    
    
    
    
    
}
