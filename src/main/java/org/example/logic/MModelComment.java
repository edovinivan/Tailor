/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "M_MODELCOMMENT")
public class MModelComment implements Serializable {    
    @Id
    @Column(name = "M_MODELCOMMENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_M_MODELCOMMENT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_M_MODELCOMMENT_ID", sequenceName = "GEN_M_MODELCOMMENT_ID")
    Integer mmodelcomment;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date dates;
    
    @Column(name = "DATES1")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date dates1;
    
    @Column(name = "TEXTS")
    String texts;
    
    @Column(name = "ANSVER")
    String ansver;
    
    @Column(name = "AVTOR1")
    String avtor1;
    
    @Column(name = "AVTOR2")
    String avtor2;

    public Date getDates1() {
        return dates1;
    }

    public void setDates1(Date dates1) {
        this.dates1 = dates1;
    }

    public String getAnsver() {
        return ansver;
    }

    public void setAnsver(String ansver) {
        this.ansver = ansver;
    }

    public String getAvtor1() {
        return avtor1;
    }

    public void setAvtor1(String avtor1) {
        this.avtor1 = avtor1;
    }

    public String getAvtor2() {
        return avtor2;
    }

    public void setAvtor2(String avtor2) {
        this.avtor2 = avtor2;
    }
    
    

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    

    public MModelComment(Integer mc) {
        mmodelcomment = mc;
    }

    public MModelComment() {
    }

    public Integer getMmodelcomment() {
        return mmodelcomment;
    }

    public void setMmodelcomment(Integer mmodelcomment) {
        this.mmodelcomment = mmodelcomment;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }
    
    
     
    
}
