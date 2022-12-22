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
@Table(name = "COLOR")
public class Color implements Serializable {
    @Id
    @Column(name = "COLOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_COLOR_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_COLOR_ID", sequenceName = "GEN_COLOR_ID")
    Integer color;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;
    
    @Column(name = "VID")
    Integer vid;
    
    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
    
    

    @Override
    public String toString() {
        return getName();
    }
    
    

    public Color(Integer c) {
        color = c;
    }

    public Color() {
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
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
