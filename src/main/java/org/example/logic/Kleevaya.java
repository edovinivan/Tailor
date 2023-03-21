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
@Table(name = "KLEEVAYA")
public class Kleevaya implements Serializable {
    @Id
    @Column(name = "KLEEVAYA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_KLEEVAYA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_KLEEVAYA_ID", sequenceName = "GEN_KLEEVAYA_ID")
    Integer kleevaya;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    public Kleevaya(Integer k) {
        kleevaya = k;
    }
    
    public Kleevaya() {
    }

    public Integer getKleevaya() {
        return kleevaya;
    }

    public void setKleevaya(Integer kleevaya) {
        this.kleevaya = kleevaya;
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
