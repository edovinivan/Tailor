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
@Table(name = "DOC_RETURNF_JOURNAL")
public class DocReturnFJournal implements Serializable {
    @Id
    @Column(name = "DOC_RETURNF_JOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOC_RETURNF_JOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOC_RETURNF_JOURNAL_ID", sequenceName = "GEN_DOC_RETURNF_JOURNAL_ID")
    Integer docreturnfjournal;
    
    @ManyToOne
    @JoinColumn(name = "DOC_RETURNF")
    DocReturnF docreturnf;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;
    
    
    @Column(name = "TEXT")
    String text;
    
    @Column(name = "QTY")
    BigDecimal qty;

    public DocReturnFJournal(Integer d) {
        docreturnfjournal = d;
    }

    public DocReturnFJournal() {
    }

    public Integer getDocreturnfjournal() {
        return docreturnfjournal;
    }

    public void setDocreturnfjournal(Integer docreturnfjournal) {
        this.docreturnfjournal = docreturnfjournal;
    }

    public DocReturnF getDocreturnf() {
        return docreturnf;
    }

    public void setDocreturnf(DocReturnF docreturnf) {
        this.docreturnf = docreturnf;
    }
    
    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    
}
