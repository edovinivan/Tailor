/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.plan;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
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
@Table(name = "MAPPROJECT")
public class MapProject implements Serializable {
    @Id
    @Column(name = "MAPPROJECT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MAPPROJECT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MAPPROJECT_ID", sequenceName = "GEN_MAPPROJECT_ID")
    Integer mapproject;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "START_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date start_date;
    
    @Column(name = "END_DATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date end_date;
    
    @Column(name = "STATUS")
    Integer status;
  
    
    public MapProject() {
    }

    public MapProject(Integer mapproject) {
        this.mapproject = mapproject;
    }

    public Integer getMapproject() {
        return mapproject;
    }

    public void setMapproject(Integer mapproject) {
        this.mapproject = mapproject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
   
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    
    
    
    
    
}
