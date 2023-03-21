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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ZLOG")
public class ZLog implements Serializable {
    @Id
    @Column(name = "ZLOG")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZLOG_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZLOG_ID", sequenceName = "GEN_ZLOG_ID")
    Integer zlog;
    
    @Column(name = "ZADACHA")
    Integer zadacha;
    
    @Column(name = "ID")
    Integer id;
    
    @Column(name = "TIPID")
    Integer tipid;
    
    @Column(name = "OPER")
    Integer oper;
        
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    Date dates;
    
    @Column(name = "COMMENT")
    String comment;
    
    @Column(name = "PC")
    String pc;

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }
    
    

    public Integer getOper() {
        return oper;
    }

    public void setOper(Integer oper) {
        this.oper = oper;
    }
    
    

    public ZLog() {
    }
    
    public ZLog(Integer z) {
        zlog = z;
    }

    public Integer getZlog() {
        return zlog;
    }

    public void setZlog(Integer zlog) {
        this.zlog = zlog;
    }

    public Integer getZadacha() {
        return zadacha;
    }

    public void setZadacha(Integer zadacha) {
        this.zadacha = zadacha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipid() {
        return tipid;
    }

    public void setTipid(Integer tipid) {
        this.tipid = tipid;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
    
    
}
