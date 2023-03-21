/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

import java.io.Serializable;
import java.time.LocalDate;
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

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "MAPPROJECTMONTJOURNAL")
public class MapProjectMontJournal implements Serializable{
    
    @Id
    @Column(name = "MAPPROJECTMONTJOURNAL")
    @GeneratedValue(generator = "GET_MAPPROJECTMONTJOURNAL_ID", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(allocationSize = 1, name = "GET_MAPPROJECTMONTJOURNAL_ID", sequenceName = "GET_MAPPROJECTMONTJOURNAL_ID")
    Integer mapprojectmontjournal;
    
    @JoinColumn(name = "MAPPROJECTMONT")
    @ManyToOne
    MapProjectMont mapProjectMont;
    
    @Column(name = "QTY")
    Integer qty;
    
    @JoinColumn(name = "COLOR")
    @ManyToOne
    Color color;
    
    @Column(name = "DATES")
    //@Temporal(TemporalType.DATE)
    LocalDate dates;
    
    @JoinColumn(name = "MODEL")
    @ManyToOne
    Model model;

    public MapProjectMontJournal(Integer mapprojectmontjournal) {
        this.mapprojectmontjournal = mapprojectmontjournal;
    }

    public MapProjectMontJournal() {
    }

    public Integer getMapprojectmontjournal() {
        return mapprojectmontjournal;
    }

    public void setMapprojectmontjournal(Integer mapprojectmontjournal) {
        this.mapprojectmontjournal = mapprojectmontjournal;
    }

    public MapProjectMont getMapProjectMont() {
        return mapProjectMont;
    }

    public void setMapProjectMont(MapProjectMont mapProjectMont) {
        this.mapProjectMont = mapProjectMont;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getDates() {
        return dates;
    }

    public void setDates(LocalDate dates) {
        this.dates = dates;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    
    
    
    
    
    
}
