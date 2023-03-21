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
import org.example.logic.Razmeri;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "P_MODELPLANRAZMERI")
public class PModelPlanRazmeri implements Serializable {
    @Id
    @Column(name = "P_MODELPLANRAZMERI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_MODELPLANRAZMERI_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_MODELPLANRAZMERI_ID", sequenceName = "GEN_P_MODELPLANRAZMERI_ID")
    Integer pmodelplanrazmeri;
    
    @ManyToOne
    @JoinColumn(name = "P_MODELPLAN")
    PModelPlan pmodelplan;
    
    @ManyToOne
    @JoinColumn(name = "RAZMERI")
    Razmeri razmeri;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "TX")
    String tx;

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }
    
    

    public PModelPlanRazmeri(Integer p) {
        pmodelplanrazmeri = p;
    }

    public PModelPlanRazmeri() {
    }

    public Integer getPmodelplanrazmeri() {
        return pmodelplanrazmeri;
    }

    public void setPmodelplanrazmeri(Integer pmodelplanrazmeri) {
        this.pmodelplanrazmeri = pmodelplanrazmeri;
    }

    public PModelPlan getPmodelplan() {
        return pmodelplan;
    }

    public void setPmodelplan(PModelPlan pmodelplan) {
        this.pmodelplan = pmodelplan;
    }

    public Razmeri getRazmeri() {
        return razmeri;
    }

    public void setRazmeri(Razmeri razmeri) {
        this.razmeri = razmeri;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    
    
    
    
}
