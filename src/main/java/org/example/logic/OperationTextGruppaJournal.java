/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author edovin.ivan
 */
@Entity
@Table(name = "OPERATIONTEXTGRUPPAJOURNAL")
public class OperationTextGruppaJournal implements Serializable{
    @Id
    @Column(name = "OPERATIONTEXTGRUPPAJOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERATIONTEXTGRUPPAJOU_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_OPERATIONTEXTGRUPPAJOU_ID", sequenceName = "GEN_OPERATIONTEXTGRUPPAJOU_ID")
    Integer operationtextgruppajournal;
    
    @ManyToOne
    @JoinColumn(name = "OPERATIONTEXTGRUPPA")
    OperationTextGruppa operationTextGruppa;
    
    @Column(name = "NOM")
    Integer nom;
    
    @Column(name = "TEXT")
    String text;

    public OperationTextGruppaJournal() {
    }

    public Integer getOperationtextgruppajournal() {
        return operationtextgruppajournal;
    }

    public void setOperationtextgruppajournal(Integer operationtextgruppajournal) {
        this.operationtextgruppajournal = operationtextgruppajournal;
    }

    public OperationTextGruppa getOperationTextGruppa() {
        return operationTextGruppa;
    }

    public void setOperationTextGruppa(OperationTextGruppa operationTextGruppa) {
        this.operationTextGruppa = operationTextGruppa;
    }

    public Integer getNom() {
        return nom;
    }

    public void setNom(Integer nom) {
        this.nom = nom;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
