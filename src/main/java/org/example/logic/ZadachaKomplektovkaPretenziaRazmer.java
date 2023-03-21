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
@Table(name = "ZKPRETENZIARAZMER")
public class ZadachaKomplektovkaPretenziaRazmer implements Serializable {
    @Id
    @Column(name = "ZKPRETENZIARAZMER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZKPRETENZIARAZMER_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZKPRETENZIARAZMER_ID", sequenceName = "GEN_ZKPRETENZIARAZMER_ID")
    Integer zkpretenziarazmer;
    
    @ManyToOne
    @JoinColumn(name = "ZKPRETENZIA")
    ZadachaKomplektovkaPretenzia zkpretenzia;
    
    @ManyToOne
    @JoinColumn(name = "ZKRAZMER")
    ZadachaKomplektovkaRazmeri zkrazmer;
    
    @Column(name = "VOPROS")
    String vopros;
    
    @Column(name = "OTVET")
    String otvet;
    
    @Column(name = "QTY")
    Integer qty;

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    

    public ZadachaKomplektovkaPretenziaRazmer(Integer z) {
        zkpretenziarazmer = z;        
    }

    public ZadachaKomplektovkaPretenziaRazmer() {
    }

    public Integer getZkpretenziarazmer() {
        return zkpretenziarazmer;
    }

    public void setZkpretenziarazmer(Integer zkpretenziarazmer) {
        this.zkpretenziarazmer = zkpretenziarazmer;
    }

    public ZadachaKomplektovkaPretenzia getZkpretenzia() {
        return zkpretenzia;
    }

    public void setZkpretenzia(ZadachaKomplektovkaPretenzia zkpretenzia) {
        this.zkpretenzia = zkpretenzia;
    }

    public ZadachaKomplektovkaRazmeri getZkrazmer() {
        return zkrazmer;
    }

    public void setZkrazmer(ZadachaKomplektovkaRazmeri zkrazmer) {
        this.zkrazmer = zkrazmer;
    }

    public String getVopros() {
        return vopros;
    }

    public void setVopros(String vopros) {
        this.vopros = vopros;
    }

    public String getOtvet() {
        return otvet;
    }

    public void setOtvet(String otvet) {
        this.otvet = otvet;
    }
    
    
    
    
    
}
