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
import org.example.logic.Color;
import org.example.logic.Model;
import org.example.logic.Razmeri;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "P_MODELYAR")
public class PModelYar implements Serializable {
    @Id
    @Column(name = "P_MODELYAR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_MODELYAR_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_MODELYAR_ID", sequenceName = "GEN_P_MODELYAR_ID")
    Integer pmodelyar;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
    
    @ManyToOne
    @JoinColumn(name = "RAZMERI")
    Razmeri razmeri;
        
    @Column(name = "YAR")
    Integer yar;
    
    @Column(name = "QTY")
    Integer qty;

    public PModelYar() {
    }
    
    public PModelYar(Integer p) {
        pmodelyar = p;
    }

    public Integer getPmodelyar() {
        return pmodelyar;
    }

    public void setPmodelyar(Integer pmodelyar) {
        this.pmodelyar = pmodelyar;
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

    public Razmeri getRazmeri() {
        return razmeri;
    }

    public void setRazmeri(Razmeri razmeri) {
        this.razmeri = razmeri;
    }

    public Integer getYar() {
        return yar;
    }

    public void setYar(Integer yar) {
        this.yar = yar;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    
    
}
