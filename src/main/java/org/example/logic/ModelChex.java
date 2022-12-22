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
@Table(name = "MODELCHEX")
public class ModelChex implements Serializable {
    @Id
    @Column(name = "MODELCHEX")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MODELCHEX_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MODELCHEX_ID", sequenceName = "GEN_MODELCHEX_ID")
    Integer modelchex;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @ManyToOne
    @JoinColumn(name = "CHEX")
    RabotnikGruppa chex;
    
    @Column(name  = "VALS")
    Integer vals;

    public ModelChex(Integer m) {
        modelchex = m;
    }

    public ModelChex() {
    }

    public Integer getModelchex() {
        return modelchex;
    }

    public void setModelchex(Integer modelchex) {
        this.modelchex = modelchex;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public RabotnikGruppa getChex() {
        return chex;
    }

    public void setChex(RabotnikGruppa chex) {
        this.chex = chex;
    }

    public Integer getVals() {
        return vals;
    }

    public void setVals(Integer vals) {
        this.vals = vals;
    }
    
    
    
    
    
}
