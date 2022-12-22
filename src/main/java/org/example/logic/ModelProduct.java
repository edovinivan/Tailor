/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "MODELPRODUCT")
public class ModelProduct implements Serializable {
    @Id
    @Column(name = "MODELPRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MODELPRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MODELPRODUCT_ID", sequenceName = "GEN_MODELPRODUCT_ID")
    Integer modelproduct;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT")
    Product product;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @ManyToOne
    @JoinColumn(name = "NITKICOLOR")
    Color nitkicolor;
    
    @ManyToOne
    @JoinColumn(name = "TIPPRODUCT")
    TipProduct tipproduct;
    
    
    @Column(name = "VID")
    Integer vid;
    
    @Column(name = "QTY_START")
    BigDecimal qty_start;
    
    @Column(name = "QTY_END")
    BigDecimal qty_end;

    public TipProduct getTipproduct() {
        return tipproduct;
    }

    public void setTipproduct(TipProduct tipproduct) {
        this.tipproduct = tipproduct;
    }

    public BigDecimal getQty_start() {
        return qty_start;
    }

    public void setQty_start(BigDecimal qty_start) {
        this.qty_start = qty_start;
    }

    public BigDecimal getQty_end() {
        return qty_end;
    }

    public void setQty_end(BigDecimal qty_end) {
        this.qty_end = qty_end;
    }
    
    

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public ModelProduct(Integer m) {
        modelproduct = m;
    }

    public ModelProduct() {
    }

    public Integer getModelproduct() {
        return modelproduct;
    }

    public void setModelproduct(Integer modelproduct) {
        this.modelproduct = modelproduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    

    public Color getNitkicolor() {
        return nitkicolor;
    }

    public void setNitkicolor(Color nitkicolor) {
        this.nitkicolor = nitkicolor;
    }
    
}
