/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "MODELOPERATION")
public class ModelOperation implements Serializable {
    @Id
    @Column(name = "MODELOPERATION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MODELOPERATION_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MODELOPERATION_ID", sequenceName = "GEN_MODELOPERATION_ID")
    Integer modeloperation;
    
    /*@ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;*/
    @Column(name = "MODEL")
    Integer model;
    
    @ManyToOne
    @JoinColumn(name = "OPERATION")
    Operation operation;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "NOM")
    Integer nom;
    
    @Column(name = "TEXT")
    String text;
          
    @Column(name = "TIMES")
    BigDecimal times;
    
    @Column(name = "RABOTNIK")
    String rabotnik;
    
    @ManyToOne
    @JoinColumn(name = "RAZRAD")
    Razrad razrad;
    
    @Formula("coalesce((select (mo.times*mo.qty*r.summa/3600) from modeloperation mo inner join razrad r on r.razrad = mo.razrad where mo.modeloperation = modeloperation),0)")
    BigDecimal summao;

    public BigDecimal getSummao() {
        return summao;
    }

    public void setSummao(BigDecimal summao) {
        this.summao = summao;
    }  
    

    public Integer getNom() {
        return nom;
    }

    public void setNom(Integer nom) {
        this.nom = nom;
    }   

    public ModelOperation(Integer mo) {
        modeloperation = mo;
    }

    public ModelOperation() {
    }

    public Integer getModeloperation() {
        return modeloperation;
    }

    public void setModeloperation(Integer modeloperation) {
        this.modeloperation = modeloperation;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getTimes() {
        return times;
    }

    public void setTimes(BigDecimal times) {
        this.times = times;
    }

        

    public String getRabotnik() {
        return rabotnik;
    }

    public void setRabotnik(String rabotnik) {
        this.rabotnik = rabotnik;
    }

    public Razrad getRazrad() {
        return razrad;
    }

    public void setRazrad(Razrad razrad) {
        this.razrad = razrad;
    }
    
    
    
    
    
}
