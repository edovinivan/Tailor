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
@Table(name = "ZADACHARAZMERI")
public class ZadachaRazmeri implements Serializable {
    @Id
    @Column(name = "ZADACHARAZMERI")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHARAZMERI_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHARAZMERI_ID", sequenceName = "GEN_ZADACHARAZMERI_ID")
    Integer zadacharazmeri;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHA")
    Zadacha zadacha;
    
    @ManyToOne
    @JoinColumn(name = "RAZMERI")
    Razmeri razmeri;
    
    @Column(name = "QTY")
    Integer qty;
    
    @Column(name = "QTYEND")
    Integer qtyend;

    public ZadachaRazmeri(Integer z) {
        zadacharazmeri = z;
    }

    public ZadachaRazmeri() {
    }

    public Integer getZadacharazmeri() {
        return zadacharazmeri;
    }

    public void setZadacharazmeri(Integer zadacharazmeri) {
        this.zadacharazmeri = zadacharazmeri;
    }

    public Zadacha getZadacha() {
        return zadacha;
    }

    public void setZadacha(Zadacha zadacha) {
        this.zadacha = zadacha;
    }

    public Razmeri getRazmeri() {
        return razmeri;
    }

    public void setRazmeri(Razmeri razmeri) {
        this.razmeri = razmeri;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQtyend() {
        return qtyend;
    }

    public void setQtyend(Integer qtyend) {
        this.qtyend = qtyend;
    }
    
    
    
    
    
    
    
}
