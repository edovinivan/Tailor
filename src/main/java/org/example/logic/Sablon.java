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
@Table(name = "SABLON")
public class Sablon implements Serializable {
    @Id
    @Column(name = "SABLON")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SABLON_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_SABLON_ID", sequenceName = "GEN_SABLON_ID")
    Integer sablon;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    @Override
    public String toString() {
        return getName();
    }

    public Sablon(Integer s) {
        sablon = s;
    }

    public Sablon() {
    }

    public Integer getSablon() {
        return sablon;
    }

    public void setSablon(Integer sablon) {
        this.sablon = sablon;
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
