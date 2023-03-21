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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "REPORT")
public class Report implements Serializable {
    @Id
    @Column(name = "REPORT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_REPORT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_REPORT_ID", sequenceName = "GEN_REPORT_ID")
    Integer report;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "TIP")
    Integer tip;
    
    @ManyToOne
    @JoinColumn(name = "FILES")
    Files files;

    public Report(Integer r) {
        report = r;
    }

    public Report() {
    }

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTip() {
        return tip;
    }

    public void setTip(Integer tip) {
        this.tip = tip;
    }

    public Files getFiles() {
        return files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }
    
    
    
    
}
