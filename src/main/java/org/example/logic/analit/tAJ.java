/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.analit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "TAJ")
public class tAJ implements Serializable {
    @Id
    @Column(name = "TAJ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_TAJ_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_TAJ_ID", sequenceName = "GEN_TAJ_ID")
    Integer taj;
    
    @Column(name = "ID")
    String id;
    
    @Column(name = "GRUPPA1")
    String gruppa1;
    
    @Column(name = "GRUPPA2")
    String gruppa2;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "ANAME")
    String aname;
    
    @Column(name = "COLOR")
    String color;
    
    @Column(name = "RAZMER")
    String razmer;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "PRICE")
    BigDecimal price;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "ID_GRUPPA1")
    Integer id_gruppa1;
            
    @Column(name = "ID_GRUPPA2")
    Integer id_gruppa2;
    
    @Column(name = "ID_ARTICLE")
    Integer id_article;
    
    @Column(name = "ID_COLOR")
    Integer id_color;
    
    @Column(name = "ID_RAZMER")
    Integer id_razmer;
    
    @Column(name = "OPERATIONS")
    String operations;
    
    @Column(name = "SCLAD")
    String sclad;
    
    @Column(name = "SCLADUID")
    String scladuid;
    
    @Column(name = "SCLADID")
    Integer scladId;
    
    @Column(name = "OPERATIONID")
    Integer operationId;
    
    @Column(name = "AGENT")
    String agent;
    
    @Column(name = "AGENTUID")
    String agentuid;
    
    @Column(name = "AGENTID")
    Integer agentid;

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgentuid() {
        return agentuid;
    }

    public void setAgentuid(String agentuid) {
        this.agentuid = agentuid;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }
    
    
        

    public Integer getScladId() {
        return scladId;
    }

    public void setScladId(Integer scladId) {
        this.scladId = scladId;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }
    
    

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getSclad() {
        return sclad;
    }

    public void setSclad(String sclad) {
        this.sclad = sclad;
    }

    public String getScladuid() {
        return scladuid;
    }

    public void setScladuid(String scladuid) {
        this.scladuid = scladuid;
    }
    
    

    public tAJ(Integer t) {
        taj = t;
    }

    public tAJ() {
    }

    public Integer getTaj() {
        return taj;
    }

    public void setTaj(Integer taj) {
        this.taj = taj;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGruppa1() {
        return gruppa1;
    }

    public void setGruppa1(String gruppa1) {
        this.gruppa1 = gruppa1;
    }

    public String getGruppa2() {
        return gruppa2;
    }

    public void setGruppa2(String gruppa2) {
        this.gruppa2 = gruppa2;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRazmer() {
        return razmer;
    }

    public void setRazmer(String razmer) {
        this.razmer = razmer;
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

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Integer getId_gruppa1() {
        return id_gruppa1;
    }

    public void setId_gruppa1(Integer id_gruppa1) {
        this.id_gruppa1 = id_gruppa1;
    }

    public Integer getId_gruppa2() {
        return id_gruppa2;
    }

    public void setId_gruppa2(Integer id_gruppa2) {
        this.id_gruppa2 = id_gruppa2;
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public Integer getId_color() {
        return id_color;
    }

    public void setId_color(Integer id_color) {
        this.id_color = id_color;
    }

    public Integer getId_razmer() {
        return id_razmer;
    }

    public void setId_razmer(Integer id_razmer) {
        this.id_razmer = id_razmer;
    }
    
    

    
}
