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
@Table(name = "AGENT")
public class Agent implements Serializable {
    @Id
    @Column(name = "AGENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_AGENT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_AGENT_ID", sequenceName = "GEN_AGENT_ID")
    Integer agent;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del; 
    
    @Column(name = "VID")
    Integer vid;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
    
    

    @Override    
    public String toString() {
        return getName();
    }
    
    

    public Agent(Integer a) {
        agent = a;
    }
    
    public Agent(Integer a, String n) {
        agent = a;
        name = n;
    }

    public Agent() {
    }

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
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
