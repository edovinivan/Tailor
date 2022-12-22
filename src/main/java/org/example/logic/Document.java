/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
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
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "DOCUMENT")
public class Document implements Serializable {
    @Id
    @Column(name = "DOCUMENT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOCUMENT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOCUMENT_ID", sequenceName = "GEN_DOCUMENT_ID")
    Integer document;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "DEL")
    Integer del;    
    
    @Column(name = "STATUS")
    Integer status;    
    
    @Column(name = "VID")
    Integer vid;    
    
    @ManyToOne
    @JoinColumn(name = "AGENT")
    Agent agent;
    
    
    
    @Formula("coalesce((select count(kj.documentjournal) from documentjournal kj where kj.document = document and kj.del = 0),0)")          
    Integer counts;
    
               
    @Formula("coalesce((select sum(kj.price* (decode(vid,2,kj.width,kj.ves))) from documentjournal kj where kj.document = document and kj.del = 0),0)")          
    BigDecimal dsumma;
    
    @Formula("coalesce((select sum(kj.ves) from documentjournal kj where kj.document = document and kj.del = 0),0)")          
    BigDecimal dves;

    public BigDecimal getDsumma() {
        return dsumma;
    }

    public void setDsumma(BigDecimal dsumma) {
        this.dsumma = dsumma;
    }

    public BigDecimal getDves() {
        return dves;
    }

    public void setDves(BigDecimal dves) {
        this.dves = dves;
    }
    
    
        
    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
    
    

    public Integer getCounts() {
        return counts;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Document(Integer d) {
        document = d;
    }

    public Document() {
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    
    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
    
    
    
    
    
}
