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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "REVIZIA")
public class Revizia implements Serializable {
    @Id
    @Column(name = "REVIZIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_REVIZIA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_REVIZIA_ID", sequenceName = "GEN_REVIZIA_ID")
    Integer revizia;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Formula("coalesce((select sum(rj.ves) from reviziajournal rj where rj.revizia = revizia),0)")          
    BigDecimal sves;
    
    @Formula("coalesce((select sum(rj.vesdb) from reviziajournal rj where rj.revizia = revizia),0)")          
    BigDecimal svesdb;

    public BigDecimal getSves() {
        return sves;
    }

    public void setSves(BigDecimal sves) {
        this.sves = sves;
    }

    public BigDecimal getSvesdb() {
        return svesdb;
    }

    public void setSvesdb(BigDecimal svesdb) {
        this.svesdb = svesdb;
    }
    
    

    public Revizia(Integer r) {
        revizia = r;
    }

    public Revizia() {
    }

    public Integer getRevizia() {
        return revizia;
    }

    public void setRevizia(Integer revizia) {
        this.revizia = revizia;
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
