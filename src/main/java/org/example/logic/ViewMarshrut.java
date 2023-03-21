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
@Table(name = "VIEWMARSHRUT")
public class ViewMarshrut implements Serializable {
    @Id
    @Column(name = "ZK")    
    Integer zk;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "DATASEND")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datasend;
    
    @Column(name = "CHEXNAME")
    String chexname;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "DATAGET")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataget;
    
    @Column(name = "DATAEND")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataend;
    
    @Column(name = "DATARETURN")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datareturn;
    
    @Column(name = "QTYSDAL")
    Integer qtysdal;
    
    @Column(name = "BRAK")
    Integer brak;
    
    @Column(name = "CSALE")
    Integer csale;
    
    @Column(name = "BRAK1")
    Integer brak1;
    
    @Column(name = "DPROS")
    Integer dpros;
    
    @Column(name = "QTYSCLAD")
    Integer qtysclad;
    
    @Column(name = "DATASCLAD")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datasclad;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "PRETENZIA")
    Integer pretenzia;
    
    @Column(name = "CHEX")
    Integer chex;
    
    @Column(name = "DTEXT")
    String dtext;

    public String getDtext() {
        return dtext;
    }

    public void setDtext(String dtext) {
        this.dtext = dtext;
    }
    
    

    public String getChexname() {
        return chexname;
    }

    public void setChexname(String chexname) {
        this.chexname = chexname;
    }

    public Integer getChex() {
        return chex;
    }

    public void setChex(Integer chex) {
        this.chex = chex;
    }
    
    

    public ViewMarshrut(Integer z) {
        zk = z;
    }

    public ViewMarshrut() {
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

    public Date getDatasend() {
        return datasend;
    }

    public void setDatasend(Date datasend) {
        this.datasend = datasend;
    }

    

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getDataget() {
        return dataget;
    }

    public void setDataget(Date dataget) {
        this.dataget = dataget;
    }

    public Date getDataend() {
        return dataend;
    }

    public void setDataend(Date dataend) {
        this.dataend = dataend;
    }

    public Date getDatareturn() {
        return datareturn;
    }

    public void setDatareturn(Date datareturn) {
        this.datareturn = datareturn;
    }

    public Integer getQtysdal() {
        return qtysdal;
    }

    public void setQtysdal(Integer qtysdal) {
        this.qtysdal = qtysdal;
    }

    public Integer getBrak() {
        return brak;
    }

    public void setBrak(Integer brak) {
        this.brak = brak;
    }

    public Integer getCsale() {
        return csale;
    }

    public void setCsale(Integer csale) {
        this.csale = csale;
    }

    public Integer getBrak1() {
        return brak1;
    }

    public void setBrak1(Integer brak1) {
        this.brak1 = brak1;
    }

    public Integer getDpros() {
        return dpros;
    }

    public void setDpros(Integer dpros) {
        this.dpros = dpros;
    }

    public Integer getQtysclad() {
        return qtysclad;
    }

    public void setQtysclad(Integer qtysclad) {
        this.qtysclad = qtysclad;
    }

    public Date getDatasclad() {
        return datasclad;
    }

    public void setDatasclad(Date datasclad) {
        this.datasclad = datasclad;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Integer getPretenzia() {
        return pretenzia;
    }

    public void setPretenzia(Integer pretenzia) {
        this.pretenzia = pretenzia;
    }
    
    
    
    
    
    
    
}
