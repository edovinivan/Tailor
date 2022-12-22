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
@Table(name = "RABOTNIKGRUPPA")
public class RabotnikGruppa implements Serializable {
    @Id
    @Column(name = "RABOTNIKGRUPPA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_RABOTNIKGRUPPA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_RABOTNIKGRUPPA_ID", sequenceName = "GEN_RABOTNIKGRUPPA_ID")
    Integer rabotnikgruppa;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del; 
    
    @Column(name = "GRUPPA")
    Integer gruppa;

    public Integer getGruppa() {
        return gruppa;
    }

    public void setGruppa(Integer gruppa) {
        this.gruppa = gruppa;
    }
    
    

    @Override
    public String toString() {
        return getName();
    }
    
    

    public RabotnikGruppa(Integer r) {
        rabotnikgruppa = r;
    }

    public RabotnikGruppa() {
    }

    public Integer getRabotnikgruppa() {
        return rabotnikgruppa;
    }

    public void setRabotnikgruppa(Integer rabotnikgruppa) {
        this.rabotnikgruppa = rabotnikgruppa;
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
