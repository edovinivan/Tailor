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
@Table(name = "REVIZIAJOURNAL")
public class ReviziaJournal implements Serializable {
    @Id
    @Column(name = "REVIZIAJOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_REVIZIAJOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_REVIZIAJOURNAL_ID", sequenceName = "GEN_REVIZIAJOURNAL_ID")
    Integer reviziajournal;
    
    @ManyToOne
    @JoinColumn(name = "REVIZIA")
    Revizia revizia;
    
    @ManyToOne
    @JoinColumn(name = "SCLADPRODUCT")
    ScladProduct scladproduct;
    
    @Column(name="VES")
    BigDecimal ves;
    
    @Column(name="VESDB")
    BigDecimal vesdb;

    public ReviziaJournal(Integer rj) {
        reviziajournal = rj;
    }

    public ReviziaJournal() {
    }

    public Integer getReviziajournal() {
        return reviziajournal;
    }

    public void setReviziajournal(Integer reviziajournal) {
        this.reviziajournal = reviziajournal;
    }

    public Revizia getRevizia() {
        return revizia;
    }

    public void setRevizia(Revizia revizia) {
        this.revizia = revizia;
    }

    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
    }

    public BigDecimal getVes() {
        return ves;
    }

    public void setVes(BigDecimal ves) {
        this.ves = ves;
    }

    public BigDecimal getVesdb() {
        return vesdb;
    }

    public void setVesdb(BigDecimal vesdb) {
        this.vesdb = vesdb;
    }
    
    
    
    
    
}
