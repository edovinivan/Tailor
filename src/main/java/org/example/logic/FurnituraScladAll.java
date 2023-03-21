/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

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
@Table(name = "FURNITURASCLADALL")
public class FurnituraScladAll {
    @Id
    @Column(name = "ID")    
    Integer id;
    
    @Column(name = "PASSPORT")
    String passport;
    
    @Column(name = "PRODUCT")
    String product;
    
    @Column(name = "COLOR")
    String color;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "PRICE")
    BigDecimal price;
    
    @Column(name = "SUMMA")
    BigDecimal summa;
    
    @Column(name = "SCLAD")
    String sclad;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "AGENT")
    String agent;

    public FurnituraScladAll() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public String getSclad() {
        return sclad;
    }

    public void setSclad(String sclad) {
        this.sclad = sclad;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }
    
    
    
    
}
