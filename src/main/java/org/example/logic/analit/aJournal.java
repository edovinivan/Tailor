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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "A_JOURNAL")
public class aJournal implements Serializable {
    
    @Id
    @Column(name = "A_JOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_JOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_JOURNAL_ID", sequenceName = "GEN_A_JOURNAL_ID")
    Integer a_journal;
    
    @ManyToOne
    @JoinColumn(name = "GRUPPA1")
    aGruppa1 agruppa1;
    
    @ManyToOne
    @JoinColumn(name = "GRUPPA2")
    aGruppa2 agruppa2;
    
    @ManyToOne
    @JoinColumn(name = "ARTICLE")
    aArticle aarticle;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")            
    aColor acolor;
    
    @ManyToOne
    @JoinColumn(name = "RAZMER")
    aRazmer arazmer;
    
    @Column(name = "ID")
    String id;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "PRICE")
    BigDecimal price;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @ManyToOne
    @JoinColumn(name = "OPERATIONS")
    aOperation operations;
    
    @ManyToOne
    @JoinColumn(name = "SCLAD")
    aSclad sclad;
    
    @Transient
    BigDecimal qty_ost;
    
    @ManyToOne
    @JoinColumn(name = "AGENT")
    aAgent agent;

    public aAgent getAgent() {
        return agent;
    }

    public void setAgent(aAgent agent) {
        this.agent = agent;
    }
    
    

    public BigDecimal getQty_ost() {
        return qty_ost;
    }

    public void setQty_ost(BigDecimal qty_ost) {
        this.qty_ost = qty_ost;
    }
        
    public aOperation getOperations() {
        return operations;
    }

    public void setOperations(aOperation operations) {
        this.operations = operations;
    }

    public aSclad getSclad() {
        return sclad;
    }

    public void setSclad(aSclad sclad) {
        this.sclad = sclad;
    }
    
    
    
    

    public aJournal(Integer a) {
        a_journal = a;
    }

    public aJournal() {
    }

    public Integer getA_journal() {
        return a_journal;
    }

    public void setA_journal(Integer a_journal) {
        this.a_journal = a_journal;
    }

    public aGruppa1 getAgruppa1() {
        return agruppa1;
    }

    public void setAgruppa1(aGruppa1 agruppa1) {
        this.agruppa1 = agruppa1;
    }

    public aGruppa2 getAgruppa2() {
        return agruppa2;
    }

    public void setAgruppa2(aGruppa2 agruppa2) {
        this.agruppa2 = agruppa2;
    }

    public aArticle getAarticle() {
        return aarticle;
    }

    public void setAarticle(aArticle aarticle) {
        this.aarticle = aarticle;
    }

    public aColor getAcolor() {
        return acolor;
    }

    public void setAcolor(aColor acolor) {
        this.acolor = acolor;
    }

    public aRazmer getArazmer() {
        return arazmer;
    }

    public void setArazmer(aRazmer arazmer) {
        this.arazmer = arazmer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    
    
    
    
}
