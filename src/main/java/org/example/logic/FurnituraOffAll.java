/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "FURNITURAOFFALL")
public class FurnituraOffAll implements Serializable {
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
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    

    public FurnituraOffAll(Integer i) {
        id = i;
    }

    public FurnituraOffAll() {
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
