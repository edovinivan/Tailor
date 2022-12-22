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
@Table(name = "A_AGENT")
public class aAgent implements Serializable {
    @Id
    @Column(name = "A_AGENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_A_AGENT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_A_AGENT_ID", sequenceName = "GEN_A_AGENT_ID")
    Integer a_agent;
     
    @Column(name = "NAME")
    String name;
    
    @Column(name = "UID")
    String uid;

    public aAgent(Integer aa) {
        a_agent = aa;
    }

    public aAgent() {
    }

    public Integer getA_agent() {
        return a_agent;
    }

    public void setA_agent(Integer a_agent) {
        this.a_agent = a_agent;
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
