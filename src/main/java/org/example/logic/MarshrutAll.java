/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
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
@Table(name = "MARSHRUTALL")
public class MarshrutAll implements Serializable {
    @Id
    @Column(name = "ZK")    
    Integer zk;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "CHEX")
    Integer chex;

    public MarshrutAll(Integer s) {
        zk = s;
    }

    public MarshrutAll() {
    }

    public Integer getZk() {
        return zk;
    }

    public void setZk(Integer zk) {
        this.zk = zk;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Integer getChex() {
        return chex;
    }

    public void setChex(Integer chex) {
        this.chex = chex;
    }
    
    
    
    
        
}
