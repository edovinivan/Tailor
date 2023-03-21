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
@Table(name = "P_MODELPLANHAUPTJOURNAL")
public class PModelPlanHauptJournal implements Serializable {
    @Id
    @Column(name = "P_MODELPLANHAUPTJOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_MODELPLANHAUPTJOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_MODELPLANHAUPTJOURNAL_ID", sequenceName = "GEN_P_MODELPLANHAUPTJOURNAL_ID")
    Integer pmodelplanhauptjournal;
    
    @ManyToOne
    @JoinColumn(name = "P_MODELPLANHAUPT")
    PModelPlanHaupt pmodelplanhaupt;
    
    @ManyToOne
    @JoinColumn(name = "P_MODELPLAN")
    PModelPlan pmodelplan;

    public PModelPlanHauptJournal(Integer p) {
        pmodelplanhauptjournal = p;
    }

    public PModelPlanHauptJournal() {
    }

    public Integer getPmodelplanhauptjournal() {
        return pmodelplanhauptjournal;
    }

    public void setPmodelplanhauptjournal(Integer pmodelplanhauptjournal) {
        this.pmodelplanhauptjournal = pmodelplanhauptjournal;
    }

    public PModelPlanHaupt getPmodelplanhaupt() {
        return pmodelplanhaupt;
    }

    public void setPmodelplanhaupt(PModelPlanHaupt pmodelplanhaupt) {
        this.pmodelplanhaupt = pmodelplanhaupt;
    }

    public PModelPlan getPmodelplan() {
        return pmodelplan;
    }

    public void setPmodelplan(PModelPlan pmodelplan) {
        this.pmodelplan = pmodelplan;
    }
    
    
    
    
    
}
