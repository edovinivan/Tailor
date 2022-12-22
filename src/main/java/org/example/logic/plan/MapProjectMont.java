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

/**
 *
 * @author ivan
 */
@Entity        
@Table(name = "MAPPROJECTMONT")
public class MapProjectMont implements Serializable {
    @Id
    @Column(name = "MAPPROJECTMONT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MAPPROJECTMONT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MAPPROJECTMONT_ID", sequenceName = "GEN_MAPPROJECTMONT_ID")
    Integer mapprojectmont;
    
    @Column(name = "MONT")
    Integer mont;    
    
    @Column(name = "YAR")
    Integer yar;
    
    @ManyToOne
    @JoinColumn(name = "MAPPROJECT")
    MapProject mapproject;
    
    @Column(name = "NAME")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public MapProject getMapproject() {
        return mapproject;
    }

    public void setMapproject(MapProject mapproject) {
        this.mapproject = mapproject;
    }
    
    

    public MapProjectMont(Integer mapprojectmont) {
        this.mapprojectmont = mapprojectmont;
    }

    public MapProjectMont() {
    }

    public Integer getMapprojectmont() {
        return mapprojectmont;
    }

    public void setMapprojectmont(Integer mapprojectmont) {
        this.mapprojectmont = mapprojectmont;
    }

    public Integer getMont() {
        return mont;
    }

    public void setMont(Integer mont) {
        this.mont = mont;
    }

    public Integer getYar() {
        return yar;
    }

    public void setYar(Integer yar) {
        this.yar = yar;
    }
    
    
    
}
