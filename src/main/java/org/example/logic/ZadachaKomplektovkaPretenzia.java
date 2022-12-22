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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ZKPRETENZIA")
public class ZadachaKomplektovkaPretenzia implements Serializable {
    @Id
    @Column(name = "ZKPRETENZIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZKPRETENZIA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZKPRETENZIA_ID", sequenceName = "GEN_ZKPRETENZIA_ID")
    Integer zkpretenzia;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHAKOMPLEKTOVKA")
    ZadachaKomplektovka zadachakomplektovka;
    
    @Column(name = "DATE1")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date date1;
    
    @Column(name = "DATE2")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date date2;
    
    @Column(name = "DATE3")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date date3;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "QTYSCLAD")
    Integer scladqty;
    
    @Column(name = "DATEGET")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateget;
    
    @Column(name = "DATERETURN")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datereturn;
    
    @Column(name = "DATESCLAD")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datesclad;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Formula("coalesce((select sum(z.qty) from ZKPRETENZIARAZMER z where z.ZKPRETENZIA = zkpretenzia),0)")
    Integer counts;

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
    
    

    public Integer getScladqty() {
        return scladqty;
    }

    public void setScladqty(Integer scladqty) {
        this.scladqty = scladqty;
    }
    
    

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getDateget() {
        return dateget;
    }

    public void setDateget(Date dateget) {
        this.dateget = dateget;
    }

    public Date getDatereturn() {
        return datereturn;
    }

    public void setDatereturn(Date datereturn) {
        this.datereturn = datereturn;
    }

    public Date getDatesclad() {
        return datesclad;
    }

    public void setDatesclad(Date datesclad) {
        this.datesclad = datesclad;
    }
    
    

    public ZadachaKomplektovkaPretenzia(Integer p) {
        zkpretenzia = p;
    }

    public ZadachaKomplektovkaPretenzia() {
    }

    public Integer getZkpretenzia() {
        return zkpretenzia;
    }

    public void setZkpretenzia(Integer zkpretenzia) {
        this.zkpretenzia = zkpretenzia;
    }

    public ZadachaKomplektovka getZadachakomplektovka() {
        return zadachakomplektovka;
    }

    public void setZadachakomplektovka(ZadachaKomplektovka zadachakomplektovka) {
        this.zadachakomplektovka = zadachakomplektovka;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

   

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
    
    
    
}
