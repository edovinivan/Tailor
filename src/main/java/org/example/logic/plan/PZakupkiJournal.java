/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

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
@Table(name = "P_ZAKUPKIJOURNAL")
public class PZakupkiJournal implements Serializable {
    @Id
    @Column(name = "P_ZAKUPKIJOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_ZAKUPKIJOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_ZAKUPKIJOURNAL_ID", sequenceName = "GEN_P_ZAKUPKIJOURNAL_ID")
    Integer pzakupkijournal;
    
    @ManyToOne
    @JoinColumn(name = "P_ZAKUPKI")
    PZakupki pzakupki;
    
    @ManyToOne
    @JoinColumn(name = "P_MODELPLAN")
    PModelPlan pmodelplan;

    public PZakupkiJournal(Integer p) {
        pzakupkijournal = p;
    }

    public PZakupkiJournal() {
    }

    public Integer getPzakupkijournal() {
        return pzakupkijournal;
    }

    public void setPzakupkijournal(Integer pzakupkijournal) {
        this.pzakupkijournal = pzakupkijournal;
    }

    public PZakupki getPzakupki() {
        return pzakupki;
    }

    public void setPzakupki(PZakupki pzakupki) {
        this.pzakupki = pzakupki;
    }

    public PModelPlan getPmodelplan() {
        return pmodelplan;
    }

    public void setPmodelplan(PModelPlan pmodelplan) {
        this.pmodelplan = pmodelplan;
    }
    
    
    
    
         
    
    
}
