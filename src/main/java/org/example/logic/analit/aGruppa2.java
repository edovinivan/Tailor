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
@Table(name = "A_GRUPPA2")
public class aGruppa2 implements Serializable {
    @Id
    @Column(name = "A_GRUPPA2")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_GRUPPA2_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_GRUPPA2_ID", sequenceName = "GEN_A_GRUPPA2_ID")
    Integer a_gruppa2;
    
    @Column(name = "NAME")
    String name;

    @Override
    public String toString() {
        return getName();
    }
    
    

    public aGruppa2(Integer a) {
        a_gruppa2 = a;
    }

    public aGruppa2() {
    }

    public Integer getA_gruppa2() {
        return a_gruppa2;
    }

    public void setA_gruppa2(Integer a_gruppa2) {
        this.a_gruppa2 = a_gruppa2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    
}
