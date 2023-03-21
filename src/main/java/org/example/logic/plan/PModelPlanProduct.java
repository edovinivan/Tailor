/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

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
import org.example.logic.Color;
import org.example.logic.ModelProduct;
import org.example.logic.Product;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "P_MODELPLANPRODUCT")
public class PModelPlanProduct implements Serializable {
    @Id
    @Column(name = "P_MODELPLANPRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_MODELPLANPRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_MODELPLANPRODUCT_ID", sequenceName = "GEN_P_MODELPLANPRODUCT_ID")
    Integer pmodelplanproduct;
    
    @ManyToOne
    @JoinColumn(name = "P_MODELPLAN")
    PModelPlan pmodelplan;
    
    @ManyToOne
    @JoinColumn(name = "MODELPRODUCT")
    ModelProduct modelproduct;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT")
    Product product;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
          

    public PModelPlanProduct(Integer p) {
        pmodelplanproduct = p;
    }

    public PModelPlanProduct() {
    }

    public Integer getPmodelplanproduct() {
        return pmodelplanproduct;
    }

    public void setPmodelplanproduct(Integer pmodelplanproduct) {
        this.pmodelplanproduct = pmodelplanproduct;
    }

    public PModelPlan getPmodelplan() {
        return pmodelplan;
    }

    public void setPmodelplan(PModelPlan pmodelplan) {
        this.pmodelplan = pmodelplan;
    }

    public ModelProduct getModelproduct() {
        return modelproduct;
    }

    public void setModelproduct(ModelProduct modelproduct) {
        this.modelproduct = modelproduct;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
    
    
    
    
    
}
