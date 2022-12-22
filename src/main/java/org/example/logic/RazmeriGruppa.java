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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "RAZMERIGRUPPA")
public class RazmeriGruppa implements Serializable {
    @Id
    @Column(name = "RAZMERIGRUPPA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_RAZMERIGRUPPA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_RAZMERIGRUPPA_ID", sequenceName = "GEN_RAZMERIGRUPPA_ID")
    Integer razmerigruppa;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    @Override
    public String toString() {
        return getName();
    }
    
    

    public RazmeriGruppa(Integer r) {
        razmerigruppa = r;
    }

    public RazmeriGruppa() {
    }

    public Integer getRazmerigruppa() {
        return razmerigruppa;
    }

    public void setRazmerigruppa(Integer razmerigruppa) {
        this.razmerigruppa = razmerigruppa;
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
    
    
    
}
