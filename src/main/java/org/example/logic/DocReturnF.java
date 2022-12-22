/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "DOC_RETURNF")
public class DocReturnF implements Serializable {
    @Id
    @Column(name = "DOC_RETURNF")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOC_RETURNF_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOC_RETURNF_ID", sequenceName = "GEN_DOC_RETURNF_ID")
    Integer docreturnf;
    
    @ManyToOne
    @JoinColumn(name = "AGENT")
    Agent agent;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "STATUS")
    Integer status;

    public DocReturnF(Integer d) {
        docreturnf = d;
    }

    public DocReturnF() {
    }

    public Integer getDocreturnf() {
        return docreturnf;
    }

    public void setDocreturnf(Integer docreturnf) {
        this.docreturnf = docreturnf;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
}
