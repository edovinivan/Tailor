/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "SCLADPRODUCT")
public class ScladProduct implements Serializable {
    @Id
    @Column(name = "SCLADPRODUCT")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_SCLADPRODUCT_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_SCLADPRODUCT_ID", sequenceName = "GEN_SCLADPRODUCT_ID")
    Integer scladproduct;
    
    @ManyToOne
    @JoinColumn(name = "DOCUMENTJOURNAL")
    DocumentJournal documentjournal;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT")
    Product product;
    
    @ManyToOne
    @JoinColumn(name = "AGENT")
    Agent agent;
            
    @Column(name = "PRICE")
    BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name = "SCLAD")
    Sclad sclad;
    
    @Column(name = "WIDTH")
    BigDecimal width;
    
    @Column(name = "LIGHT")
    BigDecimal light;
    
    @Column(name = "WIDTHTEMP")
    Integer widthtemp;
    
    @Column(name = "LIGHTTEMP")
    BigDecimal lighttemp;
    
    @Column(name = "VES")
    BigDecimal ves;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
           
    @Column(name = "PASSPORT")
    String pasport;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "VID")
    Integer vid;
    
    @Column(name = "TEXTCOMMENT")
    String textcomment;

    public String getTextcomment() {
        return textcomment;
    }

    public void setTextcomment(String textcomment) {
        this.textcomment = textcomment;
    }
    
    

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

    public ScladProduct(Integer sp) {
        scladproduct = sp;
    }

    public ScladProduct() {
    }

    public Integer getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(Integer scladproduct) {
        this.scladproduct = scladproduct;
    }

    public DocumentJournal getDocumentjournal() {
        return documentjournal;
    }

    public void setDocumentjournal(DocumentJournal documentjournal) {
        this.documentjournal = documentjournal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Sclad getSclad() {
        return sclad;
    }

    public void setSclad(Sclad sclad) {
        this.sclad = sclad;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    
    
    public BigDecimal getLight() {
        return light;
    }

    public void setLight(BigDecimal light) {
        this.light = light;
    }

    public BigDecimal getVes() {
        return ves;
    }

    public void setVes(BigDecimal ves) {
        this.ves = ves;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getWidthtemp() {
        return widthtemp;
    }

    public void setWidthtemp(Integer widthtemp) {
        this.widthtemp = widthtemp;
    }

    public BigDecimal getLighttemp() {
        return lighttemp;
    }

    public void setLighttemp(BigDecimal lighttemp) {
        this.lighttemp = lighttemp;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    
    
    
    
    
    
}
