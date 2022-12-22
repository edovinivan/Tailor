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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "RAZRAD")
public class Razrad implements Serializable {
    @Id
    @Column(name = "RAZRAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_RAZRAD_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_RAZRAD_ID", sequenceName = "GEN_RAZRAD_ID")
    Integer razrad;
    
    @Column(name = "NUM")
    String nom;
    
    @Column(name = "DEL")
    Integer del;
    
    @Column(name = "SUMMA")
    BigDecimal summa;

    public Razrad(Integer r) {
        razrad = r;
    }

    public Razrad() {
    }

    public Integer getRazrad() {
        return razrad;
    }

    public void setRazrad(Integer razrad) {
        this.razrad = razrad;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }
    
}
