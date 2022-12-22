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
@Table(name = "VIEWSP")
public class ViewSP implements Serializable {
    @Id
    @Column(name = "DJ")    
    Integer dj;
    
    @Column(name = "PASSPORT")    
    String passport;
    
    @Column(name = "PRODUCTNAME")    
    String productname;
    
    @Column(name = "COLORNAME")    
    String colorname;
    
    @Column(name = "PRICE")    
    BigDecimal price;
    
    @Column(name = "WIDTH")    
    BigDecimal width;
    
    @Column(name = "LIGHT")    
    BigDecimal light;
    
    @Column(name = "VES")    
    BigDecimal ves;
    
    @Column(name = "SCLADNAME")    
    String scladname;
    
    @Column(name = "DATES")    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "AGENTNAME")    
    String agentname;
    
    @Column(name = "PRODUCT")    
    Integer product;
    
    @Column(name = "SCLADPRODUCT")    
    Integer scladproduct;
    
    @Column(name = "TEXTCOMMENT")    
    String textcomment;
    
    @Column(name = "COLOR")    
    Integer color;
    
    @Column(name = "AGENT")    
    Integer agent;
    
    @Column(name = "SCLAD")    
    Integer sclad;
    
    @Column(name = "STATUS")    
    Integer status;
    
    @Column(name = "VID")    
    Integer vid;

    public ViewSP() {
    }

    public Integer getDj() {
        return dj;
    }

    public void setDj(Integer dj) {
        this.dj = dj;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getLight() {
        return light;
    }

    public void setLight(BigDecimal light) {
        this.light = light;
    }

   

    public BigDecimal getVes() {
        return ves;
    }

    public void setVes(BigDecimal ves) {
        this.ves = ves;
    }

    public String getScladname() {
        return scladname;
    }

    public void setScladname(String scladname) {
        this.scladname = scladname;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(Integer scladproduct) {
        this.scladproduct = scladproduct;
    }

    public String getTextcomment() {
        return textcomment;
    }

    public void setTextcomment(String textcomment) {
        this.textcomment = textcomment;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public Integer getSclad() {
        return sclad;
    }

    public void setSclad(Integer sclad) {
        this.sclad = sclad;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
    
    
    
    
   
    
}
