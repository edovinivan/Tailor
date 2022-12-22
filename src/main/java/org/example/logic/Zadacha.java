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
import org.example.logic.plan.PModelPlanHaupt;
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ZADACHA")
public class Zadacha implements Serializable {
    @Id
    @Column(name = "ZADACHA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHA_ID", sequenceName = "GEN_ZADACHA_ID")
    Integer zadacha;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "DEL")
    Integer del;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "DATESTART")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datestart;
    
    @Column(name = "DATEEND")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateend;
    
    @Column(name = "DATESCLAD")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datesclad;
    
    @Column(name = "TEXT")
    String text;
    
    @Formula("coalesce((select count(zr.zadacharazmeri) from zadacharazmeri zr where zr.zadacha = zadacha and zr.qty>0),0)")
    Integer counts;
    
    @Formula("coalesce((select sum(zr.qty) from zadacharazmeri zr where zr.zadacha = zadacha),0)")
    Integer countsall;
    
    @Column(name = "KOEF")    
    BigDecimal koef;
    
    
    
    @Column(name = "DATEENDMAX")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateendmax;
    
    @Column(name = "NETM")
    Integer netm;
    
    @Column(name = "HAND")
    Integer hand;
    
    @ManyToOne
    @JoinColumn(name = "P_MODELPLANHAUPT")
    PModelPlanHaupt pmodelplanhaupt;

    public PModelPlanHaupt getPmodelplanhaupt() {
        return pmodelplanhaupt;
    }

    public void setPmodelplanhaupt(PModelPlanHaupt pmodelplanhaupt) {
        this.pmodelplanhaupt = pmodelplanhaupt;
    }
    
    
    

    public Integer getHand() {
        return hand;
    }

    public void setHand(Integer hand) {
        this.hand = hand;
    }
    
    

    public Date getDatesclad() {
        return datesclad;
    }

    public void setDatesclad(Date datesclad) {
        this.datesclad = datesclad;
    }
    
    

    public Integer getNetm() {
        return netm;
    }

    public void setNetm(Integer netm) {
        this.netm = netm;
    }
    
    

   
    

    public Date getDateendmax() {
        return dateendmax;
    }

    public void setDateendmax(Date dateendmax) {
        this.dateendmax = dateendmax;
    }
    
    
    

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }
    
    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    

    public Date getDatestart() {
        return datestart;
    }

    public void setDatestart(Date datestart) {
        this.datestart = datestart;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
        this.dateend = dateend;
    }
    
    

    public Integer getCountsall() {
        return countsall;
    }

    public void setCountsall(Integer countsall) {
        this.countsall = countsall;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
    
    

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
    
    

    public Zadacha(Integer z) {
        zadacha = z;
    }

    public Zadacha() {
    }

    public Integer getZadacha() {
        return zadacha;
    }

    public void setZadacha(Integer zadacha) {
        this.zadacha = zadacha;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    
    
    
    
}
