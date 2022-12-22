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
@Table(name = "LMODEL")
public class LModel1 implements Serializable {
    @Id
    @Column(name = "MODEL")
    Integer model;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "TIPMODEL")
    String Tipmodel;
    
    @Column(name = "COUCOM")
    Integer coucom;
    
    @Column(name = "CHEX")
    String chex;
    
    @Column(name = "HARTICLE")
    String harticle;

    public String getHarticle() {
        return harticle;
    }

    public void setHarticle(String harticle) {
        this.harticle = harticle;
    }

    public String getChex() {
        return chex;
    }

    public void setChex(String chex) {
        this.chex = chex;
    }     

    public Integer getCoucom() {
        return coucom;
    }

    public void setCoucom(Integer coucom) {
        this.coucom = coucom;
    }
    
    

    public LModel1() {
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
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
        
    public String getArticleForNoSlash() {
        return article.replace("/", "").replace("-", "").replace(" ", "");
    }
    
    

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getTipmodel() {
        return Tipmodel;
    }

    public void setTipmodel(String Tipmodel) {
        this.Tipmodel = Tipmodel;
    }
    
    
}
