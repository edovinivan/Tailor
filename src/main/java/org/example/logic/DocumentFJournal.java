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
@Table(name = "DOCUMENTFJOURNAL")
public class DocumentFJournal implements Serializable {
    @Id
    @Column(name = "DOCUMENTFJOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOCUMENTFJOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOCUMENTFJOURNAL_ID", sequenceName = "GEN_DOCUMENTFJOURNAL_ID")
    Integer documentfjournal;
    
    @ManyToOne
    @JoinColumn(name = "DOCUMENTF")
    DocumentF documentf;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;
            
    @Column(name = "QTY")
    BigDecimal qty;

    public DocumentFJournal(Integer dj) {
        documentfjournal = dj;
    }

    public DocumentFJournal() {
    }

    public Integer getDocumentfjournal() {
        return documentfjournal;
    }

    public void setDocumentfjournal(Integer documentfjournal) {
        this.documentfjournal = documentfjournal;
    }

    public DocumentF getDocumentf() {
        return documentf;
    }

    public void setDocumentf(DocumentF documentf) {
        this.documentf = documentf;
    }

    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
    
    
    
    
    
}
