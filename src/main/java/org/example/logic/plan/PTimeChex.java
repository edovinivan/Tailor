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
import org.example.logic.RabotnikGruppa;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "P_TIMECHEX")
public class PTimeChex implements Serializable {
    @Id
    @Column(name = "P_TIMECHEX")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_TIMECHEX_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_TIMECHEX_ID", sequenceName = "GEN_P_TIMECHEX_ID")
    Integer ptimechex;
    
    @ManyToOne
    @JoinColumn(name = "P_MODELPLAN")
    PModelPlan pmodelplan;
    
    @ManyToOne
    @JoinColumn(name = "CHEX")
    RabotnikGruppa chex;
    
    @Column(name = "QTY")
    Integer qty;

    public PTimeChex(Integer p) {
        ptimechex = p;
    }
    
    public PTimeChex() {
    }

    public Integer getPtimechex() {
        return ptimechex;
    }

    public void setPtimechex(Integer ptimechex) {
        this.ptimechex = ptimechex;
    }

    public PModelPlan getPmodelplan() {
        return pmodelplan;
    }

    public void setPmodelplan(PModelPlan pmodelplan) {
        this.pmodelplan = pmodelplan;
    }

    public RabotnikGruppa getChex() {
        return chex;
    }

    public void setChex(RabotnikGruppa chex) {
        this.chex = chex;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    
    
    
}
