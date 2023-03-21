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
@Table(name = "DOCUMENTJOURNAL")
public class DocumentJournal implements Serializable {
    @Id
    @Column(name = "DOCUMENTJOURNAL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_DOCUMENTJOURNAL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_DOCUMENTJOURNAL_ID", sequenceName = "GEN_DOCUMENTJOURNAL_ID")
    Integer documentjournal;
    
    @ManyToOne
    @JoinColumn(name = "DOCUMENT")
    Document document;
    
    @ManyToOne
    @JoinColumn(name = "PRODUCT")
    Product product;
            
    @Column(name = "PRICE")
    BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name = "SCLAD")
    Sclad sclad;
    
    @Column(name = "WIDTH")
    BigDecimal width;
    
    @Column(name = "WIDTHTEMP")
    BigDecimal widthtemp;
    
    @Column(name = "LIGHT")
    BigDecimal light;
    
    @Column(name = "LIGHTTEMP")
    BigDecimal lighttemp;
    
    @Column(name = "VES")
    BigDecimal ves;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
           
    @Column(name = "PASPORT")
    String pasport;
    
    @Column(name = "DEL")
    Integer del;
    
    @Column(name = "STATUS")
    Integer status;
    
    @ManyToOne
    @JoinColumn(name = "SPRETURN")
    ScladProduct scladproduct;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

    public ScladProduct getScladproduct() {
        return scladproduct;
    }

    public void setScladproduct(ScladProduct scladproduct) {
        this.scladproduct = scladproduct;
    }
    
    

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
    
    

    public DocumentJournal(Integer dj) {
        documentjournal = dj;
    }

    public DocumentJournal() {
    }

    public Integer getDocumentjournal() {
        return documentjournal;
    }

    public void setDocumentjournal(Integer documentjournal) {
        this.documentjournal = documentjournal;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
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

    public BigDecimal getWidthtemp() {
        return widthtemp;
    }

    public void setWidthtemp(BigDecimal widthtemp) {
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
