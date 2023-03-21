/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SCLADPRODUCTF")
public class ScladProductF implements Serializable {
    @Id
    @Column(name = "SCLADPRODUCTF")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SCLADPRODUCTF_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_SCLADPRODUCTF_ID", sequenceName = "GEN_SCLADPRODUCTF_ID")
    Integer scladproductf;
    
    @ManyToOne
    @JoinColumn(name = "DOCUMENTFJOURNAL")
    DocumentFJournal documentfjournal;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "OSTATOK")
    BigDecimal ostatok;

    public BigDecimal getOstatok() {
        return ostatok;
    }

    public void setOstatok(BigDecimal ostatok) {
        this.ostatok = ostatok;
    }

    public ScladProductF(Integer s) {
        scladproductf = s;
    }

    public ScladProductF() {
    }

    public Integer getScladproductf() {
        return scladproductf;
    }

    public void setScladproductf(Integer scladproductf) {
        this.scladproductf = scladproductf;
    }

    public DocumentFJournal getDocumentfjournal() {
        return documentfjournal;
    }

    public void setDocumentfjournal(DocumentFJournal documentfjournal) {
        this.documentfjournal = documentfjournal;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
    
    
    
    
    
}
