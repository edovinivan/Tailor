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
@Table(name = "MODELFILES")
public class ModelFiles implements Serializable {    
    @Id
    @Column(name = "MODELFILES")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MODELFILES_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MODELFILES_ID", sequenceName = "GEN_MODELFILES_ID")
    Integer modelfiles;
    
    @ManyToOne
    @JoinColumn(name = "FILES")
    Files files;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @Column(name = "HAUPT")
    Integer haupt;

    public ModelFiles(Integer mf) {
        modelfiles = mf;
    }

    public ModelFiles() {
    }

    public Integer getModelfiles() {
        return modelfiles;
    }

    public void setModelfiles(Integer modelfiles) {
        this.modelfiles = modelfiles;
    }

    public Files getFiles() {
        return files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getHaupt() {
        return haupt;
    }

    public void setHaupt(Integer haupt) {
        this.haupt = haupt;
    }
    
    
    
    
    
}
