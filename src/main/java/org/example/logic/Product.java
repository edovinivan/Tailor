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
@Table(name = "PRODUCT")
public class Product implements Serializable {
    
    @Id
    @Column(name = "PRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_PRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_PRODUCT_ID", sequenceName = "GEN_PRODUCT_ID")
    Integer product;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;    
    
    @ManyToOne
    @JoinColumn(name = "MEASURE")
    Measure measure;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCTGRUPPA")
    ProductGruppa productgruppa;
    
    @Column(name = "KOEF")
    BigDecimal koef;
    
    @Column(name = "VID")
    Integer vid;

    public ProductGruppa getProductgruppa() {
        return productgruppa;
    }

    public void setProductgruppa(ProductGruppa productgruppa) {
        this.productgruppa = productgruppa;
    }
    
    

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }

    @Override
    public String toString() {
        return getName();
    }
    
    

    public Product(Integer p) {
        product = p;
    }

    public Product() {
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
    
    

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
    
    
}