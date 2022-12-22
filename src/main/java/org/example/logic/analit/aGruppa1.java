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
@Table(name = "A_GRUPPA1")
public class aGruppa1 implements Serializable {
    @Id
    @Column(name = "A_GRUPPA1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_GRUPPA1_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_GRUPPA1_ID", sequenceName = "GEN_A_GRUPPA1_ID")
    Integer a_gruppa1;
    
    @Column(name = "NAME")
    String name;

    @Override
    public String toString() {
        return getName();
    }
    
    

    public aGruppa1(Integer a) {
        a_gruppa1 = a;
    }

    public aGruppa1() {
    }

    public Integer getA_gruppa1() {
        return a_gruppa1;
    }

    public void setA_gruppa1(Integer a_gruppa1) {
        this.a_gruppa1 = a_gruppa1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
    
}
