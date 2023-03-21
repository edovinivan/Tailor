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
import org.example.logic.Color;
import org.example.logic.Model;
import org.example.logic.RabotnikGruppa;
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "P_MODELPLAN")
public class PModelPlan implements Serializable {
    @Id
    @Column(name = "P_MODELPLAN")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_MODELPLAN_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_MODELPLAN_ID", sequenceName = "GEN_P_MODELPLAN_ID")
    Integer pmodelplan;
    
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
    
    @Column(name = "DATES5")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates5;
    
    @Column(name = "DATES6")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates6;
    
    @Column(name = "DATES7")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates7;
    
    @Column(name = "DATES8")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates8;
    
    @ManyToOne
    @JoinColumn(name = "CHEX")
    RabotnikGruppa chex;
    
    @Column(name = "STATUS")
    Integer status;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;

    @Formula("coalesce((select sum(pr.qty) from P_MODELPLANRAZMERI pr where pr.p_modelplan = p_modelplan),0)")          
    Integer sumqty;
    
    @Formula("coalesce((select count(pr.qty) from P_MODELPLANRAZMERI pr where pr.p_modelplan = p_modelplan),0)")          
    Integer counts;
    
    @Column(name = "COMMENT1")
    String comment1;
    
    /*Количество распределенных операций*/
    @Formula("coalesce((select sum(pr.qty) from P_TIMECHEX pr where pr.p_modelplan = p_modelplan),0)")          
    Integer sumqtychex;
    
    public Integer getNoChex()
    {
        return getSumqty() - getSumqtychex();
    }

    public Integer getSumqtychex() {
        return sumqtychex;
    }

    public void setSumqtychex(Integer sumqtychex) {
        this.sumqtychex = sumqtychex;
    }
    
    

    public Date getDates7() {
        return dates7;
    }

    public void setDates7(Date dates7) {
        this.dates7 = dates7;
    }

    public Date getDates8() {
        return dates8;
    }

    public void setDates8(Date dates8) {
        this.dates8 = dates8;
    }
    
    

    public Date getDates6() {
        return dates6;
    }

    public void setDates6(Date dates6) {
        this.dates6 = dates6;
    }
   
    
    
  
    public Date getDates5() {
        return dates5;
    }

    public void setDates5(Date dates5) {
        this.dates5 = dates5;
    }
    

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
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
    
    

    public Integer getSumqty() {
        return sumqty;
    }

    public void setSumqty(Integer sumqty) {
        this.sumqty = sumqty;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
    
    

    

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
  
    
    
    public PModelPlan(Integer p) {
        pmodelplan = p;
    }

    public PModelPlan() {
    }

    public Integer getPmodelplan() {
        return pmodelplan;
    }

    public void setPmodelplan(Integer pmodelplan) {
        this.pmodelplan = pmodelplan;
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

    public RabotnikGruppa getChex() {
        return chex;
    }

    public void setChex(RabotnikGruppa chex) {
        this.chex = chex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

 
    
    
}
