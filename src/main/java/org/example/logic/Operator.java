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
@Table(name = "OPERATOR")
public class Operator implements Serializable {
    @Id
    @Column(name = "OPERATOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_OPERATOR_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_OPERATOR_ID", sequenceName = "GEN_OPERATOR_ID")
    Integer operator;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del; 
    
    @Column(name = "PASSWD")
    Integer passwd;
    
    @ManyToOne
    @JoinColumn(name = "RABOTNIK")
    Rabotnik rabotnik;
    
    @ManyToOne
    @JoinColumn(name = "RABOTNIKGRUPPA")
    RabotnikGruppa rabotnikgruppa;
    
    @Column(name = "NOCHEX")
    Integer nochex;

    public Integer getNochex() {
        return nochex;
    }

    public void setNochex(Integer nochex) {
        this.nochex = nochex;
    }
    
    

    public Operator(Integer o) {
        operator = o;
    }

    public Operator() {
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
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

    public Integer getPasswd() {
        return passwd;
    }

    public void setPasswd(Integer passwd) {
        this.passwd = passwd;
    }

    public Rabotnik getRabotnik() {
        return rabotnik;
    }

    public void setRabotnik(Rabotnik rabotnik) {
        this.rabotnik = rabotnik;
    }

    public RabotnikGruppa getRabotnikgruppa() {
        return rabotnikgruppa;
    }

    public void setRabotnikgruppa(RabotnikGruppa rabotnikgruppa) {
        this.rabotnikgruppa = rabotnikgruppa;
    }
    
    
    
    
}
