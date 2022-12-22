/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

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
import org.example.logic.Model;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "P_MODELPLANHAUPT")
public class PModelPlanHaupt implements Serializable {
    @Id
    @Column(name = "P_MODELPLANHAUPT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_MODELPLANHAUPT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_MODELPLANHAUPT_ID", sequenceName = "GEN_P_MODELPLANHAUPT_ID")
    Integer pmodelplanhaupt;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "DATES1")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates1;
    
    @Column(name = "DATES2")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates2;
    
    @Column(name = "DATES3")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates3;
    
    @Column(name = "DATES4")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates4;
    
    @Column(name = "DATES5")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates5;
    
    @Column(name = "DATES6")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates6;

    public PModelPlanHaupt(Integer p) {
        pmodelplanhaupt = p;
    }

    public PModelPlanHaupt() {
    }

    public Integer getPmodelplanhaupt() {
        return pmodelplanhaupt;
    }

    public void setPmodelplanhaupt(Integer pmodelplanhaupt) {
        this.pmodelplanhaupt = pmodelplanhaupt;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Date getDates1() {
        return dates1;
    }

    public void setDates1(Date dates1) {
        this.dates1 = dates1;
    }

    public Date getDates2() {
        return dates2;
    }

    public void setDates2(Date dates2) {
        this.dates2 = dates2;
    }

    public Date getDates3() {
        return dates3;
    }

    public void setDates3(Date dates3) {
        this.dates3 = dates3;
    }

    public Date getDates4() {
        return dates4;
    }

    public void setDates4(Date dates4) {
        this.dates4 = dates4;
    }

    public Date getDates5() {
        return dates5;
    }

    public void setDates5(Date dates5) {
        this.dates5 = dates5;
    }

    public Date getDates6() {
        return dates6;
    }

    public void setDates6(Date dates6) {
        this.dates6 = dates6;
    }
    
    
    
    
    
}
