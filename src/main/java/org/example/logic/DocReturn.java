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
@Table(name = "DOC_RETURN")
public class DocReturn implements Serializable {
    @Id
    @Column(name = "DOC_RETURN")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOC_RETURN_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOC_RETURN_ID", sequenceName = "GEN_DOC_RETURN_ID")
    Integer docreturn;
    
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
    
    @Formula("coalesce((select count(kj.doc_return_journal) from doc_return_journal kj where kj.doc_return = doc_return),0)")          
    Integer counts;
    
               
    @Formula("coalesce((select sum(sp.ves * sp.price) from doc_return_journal kj inner join scladproduct sp on sp.scladproduct = kj.scladproduct where kj.doc_return = doc_return ),0)")          
    BigDecimal dsumma;
    
    @Formula("coalesce((select sum(sp.ves) from doc_return_journal kj inner join scladproduct sp on sp.scladproduct = kj.scladproduct where kj.doc_return = doc_return ),0)")          
    BigDecimal dves;

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

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
    
    

    public DocReturn(Integer d) {
        docreturn = d;
    }

    public DocReturn() {
    }

    public Integer getDocreturn() {
        return docreturn;
    }

    public void setDocreturn(Integer docreturn) {
        this.docreturn = docreturn;
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
