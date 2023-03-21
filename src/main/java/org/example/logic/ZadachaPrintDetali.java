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
@Table(name = "ZADACHAPRINTDETALI")
public class ZadachaPrintDetali implements Serializable {
    @Id
    @Column(name = "ZADACHAPRINTDETALI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHAPRINTDETALI_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHAPRINTDETALI_ID", sequenceName = "GEN_ZADACHAPRINTDETALI_ID")
    Integer zadachaprintdetali;

    @ManyToOne
    @JoinColumn(name = "PRINTDETALI")
    PrintDetali printdetali;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHA")
    Zadacha zadacha;

    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "PRICE")
    BigDecimal price;
    
    @Column(name = "VID")
    Integer vid;
    
    @Column(name = "QTYEND")
    Integer qtyend;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    

    public ZadachaPrintDetali() {
    }
    
    public ZadachaPrintDetali(Integer p) {
        zadachaprintdetali = p;
    }

    public Integer getZadachaprintdetali() {
        return zadachaprintdetali;
    }

    public void setZadachaprintdetali(Integer zadachaprintdetali) {
        this.zadachaprintdetali = zadachaprintdetali;
    }

    public PrintDetali getPrintdetali() {
        return printdetali;
    }

    public void setPrintdetali(PrintDetali printdetali) {
        this.printdetali = printdetali;
    }

    public Zadacha getZadacha() {
        return zadacha;
    }

    public void setZadacha(Zadacha zadacha) {
        this.zadacha = zadacha;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getQtyend() {
        return qtyend;
    }

    public void setQtyend(Integer qtyend) {
        this.qtyend = qtyend;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
            
    
}
