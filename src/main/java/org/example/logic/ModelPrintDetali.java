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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "MODELPRINTDETALI")
public class ModelPrintDetali implements Serializable {
    @Id
    @Column(name = "MODELPRINTDETALI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MODELPRINTDETALI_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MODELPRINTDETALI_ID", sequenceName = "GEN_MODELPRINTDETALI_ID")
    Integer modelprintdetali;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
            
    @ManyToOne
    @JoinColumn(name = "PRINTDETALI")
    PrintDetali printdetali;
    
    @Column(name = "VID")
    Integer vid;  
    


    public ModelPrintDetali(Integer mpd) {
        modelprintdetali = mpd;
    }

    public ModelPrintDetali() {
    }

    public Integer getModelprintdetali() {
        return modelprintdetali;
    }

    public void setModelprintdetali(Integer modelprintdetali) {
        this.modelprintdetali = modelprintdetali;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public PrintDetali getPrintdetali() {
        return printdetali;
    }

    public void setPrintdetali(PrintDetali printdetali) {
        this.printdetali = printdetali;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
    
    

    
    
}
