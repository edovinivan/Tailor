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
@Table(name = "SCLAD")
public class Sclad implements Serializable {
    @Id
    @Column(name = "SCLAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SCLAD_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_SCLAD_ID", sequenceName = "GEN_SCLAD_ID")
    Integer sclad;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    @Override
    public String toString() {
        return getName();
    }

    public Sclad(Integer s) {
        sclad = s;
    }

    public Sclad() {
    }

    public Integer getSclad() {
        return sclad;
    }

    public void setSclad(Integer sclad) {
        this.sclad = sclad;
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
