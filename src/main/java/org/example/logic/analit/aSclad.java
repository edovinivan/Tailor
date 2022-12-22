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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "A_SCLAD")
public class aSclad implements Serializable {
    @Id
    @Column(name = "A_SCLAD")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_SCLAD_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_SCLAD_ID", sequenceName = "GEN_A_SCLAD_ID")
    Integer a_sclad;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "UID")
    String uid;
    
    @Column(name = "IO")
    Integer io;

    public Integer getIo() {
        return io;
    }

    public void setIo(Integer io) {
        this.io = io;
    }
    
    

    public aSclad() {
    }

    public Integer getA_sclad() {
        return a_sclad;
    }

    public void setA_sclad(Integer a_sclad) {
        this.a_sclad = a_sclad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    
    
    
}
