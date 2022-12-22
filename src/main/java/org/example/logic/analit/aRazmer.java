/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.analit;

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
import org.example.logic.Razmeri;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "A_RAZMER")
public class aRazmer implements Serializable {
    
    @Id
    @Column(name = "A_RAZMER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_RAZMER_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_RAZMER_ID", sequenceName = "GEN_A_RAZMER_ID")
    Integer a_razmer;
    
    @Column(name = "NAME")
    String name;
    
    @ManyToOne
    @JoinColumn(name = "RAZMER")
    Razmeri razmeri;

    public Razmeri getRazmeri() {
        return razmeri;
    }

    public void setRazmeri(Razmeri razmeri) {
        this.razmeri = razmeri;
    }
    
    

    public aRazmer(Integer a) {
        a_razmer = a;
    }

    public aRazmer() {
    }

    public Integer getA_razmer() {
        return a_razmer;
    }

    public void setA_razmer(Integer a_razmer) {
        this.a_razmer = a_razmer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
}
