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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "RABOTNIKOPERATION")
public class RabotnikOperation implements Serializable {
    @Id
    @Column(name = "RABOTNIKOPERATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_RABOTNIKOPERATION_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_RABOTNIKOPERATION_ID", sequenceName = "GEN_RABOTNIKOPERATION_ID")
    Integer rabotnikoperation;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHAKOMPLEKTOVKA")
    ZadachaKomplektovka zadachakomplektovka;
    
        
    @ManyToOne
    @JoinColumn(name = "RABOTNIK")
    Rabotnik rabotnik;
    
    @ManyToOne
    @JoinColumn(name = "OPERATION")
    Operation operation;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "TIMES")
    Integer times;
    
    @Column(name = "STATUS")
    Integer status;
          
    @Column(name = "PRICEO")
    BigDecimal priceo;
    
    @Column(name = "TIMEO")
    BigDecimal timeo;
    
    @Column(name = "SUMMAALL")
    BigDecimal summaall;
    
    @Column(name = "PRICER")
    BigDecimal pricer;
    
    @Column(name = "TEXT")
    String text;
    
    @Column(name = "CHEX")
    Integer chex;

    public Integer getChex() {
        return chex;
    }

    public void setChex(Integer chex) {
        this.chex = chex;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

    public BigDecimal getPricer() {
        return pricer;
    }

    public void setPricer(BigDecimal pricer) {
        this.pricer = pricer;
    }
    
    

    public Rabotnik getRabotnik() {
        return rabotnik;
    }

    public void setRabotnik(Rabotnik rabotnik) {
        this.rabotnik = rabotnik;
    }
    
    

    public BigDecimal getSummaall() {
        return summaall;
    }

    public void setSummaall(BigDecimal summaall) {
        this.summaall = summaall;
    }
    
    public RabotnikOperation(Integer r) {
        rabotnikoperation = r;
    }
    
    public RabotnikOperation() {
    }

    public Integer getRabotnikoperation() {
        return rabotnikoperation;
    }

    public void setRabotnikoperation(Integer rabotnikoperation) {
        this.rabotnikoperation = rabotnikoperation;
    }

    public ZadachaKomplektovka getZadachakomplektovka() {
        return zadachakomplektovka;
    }

    public void setZadachakomplektovka(ZadachaKomplektovka zadachakomplektovka) {
        this.zadachakomplektovka = zadachakomplektovka;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public BigDecimal getPriceo() {
        return priceo;
    }

    public void setPriceo(BigDecimal priceo) {
        this.priceo = priceo;
    }

    public BigDecimal getTimeo() {
        return timeo;
    }

    public void setTimeo(BigDecimal timeo) {
        this.timeo = timeo;
    }

   
    
}
