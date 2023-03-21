/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.example.logic.analit.aRazmer;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "RAZMERI")
public class Razmeri implements Serializable {
    @Id
    @Column(name = "RAZMERI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_RAZMERI_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_RAZMERI_ID", sequenceName = "GEN_RAZMERI_ID")
    Integer razmeri;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;
    
    @ManyToOne
    @JoinColumn(name = "RAZMERIGRUPPA")
    RazmeriGruppa razmerigruppa;
    
    @Column(name = "NOM")
    Integer nom;
    
    @ManyToOne
    @JoinColumn(name = "A_RAZMER")
    aRazmer arazmer;

    public aRazmer getArazmer() {
        return arazmer;
    }

    public void setArazmer(aRazmer arazmer) {
        this.arazmer = arazmer;
    }
    
    

    @Override
    public String toString() {
        return getName();
    }
    
    

    public Razmeri(Integer r) {
        razmeri = r;
    }

    public Razmeri() {
    }

    public Integer getRazmeri() {
        return razmeri;
    }

    public void setRazmeri(Integer razmeri) {
        this.razmeri = razmeri;
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

    public RazmeriGruppa getRazmerigruppa() {
        return razmerigruppa;
    }

    public void setRazmerigruppa(RazmeriGruppa razmerigruppa) {
        this.razmerigruppa = razmerigruppa;
    }

    public Integer getNom() {
        return nom;
    }

    public void setNom(Integer nom) {
        this.nom = nom;
    }
    
    
    
    
    
}
