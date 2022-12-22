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
import org.example.logic.Color;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "A_COLOR")
public class aColor implements Serializable {
    
    @Id
    @Column(name = "A_COLOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_COLOR_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_COLOR_ID", sequenceName = "GEN_A_COLOR_ID")
    Integer a_color;
    
    @Column(name = "NAME")
    String name;
    
    @ManyToOne
    @JoinColumn(name = "ID_COLOR")
    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public aColor(Integer a) {
        a_color = a;
    }

    public aColor() {
    }

    public Integer getA_color() {
        return a_color;
    }

    public void setA_color(Integer a_color) {
        this.a_color = a_color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
}
