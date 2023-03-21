/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.Uchet;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "U_DOCUMENT")
public class UDocument implements Serializable {
    @Id
    @Column(name = "U_DOCUMENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_U_DOCUMENT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_U_DOCUMENT_ID", sequenceName = "GEN_U_DOCUMENT_ID")
    Integer udocument;
    
    @ManyToOne
    @JoinColumn(name = "U_OPERATION")
    UOperation uoperation;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "UDATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date udates;
    
    @Column(name = "SUMMA")
    BigDecimal summa;
    
    @Column(name = "TEXTS")
    String texts;

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }
    
    

    public UDocument(Integer u) {
        udocument = u;
    }

    public UDocument() {
    }

    public Integer getUdocument() {
        return udocument;
    }

    public void setUdocument(Integer udocument) {
        this.udocument = udocument;
    }

    public UOperation getUoperation() {
        return uoperation;
    }

    public void setUoperation(UOperation uoperation) {
        this.uoperation = uoperation;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Date getUdates() {
        return udates;
    }

    public void setUdates(Date udates) {
        this.udates = udates;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }
    
}
