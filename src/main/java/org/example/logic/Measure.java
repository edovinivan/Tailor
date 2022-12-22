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
@Table(name = "MEASURE")
public class Measure implements Serializable {
    @Id
    @Column(name = "MEASURE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MEASURE_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MEASURE_ID", sequenceName = "GEN_MEASURE_ID")
    Integer measure;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del; 

    @Override
    public String toString() {
        return getName();
    }
    
    

    public Measure(Integer m) {
        measure = m;
    }

    public Measure() {
    }

    public Integer getMeasure() {
        return measure;
    }

    public void setMeasure(Integer measure) {
        this.measure = measure;
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
