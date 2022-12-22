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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.example.logic.RabotnikGruppa;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "P_CALENDAR")
public class PCalendar implements Serializable {
    @Id
    @Column(name = "P_CALENDAR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_P_CALENDAR_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_P_CALENDAR_ID", sequenceName = "GEN_P_CALENDAR_ID")
    Integer pcalendar;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @ManyToOne
    @JoinColumn(name = "CHEX")
    RabotnikGruppa chex;

    public RabotnikGruppa getChex() {
        return chex;
    }

    public void setChex(RabotnikGruppa chex) {
        this.chex = chex;
    }
    
    

    public PCalendar() {
    }
    
    public PCalendar(Integer r) {
        pcalendar = r;
    }

    public Integer getPcalendar() {
        return pcalendar;
    }

    public void setPcalendar(Integer pcalendar) {
        this.pcalendar = pcalendar;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    
    
}
