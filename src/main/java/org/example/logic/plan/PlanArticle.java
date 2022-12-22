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
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.example.logic.Color;
import org.example.logic.Model;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "PLANARTICLE")
public class PlanArticle implements Serializable {
    @Id
    @Column(name = "PLANARTICLE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_PLANARTICLE_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_PLANARTICLE_ID", sequenceName = "GEN_PLANARTICLE_ID")
    Integer planarticle;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;

    public PlanArticle(Integer planarticle) {
        this.planarticle = planarticle;
    }

    public PlanArticle() {
    }

    public Integer getPlanarticle() {
        return planarticle;
    }

    public void setPlanarticle(Integer planarticle) {
        this.planarticle = planarticle;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    
    
    
    
}
