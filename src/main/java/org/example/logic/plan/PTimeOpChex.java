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
import org.example.logic.OperationGruppa;
import org.example.logic.RabotnikGruppa;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "P_TIMEOPCHEX")
public class PTimeOpChex implements Serializable {
    @Id
    @Column(name = "P_TIMEOPCHEX")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_TIMEOPCHEX_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_TIMEOPCHEX_ID", sequenceName = "GEN_P_TIMEOPCHEX_ID")
    Integer ptimeopchex;
    
    @ManyToOne
    @JoinColumn(name = "OPERATIONGRUPPA")
    OperationGruppa operationgruppa;
    
    @ManyToOne
    @JoinColumn(name = "CHEX")
    RabotnikGruppa chex;
    
    @Column(name = "TIMES")
    Integer times;

    public PTimeOpChex(Integer p) {
        ptimeopchex = p;
    }

    public PTimeOpChex() {
    }

    public Integer getPtimeopchex() {
        return ptimeopchex;
    }

    public void setPtimeopchex(Integer ptimeopchex) {
        this.ptimeopchex = ptimeopchex;
    }

    public OperationGruppa getOperationgruppa() {
        return operationgruppa;
    }

    public void setOperationgruppa(OperationGruppa operationgruppa) {
        this.operationgruppa = operationgruppa;
    }

    public RabotnikGruppa getChex() {
        return chex;
    }

    public void setChex(RabotnikGruppa chex) {
        this.chex = chex;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
    
    
    
    
    
    
}
