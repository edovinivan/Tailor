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
@Table(name = "LSZADACHA")
public class LSZadacha implements Serializable {
    @Id
    @Column(name = "ZADACHA")    
    Integer zadacha;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "COUNTS")
    Integer counts;
    
    @Column(name = "COUNTSALL")
    Integer countsall;
    
    @Column(name = "DATEENDMAX")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateendmax;
    
    @Column(name = "NETM")
    Integer netm;
    
    @Column(name = "HAND")
    Integer hand;
    
    @Column(name = "PMH")
    Integer pmh;
    
    @Column(name = "DEL")
    Integer del;

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
    
    

    public LSZadacha(Integer z) {
        zadacha = z;
    }

    public LSZadacha() {
    }

    public Integer getZadacha() {
        return zadacha;
    }

    public void setZadacha(Integer zadacha) {
        this.zadacha = zadacha;
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

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getCountsall() {
        return countsall;
    }

    public void setCountsall(Integer countsall) {
        this.countsall = countsall;
    }

    public Date getDateendmax() {
        return dateendmax;
    }

    public void setDateendmax(Date dateendmax) {
        this.dateendmax = dateendmax;
    }

    public Integer getNetm() {
        return netm;
    }

    public void setNetm(Integer netm) {
        this.netm = netm;
    }

    public Integer getHand() {
        return hand;
    }

    public void setHand(Integer hand) {
        this.hand = hand;
    }

    

    public Integer getPmh() {
        return pmh;
    }

    public void setPmh(Integer pmh) {
        this.pmh = pmh;
    }
    
    
    
    
    
}
