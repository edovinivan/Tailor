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
@Table(name = "PRINTDETALI")
public class PrintDetali implements Serializable {
    @Id
    @Column(name = "PRINTDETALI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_PRINTDETALI_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_PRINTDETALI_ID", sequenceName = "GEN_PRINTDETALI_ID")
    Integer printdetali;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;
    
    @Column(name = "VID")
    Integer vid;

    @Override
    public String toString() {
        return getName();
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public PrintDetali(Integer p) {
        printdetali = p;
    }

    public PrintDetali() {
    }

    public Integer getPrintdetali() {
        return printdetali;
    }

    public void setPrintdetali(Integer printdetali) {
        this.printdetali = printdetali;
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
