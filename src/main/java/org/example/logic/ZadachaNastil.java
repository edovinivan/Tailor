/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ZADACHANASTIL")
public class ZadachaNastil implements Serializable {
    @Id
    @Column(name = "ZADACHANASTIL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHANASTIL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHANASTIL_ID", sequenceName = "GEN_ZADACHANASTIL_ID")
    Integer zadachanastil;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHA")
    Zadacha zadacha;
    
    @ManyToOne
    @JoinColumn(name = "TIPNASTILA")
    TipNastila tipnastila;
    
    @ManyToOne
    @JoinColumn(name = "TIPNASTILANIA")
    TipNastilania tipnastilania;
    
    @Column(name = "NOMER")
    String nomer;    

    @Column(name = "QTYL")
    Integer qtyl;
    
    @Column(name = "QTYEND")
    BigDecimal qtyend;
    
    @Column(name = "QTYDEL")
    BigDecimal qtydel;
    
    @Column(name = "QTYDEL1")
    BigDecimal qtydel1;
    
    @Column(name = "QTYLOSK")
    BigDecimal qtylosk;
    
    @Column(name = "QTYLOSK1")
    BigDecimal qtylosk1;
    
    @Column(name = "QTYGUT")
    BigDecimal qtygut;
    
    @Column(name = "QTYTRUBA")
    BigDecimal qtytruba;
    
    @Column(name = "QTYBEIKA")
    BigDecimal qtybeika;
    
    @Column(name = "QTYRETURN")
    BigDecimal qtyreturn;
    
    @Column(name = "ADDARTICLE")
    String addarticle;
    
    @Column(name = "QTYADDARTICLE")
    BigDecimal qtyaddarticle;
    
    @ManyToOne
    @JoinColumn(name = "REZAK")
    Rabotnik rezak;

    @ManyToOne
    @JoinColumn(name = "NASTIL")    
    Rabotnik nastil;
    
    @Column(name = "STATUS")
    Integer status;
    
    @ManyToOne
    @JoinColumn(name = "DRETURN")
    Document dreturn;
    
    @Column(name = "PLUSDLINA")
    Integer plusdlina;
    
    @Column(name = "QTYL_STRING")
    String qtyl_string;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "DLINA")
    BigDecimal dlina;
    
    @Column(name = "QTYNULL")
    BigDecimal qtynull;
    
    @Column(name = "DLINAKONC")
    BigDecimal dlinakonc;
    
    @Column(name = "BEIKA")
    String beika;
    
    @Column(name = "ADDARTICLETEXT")
    String addarticletext;
    
    @Column(name = "TEXTS")
    String texts;
    
    @Column(name = "PACHKA")
    Integer pachka;
    
    @ManyToOne
    @JoinColumn(name = "TIPPOLOTNA")
    Product tippolotna;
    
    @Column(name = "PASPORTRETURN")
    String pasportreturn;
    
    @Column(name = "DATECLOSE")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dateclose;
    
    @Column(name = "WIDTH")
    Integer width;
    
    @Column(name = "KOLSLOI")
    Integer kolsloi;
    
    @Column(name = "KOLSLOIDOP")
    Integer kolsloidop;

    public BigDecimal getQtylosk1() {
        if(qtylosk1 == null)
            return BigDecimal.ZERO;
        return qtylosk1;
    }

    public void setQtylosk1(BigDecimal qtylosk1) {
        this.qtylosk1 = qtylosk1;
    }
    
    

    public BigDecimal getQtydel1() {
        if(qtydel1==null)
            return BigDecimal.ZERO;
        return qtydel1;
    }

    public void setQtydel1(BigDecimal qtydel1) {
        this.qtydel1 = qtydel1;
    }
    
    

    public Integer getKolsloidop() {
        if(kolsloidop==null)
            return 0;
        return kolsloidop;
    }

    public void setKolsloidop(Integer kolsloidop) {
        this.kolsloidop = kolsloidop;
    }
    
    public Integer getKolsloi() {
        if(kolsloi == null)
            return 0;
        return kolsloi;
    }

    public void setKolsloi(Integer kolsloi) {
        this.kolsloi = kolsloi;
    }
    
    

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
    
    

    public Date getDateclose() {
        return dateclose;
    }

    public void setDateclose(Date dateclose) {
        this.dateclose = dateclose;
    }
    
    public String getPasportreturn() {
        return pasportreturn;
    }

    public void setPasportreturn(String pasportreturn) {
        this.pasportreturn = pasportreturn;
    }
    
    

    public BigDecimal getQtybeika() {
        return qtybeika;
    }

    public void setQtybeika(BigDecimal qtybeika) {
        this.qtybeika = qtybeika;
    }
    
    

    public String getTexts() {
        return texts;
    }

    public void setTexts(String texts) {
        this.texts = texts;
    }
    
    

    public String getAddarticletext() {
        return addarticletext;
    }

    public void setAddarticletext(String addarticletext) {
        this.addarticletext = addarticletext;
    }
    
    

    public BigDecimal getDlinakonc() {
        return dlinakonc;
    }

    public void setDlinakonc(BigDecimal dlinakonc) {
        this.dlinakonc = dlinakonc;
    }

    public String getBeika() {
        return beika;
    }

    public void setBeika(String beika) {
        this.beika = beika;
    }

    public Integer getPachka() {
        return pachka;
    }

    public void setPachka(Integer pachka) {
        this.pachka = pachka;
    }

    public Product getTippolotna() {
        return tippolotna;
    }

    public void setTippolotna(Product tippolotna) {
        this.tippolotna = tippolotna;
    }

    public BigDecimal getDlina() {
        return dlina;
    }

    public void setDlina(BigDecimal dlina) {
        this.dlina = dlina;
    }

    public BigDecimal getQtynull() {
        return qtynull;
    }

    public void setQtynull(BigDecimal qtynull) {
        this.qtynull = qtynull;
    }
    
    

    public String getQtyl_string() {
        return qtyl_string;
    }

    public void setQtyl_string(String qtyl_string) {
        this.qtyl_string = qtyl_string;
    }
    
    

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }
    
    

    public Integer getPlusdlina() {
        return plusdlina;
    }

    public void setPlusdlina(Integer plusdlina) {
        this.plusdlina = plusdlina;
    }

    public Document getDreturn() {
        return dreturn;
    }

    public void setDreturn(Document dreturn) {
        this.dreturn = dreturn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

    public BigDecimal getQtyreturn() {
        return qtyreturn;
    }

    public void setQtyreturn(BigDecimal qtyreturn) {
        this.qtyreturn = qtyreturn;
    }
    
    

    public Integer getQtyl() {
        return qtyl;
    }

    public void setQtyl(Integer qtyl) {
        this.qtyl = qtyl;
    }

    public BigDecimal getQtyend() {
        return qtyend;
    }

    public void setQtyend(BigDecimal qtyend) {
        this.qtyend = qtyend;
    }

    public BigDecimal getQtydel() {
        return qtydel;
    }

    public void setQtydel(BigDecimal qtydel) {
        this.qtydel = qtydel;
    }

    public BigDecimal getQtylosk() {
        return qtylosk;
    }

    public void setQtylosk(BigDecimal qtylosk) {
        this.qtylosk = qtylosk;
    }

    public BigDecimal getQtygut() {
        return qtygut;
    }

    public void setQtygut(BigDecimal qtygut) {
        this.qtygut = qtygut;
    }

    public BigDecimal getQtytruba() {
        return qtytruba;
    }

    public void setQtytruba(BigDecimal qtytruba) {
        this.qtytruba = qtytruba;
    }

    public String getAddarticle() {
        return addarticle;
    }

    public void setAddarticle(String addarticle) {
        this.addarticle = addarticle;
    }

    public BigDecimal getQtyaddarticle() {
        return qtyaddarticle;
    }

    public void setQtyaddarticle(BigDecimal qtyaddarticle) {
        this.qtyaddarticle = qtyaddarticle;
    }

    public Rabotnik getRezak() {
        return rezak;
    }

    public void setRezak(Rabotnik rezak) {
        this.rezak = rezak;
    }

    public Rabotnik getNastil() {
        return nastil;
    }

    public void setNastil(Rabotnik nastil) {
        this.nastil = nastil;
    }
    

    
    

    public ZadachaNastil(Integer zn) {
        zadachanastil = zn;
    }

    public ZadachaNastil() {
    }

    public Integer getZadachanastil() {
        return zadachanastil;
    }

    public void setZadachanastil(Integer zadachanastil) {
        this.zadachanastil = zadachanastil;
    }

    public Zadacha getZadacha() {
        return zadacha;
    }

    public void setZadacha(Zadacha zadacha) {
        this.zadacha = zadacha;
    }

    public TipNastila getTipnastila() {
        return tipnastila;
    }

    public void setTipnastila(TipNastila tipnastila) {
        this.tipnastila = tipnastila;
    }

    public TipNastilania getTipnastilania() {
        return tipnastilania;
    }

    public void setTipnastilania(TipNastilania tipnastilania) {
        this.tipnastilania = tipnastilania;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }
    
    
    
    
    
}
