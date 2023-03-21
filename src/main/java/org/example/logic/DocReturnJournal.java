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
@Table(name = "DOC_RETURN_JOURNAL")
public class DocReturnJournal implements Serializable {
    @Id
    @Column(name = "DOC_RETURN_JOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOC_RETURN_JOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOC_RETURN_JOURNAL_ID", sequenceName = "GEN_DOC_RETURN_JOURNAL_ID")
    Integer docreturnjournal;
    
    @ManyToOne
    @JoinColumn(name = "DOC_RETURN")
    DocReturn docreturn;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;
    
    
    @Column(name = "TEXT")
    String text;

    public DocReturnJournal(Integer d) {
        docreturnjournal = d;
    }

    public DocReturnJournal() {
    }

    public Integer getDocreturnjournal() {
        return docreturnjournal;
    }

    public void setDocreturnjournal(Integer docreturnjournal) {
        this.docreturnjournal = docreturnjournal;
    }

    public DocReturn getDocreturn() {
        return docreturn;
    }

    public void setDocreturn(DocReturn docreturn) {
        this.docreturn = docreturn;
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
    
    
    
    
    
}
