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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author edovin.ivan
 */
@Entity
@Table(name = "OPERATIONTEXTGRUPPA")
public class OperationTextGruppa implements Serializable{
    @Id
    @Column(name = "OPERATIONTEXTGRUPPA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERATIONTEXTGRUPPA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_OPERATIONTEXTGRUPPA_ID", sequenceName = "GEN_OPERATIONTEXTGRUPPA_ID")
    Integer operationtextgruppa;
     
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    public OperationTextGruppa() {
    }

    public OperationTextGruppa(Integer operationtextgruppa) {
        this.operationtextgruppa = operationtextgruppa;
    }

    public Integer getOperationtextgruppa() {
        return operationtextgruppa;
    }

    public void setOperationtextgruppa(Integer operationtextgruppa) {
        this.operationtextgruppa = operationtextgruppa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
    
    
    
}
