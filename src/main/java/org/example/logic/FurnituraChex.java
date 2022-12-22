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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "FURNITURACHEX")
public class FurnituraChex implements Serializable {
    @Id
    @Column(name = "ID")    
    Integer id;
    
    @Column(name = "PRODUCT")
    String product;
    
    @Column(name = "COLOR")
    String color;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "CHEX")
    String chex;
    
    @Column(name = "CID")
    Integer cid;

    public FurnituraChex(Integer i) {
        id = i;
    }

    public FurnituraChex() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getChex() {
        return chex;
    }

    public void setChex(String chex) {
        this.chex = chex;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    
    
    
    
    
    
}
