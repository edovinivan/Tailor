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
@Table(name = "LRABOTNIKOPERATION")
public class LRabotnikOperation implements Serializable {
    @Id
    @Column(name = "ID")
    Integer id;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "RABOTNIK")
    String rabotnik;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "OPERATIONS")
    String operations;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "SUMMA")
    BigDecimal summa;
    
    @Column(name = "CHEX")
    Integer chex;
    
    @Column(name = "CHEXNAME")    
    String chexname;

    public LRabotnikOperation() {
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

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getRabotnik() {
        return rabotnik;
    }

    public void setRabotnik(String rabotnik) {
        this.rabotnik = rabotnik;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public Integer getChex() {
        return chex;
    }

    public void setChex(Integer chex) {
        this.chex = chex;
    }

    public String getChexname() {
        return chexname;
    }

    public void setChexname(String chexname) {
        this.chexname = chexname;
    }
    
    
}
