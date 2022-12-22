/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "SCLADLOSKUTSALEOP")
public class ScladLoskutSaleOp implements Serializable {
    
    @Id
    @Column(name = "SCLADLOSKUTSALEOP")
    Integer scladloskutsaleop;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "DEL")
    Integer del;

    @Override
    public String toString() {
        return getName();
    }
    
    

    public ScladLoskutSaleOp(Integer r) {
        scladloskutsaleop = r;
    }

    public ScladLoskutSaleOp() {
    }

    public Integer getScladloskutsaleop() {
        return scladloskutsaleop;
    }

    public void setScladloskutsaleop(Integer scladloskutsaleop) {
        this.scladloskutsaleop = scladloskutsaleop;
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
