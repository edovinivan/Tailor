/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

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
import org.example.logic.Model;
import org.example.logic.Razmeri;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "MAPEXCEPTIONAPTICLE")
public class MapExceptionArticle implements Serializable{
    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MAPEXCEPTIONAPTICLE_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MAPEXCEPTIONAPTICLE_ID", sequenceName = "GEN_MAPEXCEPTIONAPTICLE_ID")
    @Column(name = "MAPEXCEPTIONAPTICLE")
    Integer mapexceptionarticle;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
    
    @ManyToOne
    @JoinColumn(name = "RAZMERI")
    Razmeri razmeri;
    
    @Column(name = "MAPJOINSTRING1C")
    String mapjoinstring1c;

    public MapExceptionArticle() {
    }

    public MapExceptionArticle(int i) {
        mapexceptionarticle = i;
    }

    public Integer getMapexceptionarticle() {
        return mapexceptionarticle;
    }

    public void setMapexceptionarticle(Integer mapexceptionarticle) {
        this.mapexceptionarticle = mapexceptionarticle;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Razmeri getRazmeri() {
        return razmeri;
    }

    public void setRazmeri(Razmeri razmeri) {
        this.razmeri = razmeri;
    }

    public String getMapjoinstring1c() {
        return mapjoinstring1c;
    }

    public void setMapjoinstring1c(String mapjoinstring1c) {
        this.mapjoinstring1c = mapjoinstring1c;
    }
    
        
    
}
