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
@Table(name = "LMAPPROJECTJOURNALGROUPTCOLOR")
public class LMapProjectJournalGrouptColor implements Serializable{
    @Id
    @Column(name = "ID")
    int id;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "COLOR")
    String color;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "MAPPROJECT")
    Integer mapproject;
    
    @Column(name = "SALE")
    Integer sale;
    
    @Column(name = "BALANCE")
    Integer balance;
    
    @Column(name = "INWORK")
    Integer inwork;
    
    @Column(name = "DATES")
    @Temporal(TemporalType.DATE)      
    Date dates;
    
    @Column(name = "SALEMONEY")
    Integer salemoney;

    public Integer getSalemoney() {
        return salemoney;
    }

    public void setSalemoney(Integer salemoney) {
        this.salemoney = salemoney;
    }
    
    

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getInwork() {
        return inwork;
    }

    public void setInwork(Integer inwork) {
        this.inwork = inwork;
    }
    
  
    

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    

    public LMapProjectJournalGrouptColor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getMapproject() {
        return mapproject;
    }

    public void setMapproject(Integer mapproject) {
        this.mapproject = mapproject;
    }

    @Override
    public String toString() {
        return "LMapProjectJournalGrouptColor{" + "id=" + id + ", article=" + article + ", color=" + color + ", qty=" + qty + ", mapproject=" + mapproject + ", sale=" + sale + ", balance=" + balance + ", inwork=" + inwork + ", dates=" + dates + '}';
    }
    
    
    
}
