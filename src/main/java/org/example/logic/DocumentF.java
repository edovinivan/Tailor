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
@Table(name = "DOCUMENTF")
public class DocumentF implements Serializable {
    @Id
    @Column(name = "DOCUMENTF")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOCUMENTF_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOCUMENTF_ID", sequenceName = "GEN_DOCUMENTF_ID")
    Integer documentf;
    
    @Column(name = "NAME")
    String nomer;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "STATUS")
    Integer status;    
    
    @ManyToOne
    @JoinColumn(name = "CHEX")
    RabotnikGruppa chex;
    
    @Column(name = "TEXTS")
    String testx;

    public DocumentF(Integer df) {
        documentf = df;
    }

    public DocumentF() {
    }

    public Integer getDocumentf() {
        return documentf;
    }

    public void setDocumentf(Integer documentf) {
        this.documentf = documentf;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RabotnikGruppa getChex() {
        return chex;
    }

    public void setChex(RabotnikGruppa chex) {
        this.chex = chex;
    }

    public String getTestx() {
        return testx;
    }

    public void setTestx(String testx) {
        this.testx = testx;
    }
    
    
    
    
    
}
