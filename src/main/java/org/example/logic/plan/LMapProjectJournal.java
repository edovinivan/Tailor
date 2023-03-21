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
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "LMAPPROJECTJOURNAL")

public class LMapProjectJournal implements Serializable, Comparable<LMapProjectJournal>{
    @Id
    @Column(name = "ID", nullable = false)
    Integer id;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "COLOR")
    String color;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "DATES")
    @Temporal(TemporalType.DATE)
    Date dates;
    
    @Column(name = "MAPPROJECT")
    Integer mapproject;
    
    @Column(name = "COLORID")
    Integer colorid;
    
    @Column(name = "MODELID")
    Integer modelid;
    
    @Column(name = "RAZMERIID")
    Integer razmeriid;
    
    @Column(name = "RAZMERINAME")
    String razmeriname;
    
    @Column(name = "SALE")
    Integer sale;
    
    @Column(name = "INWORK")
    Integer inwork;
    
    @Column(name = "BALANCE")
    Integer balance;
    
    @Column(name = "SALEMONEY")
    Integer salemoney;

    public Integer getSalemoney() {
        return salemoney;
    }

    public void setSalemoney(Integer salemoney) {
        this.salemoney = salemoney;
    }
    
    

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getInwork() {
        return inwork;
    }

    public void setInwork(Integer inwork) {
        this.inwork = inwork;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    
    

    public Integer getRazmeriid() {
        return razmeriid;
    }

    public void setRazmeriid(Integer razmeriid) {
        this.razmeriid = razmeriid;
    }

    public String getRazmeriname() {
        return razmeriname;
    }

    public void setRazmeriname(String razmeriname) {
        this.razmeriname = razmeriname;
    }
    
    
    

    public LMapProjectJournal(Integer id) {
        this.id = id;
    }
    
    

    public Integer getColorid() {
        return colorid;
    }

    public void setColorid(Integer colorid) {
        this.colorid = colorid;
    }

    public Integer getModelid() {
        return modelid;
    }

    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }
    
    

    public LMapProjectJournal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

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

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Integer getMapproject() {
        return mapproject;
    }

    public void setMapproject(Integer mapproject) {
        this.mapproject = mapproject;
    }

    @Override
    public int compareTo(LMapProjectJournal o) {
        return o.getArticle().compareTo(getArticle());
    }
    
    
    
}
