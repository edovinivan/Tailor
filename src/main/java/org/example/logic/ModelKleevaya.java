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
@Table(name = "MODELKTEEVAYA")
public class ModelKleevaya implements Serializable {
    @Id
    @Column(name = "MODELKTEEVAYA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MODELKTEEVAYA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MODELKTEEVAYA_ID", sequenceName = "GEN_MODELKTEEVAYA_ID")
    Integer modelkleevaya;
    
    @ManyToOne
    @JoinColumn(name = "KLEEVAYA")
    Kleevaya kleevaya;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @Column(name = "QTY")            
    Integer qty;
    
    @Column(name = "COLOR")
    String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    

    public ModelKleevaya() {
    }

    public ModelKleevaya(Integer modelkleevaya) {
        this.modelkleevaya = modelkleevaya;
    }

    public Integer getModelkleevaya() {
        return modelkleevaya;
    }

    public void setModelkleevaya(Integer modelkleevaya) {
        this.modelkleevaya = modelkleevaya;
    }

    public Kleevaya getKleevaya() {
        return kleevaya;
    }

    public void setKleevaya(Kleevaya kleevaya) {
        this.kleevaya = kleevaya;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    
    
}
