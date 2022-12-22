/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

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
@Table(name = "P_ZAKUPKI")
public class PZakupki implements Serializable {
    @Id
    @Column(name = "P_ZAKUPKI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_ZAKUPKI_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_ZAKUPKI_ID", sequenceName = "GEN_P_ZAKUPKI_ID")
    Integer pzakupki;
    
    @Column(name = "DATE1")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date1;
    
    @Column(name = "DATE2")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date date2;
    
    @Column(name = "STATUS")
    Integer status;

    public PZakupki(Integer p) {
        pzakupki = p;
    }

    public PZakupki() {
    }

    public Integer getPzakupki() {
        return pzakupki;
    }

    public void setPzakupki(Integer pzakupki) {
        this.pzakupki = pzakupki;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
    
    
    
}
