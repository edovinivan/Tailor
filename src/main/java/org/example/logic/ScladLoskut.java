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
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "SCLADLOSKUT")
public class ScladLoskut implements Serializable {
    @Id
    @Column(name = "SCLADLOSKUT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SCLADLOSKUT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_SCLADLOSKUT_ID", sequenceName = "GEN_SCLADLOSKUT_ID")
    Integer scladloskut;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT")
    Product product;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHANASTIL")
    ZadachaNastil zadachanastil;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "OSTATOK")
    BigDecimal ostatok;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date dates;
    
    //@Formula("(select list(c.name) from zadachanastilproduct zp inner join scladloskut sl on sl.zadachanastil = zp.zadachanastil inner join zadachascladproduct zs on zs.zadachascladproduct = zp.zadachascladproduct inner join scladproduct sp on sp.scladproduct = zs.scladproduct inner join color c on c.color = sp.color where sl.scladloskut = 21 order by sp.ves desc)")          
    @Formula("(select cast(list(DISTINCT c.name) as varchar(250)) from zadachanastilproduct zp inner join scladloskut sl on sl.zadachanastil = zp.zadachanastil inner join zadachascladproduct zs on zs.zadachascladproduct = zp.zadachascladproduct inner join scladproduct sp on sp.scladproduct = zs.scladproduct inner join color c on c.color = sp.color where sl.scladloskut = scladloskut)")          
    String namecolor;

    public String getNamecolor() {
        return namecolor;
    }

    public void setNamecolor(String namecolor) {
        this.namecolor = namecolor;
    }
    
    

    public ScladLoskut(Integer s) {
        scladloskut = s;
    }

    public ScladLoskut() {
    }

    public Integer getScladloskut() {
        return scladloskut;
    }

    public void setScladloskut(Integer scladloskut) {
        this.scladloskut = scladloskut;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ZadachaNastil getZadachanastil() {
        return zadachanastil;
    }

    public void setZadachanastil(ZadachaNastil zadachanastil) {
        this.zadachanastil = zadachanastil;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getOstatok() {
        return ostatok;
    }

    public void setOstatok(BigDecimal ostatok) {
        this.ostatok = ostatok;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    
    
    
    
    
}
