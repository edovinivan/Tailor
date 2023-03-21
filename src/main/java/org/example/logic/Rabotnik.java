/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "RABOTNIK")
public class Rabotnik implements Serializable {
    @Id
    @Column(name = "RABOTNIK")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_RABOTNIK_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_RABOTNIK_ID", sequenceName = "GEN_RABOTNIK_ID")
    Integer rabotnik;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;
    
    @ManyToOne
    @JoinColumn(name = "RABOTNIKGRUPPA")
    RabotnikGruppa rabotnikgruppa;
    
    @Column(name = "KOEF")
    BigDecimal koef;
    
    @Column(name = "PRICE")
    BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    

    public Rabotnik(Integer r) {
        rabotnik = r;
    }

    public Rabotnik() {
    }

    public Integer getRabotnik() {
        return rabotnik;
    }

    public void setRabotnik(Integer rabotnik) {
        this.rabotnik = rabotnik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public RabotnikGruppa getRabotnikgruppa() {
        return rabotnikgruppa;
    }

    public void setRabotnikgruppa(RabotnikGruppa rabotnikgruppa) {
        this.rabotnikgruppa = rabotnikgruppa;
    }

    public BigDecimal getKoef() {
        return koef;
    }

    public void setKoef(BigDecimal koef) {
        this.koef = koef;
    }
    
    
    
    
    
    
}
