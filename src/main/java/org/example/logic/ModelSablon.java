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
@Table(name = "MODELSABLON")
public class ModelSablon implements Serializable {
    @Id
    @Column(name = "MODELSABLON")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MODELSABLON_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MODELSABLON_ID", sequenceName = "GEN_MODELSABLON_ID")
    Integer modelsablon;
    
    @ManyToOne
    @JoinColumn(name = "SABLON")
    Sablon sablon;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @Column(name = "QTY")
    Integer qty;

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    

    @Override
    public String toString() {
        return getSablon().getName();
    }
    
    public ModelSablon() {
    }

    public ModelSablon(Integer modelsablon) {
        this.modelsablon = modelsablon;
    }

    public Integer getModelsablon() {
        return modelsablon;
    }

    public void setModelsablon(Integer modelsablon) {
        this.modelsablon = modelsablon;
    }

    public Sablon getSablon() {
        return sablon;
    }

    public void setSablon(Sablon sablon) {
        this.sablon = sablon;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    
    
}
