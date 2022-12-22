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
@Table(name = "PRODUCTGRUPPA")
public class ProductGruppa implements Serializable {
    @Id
    @Column(name = "PRODUCTGRUPPA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_PRODUCTGRUPPA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_PRODUCTGRUPPA_ID", sequenceName = "GEN_PRODUCTGRUPPA_ID")
    Integer productgruppa;
    
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
    
    

    public ProductGruppa(Integer pg) {
        productgruppa = pg;
    }

    public ProductGruppa() {
    }

    public Integer getProductgruppa() {
        return productgruppa;
    }

    public void setProductgruppa(Integer productgruppa) {
        this.productgruppa = productgruppa;
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

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }
    
    
    
    
    
}
