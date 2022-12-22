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
@Table(name = "LASTTEXT")
public class LastText implements Serializable {
    @Id
    @Column(name = "LASTTEXT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_LASTTEXT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_LASTTEXT_ID", sequenceName = "GEN_LASTTEXT_ID")
    Integer lasttext;
    
    @Column(name = "TEXT")
    String text;

    public LastText(Integer l) {
        lasttext = l;
    }

    public LastText() {
    }

    public Integer getLasttext() {
        return lasttext;
    }

    public void setLasttext(Integer lasttext) {
        this.lasttext = lasttext;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
    
}
