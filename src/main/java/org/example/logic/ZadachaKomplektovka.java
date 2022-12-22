/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic;

import java.io.Serializable;
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
import org.hibernate.annotations.Formula;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ZADACHAKOMPLEKTOVKA")
public class ZadachaKomplektovka implements Serializable {
    @Id
    @Column(name = "ZADACHAKOMPLEKTOVKA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ZADACHAKOMPLEKTOVKA_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_ZADACHAKOMPLEKTOVKA_ID", sequenceName = "GEN_ZADACHAKOMPLEKTOVKA_ID")
    Integer zadachakomplektovka;
    
    //@Column(name = "ZADACHA")
    //Integer zadacha;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHA")
    Zadacha zadacha;
    
    @ManyToOne
    @JoinColumn(name = "ZADACHA2")
    Zadacha zadacha2;
    
    @ManyToOne
    @JoinColumn(name = "MODEL")
    Model model;
    
    @ManyToOne
    @JoinColumn(name = "RABOTNIK")
    Rabotnik rabotnik;
    
    @ManyToOne
    @JoinColumn(name = "CHEX")
    RabotnikGruppa chek;
    
    @Column(name = "NOMER")
    String nomer;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
    
    @Column(name = "STATUS")
    Integer status;
    
    //@Formula("coalesce((select cast(list((r.name || '-' ||z.qty),', ') as varchar(500)) from zadachakomplektovkarazmeri z inner join razmeri r on r.razmeri = z.razmeri where z.qty>0 and z.zadachakomplektovka = zadachakomplektovka),0)")
    @Formula("coalesce((select sum(z.qty) from zadachakomplektovkarazmeri z where z.zadachakomplektovka = zadachakomplektovka),0)")
    Integer counts;
    
    @Column(name = "DATASEND")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datasend;
    
    @Column(name = "DATAGET")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataget;
    
    @Column(name = "DATAEND")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dataend;
    
    @Column(name = "DATARETURN")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datareturn;
    
    @Column(name = "BRAK")
    Integer brak;
    
    @Column(name = "BRAKTEXT")
    String braktext;
    
    @Column(name = "DATASCLAD")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date datasclad;
    
    @Column(name = "QTYSCLAD")
    Integer qtysclad;
    
    @ManyToOne
    @JoinColumn(name = "COLOR")
    Color color;
    
    @Column(name = "BRAK1")
    Integer brak1;
    
    @Column(name = "CSALE")
    Integer csale;
    
    @Column(name = "BRAK1TEXT")
    String brak1text;
    
    @Column(name = "ZTEXT")
    String ztext;
    
    @ManyToOne
    @JoinColumn(name = "REZAK")
    Rabotnik rezak;
    
    @ManyToOne
    @JoinColumn(name = "NASTIL")
    Rabotnik nastil;
    
    @Formula("coalesce((select count(z.ZKPRETENZIA) from ZKPRETENZIA z where z.ZADACHAKOMPLEKTOVKA = zadachakomplektovka),0)")
    Integer count_pretenzia;
    
    @Formula("coalesce((select cast(list((r.name || '-' ||z.qty),', ') as varchar(500)) from zadachakomplektovkarazmeri z inner join razmeri r on r.razmeri = z.razmeri where z.qty>0 and z.zadachakomplektovka = zadachakomplektovka),0)")
    String str_cou;
    
    @ManyToOne
    @JoinColumn(name = "SCLAD")
    Sclad sclad;

    public Sclad getSclad() {
        return sclad;
    }

    public void setSclad(Sclad sclad) {
        this.sclad = sclad;
    }
    
    

    public String getStr_cou() {
        return str_cou;
    }

    public void setStr_cou(String str_cou) {
        this.str_cou = str_cou;
    }
    
    

    
    
    public Zadacha getZadacha2() {
        return zadacha2;
    }

    public void setZadacha2(Zadacha zadacha2) {
        this.zadacha2 = zadacha2;
    }
    
    

    public Integer getCount_pretenzia() {
        return count_pretenzia;
    }

    public void setCount_pretenzia(Integer count_pretenzia) {
        this.count_pretenzia = count_pretenzia;
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
    
    

    public Integer getCsale() {
        return csale==null?0:csale;
    }

    public void setCsale(Integer csale) {
        if(csale==null)
            csale = 0;
        this.csale = csale;
    }

    public Integer getBrak1() {
        return brak1==null?0:brak1;
    }

    public void setBrak1(Integer brak1) {
        if(brak1 == null)
            brak1 = 0;
        this.brak1 = brak1;
    }

    public String getBrak1text() {
        return brak1text;
    }

    public void setBrak1text(String brak1text) {
        this.brak1text = brak1text;
    }

    public String getZtext() {
        return ztext;
    }

    public void setZtext(String ztext) {
        this.ztext = ztext;
    }
    
    
    

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Date getDatasend() {
        return datasend;
    }

    public void setDatasend(Date datasend) {
        this.datasend = datasend;
    }

    public Date getDataget() {
        return dataget;
    }

    public void setDataget(Date dataget) {
        this.dataget = dataget;
    }

    public Date getDataend() {
        return dataend;
    }

    public void setDataend(Date dataend) {
        this.dataend = dataend;
    }

    public Date getDatareturn() {
        return datareturn;
    }

    public void setDatareturn(Date datareturn) {
        this.datareturn = datareturn;
    }

    public Integer getBrak() {
        return brak;
    }

    public void setBrak(Integer brak) {
        this.brak = brak;
    }

    public String getBraktext() {
        return braktext;
    }

    public void setBraktext(String braktext) {
        this.braktext = braktext;
    }

    public Date getDatasclad() {
        return datasclad;
    }

    public void setDatasclad(Date datasclad) {
        this.datasclad = datasclad;
    }

    public Integer getQtysclad() {
        return qtysclad;
    }

    public void setQtysclad(Integer qtysclad) {
        this.qtysclad = qtysclad;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

   
    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    

    public ZadachaKomplektovka(Integer zk) {
        zadachakomplektovka = zk;
    }

    public ZadachaKomplektovka() {
    }

    public Integer getZadachakomplektovka() {
        return zadachakomplektovka;
    }

    public void setZadachakomplektovka(Integer zadachakomplektovka) {
        this.zadachakomplektovka = zadachakomplektovka;
    }

    public Zadacha getZadacha() {
        return zadacha;
    }

    public void setZadacha(Zadacha zadacha) {
        this.zadacha = zadacha;
    }

    

    public Rabotnik getRabotnik() {
        return rabotnik;
    }

    public void setRabotnik(Rabotnik rabotnik) {
        this.rabotnik = rabotnik;
    }

    public RabotnikGruppa getChek() {
        return chek;
    }

    public void setChek(RabotnikGruppa chek) {
        this.chek = chek;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }
    
    
    
    
    
    
}
