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
@Table(name = "MODEL")
public class Model implements Serializable {
    @Id
    @Column(name = "MODEL")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_MODEL_ID")
    @SequenceGenerator(allocationSize = 1, name = "GEN_MODEL_ID", sequenceName = "GEN_MODEL_ID")
    Integer model;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "DATES")
    @Temporal(javax.persistence.TemporalType.DATE)
    Date dates;
        
    @ManyToOne
    @JoinColumn(name = "TIPMODEL")
    TipModel tipmodel;
    
    @ManyToOne
    @JoinColumn(name = "FIRSTRAZMERI")
    Razmeri firstrazmeri;
    
    
    @ManyToOne
    @JoinColumn(name = "ENDRAZMERI")
    Razmeri endrazmeri;
    
    @ManyToOne
    @JoinColumn(name = "HMODEL")
    Model hmodel;
    
           
    @Column(name = "BEIKA")
    String beika;
    
    @Column(name = "PRICE")
    BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name = "RASKLADCHIK")
    Raskladchik raskladchik;
    
    @ManyToOne
    @JoinColumn(name = "RASKLADCHIK1")
    Raskladchik raskladchik1;
    
    @Column(name = "DEL")
    Integer del;
    
    @Column(name = "STATUS")
    Integer status;
    
    @Column(name = "NAME")
    String name;
    
    @Column(name = "TEXT")
    String text;
    
    @Column(name = "OTVETST")
    String otvetst;
    
    @Column(name = "TEXTSITE")
    String textsite;
    
    @Column(name = "PM1")
    BigDecimal pm1;
    
    @Column(name = "PM2")
    BigDecimal pm2;
            
    @Column(name = "PM3")
    Integer pm3;
    
    @Column(name = "PM4")
    Integer pm4;
    
    @Column(name = "PM1_1")
    BigDecimal pm1_1;
    
    @Column(name = "PM1_2")
    BigDecimal pm1_2;
    
    @Column(name = "PM1_3")
    BigDecimal pm1_3;
    
    @Column(name = "PM1_4")
    BigDecimal pm1_4;
    
    @Column(name = "PM1_5")
    BigDecimal pm1_5;
    
    @Column(name = "PM1_6")
    BigDecimal pm1_6;
    
    @Column(name = "PM1_7")
    BigDecimal pm1_7;
    
    @Column(name = "PM1_8")
    BigDecimal pm1_8;
    
    @Column(name = "PM1_9")
    BigDecimal pm1_9;
    
    @Column(name = "PM2_1")
    BigDecimal pm2_1;
    
    @Column(name = "PM2_2")
    BigDecimal pm2_2;
    
    @Column(name = "PM2_3")
    BigDecimal pm2_3;
    
    @Column(name = "PM2_4")
    BigDecimal pm2_4;
    
    @Column(name = "PM2_5")
    BigDecimal pm2_5;
    
    @Column(name = "PM2_6")
    BigDecimal pm2_6;
    
    @Column(name = "PM2_7")
    BigDecimal pm2_7;
    
    @Column(name = "PM2_8")
    BigDecimal pm2_8;
    
    @Column(name = "PM2_9")
    BigDecimal pm2_9;
    
    @Column(name = "PM3_1")
    Integer pm3_1;
    
    @Column(name = "PM3_2")
    Integer pm3_2;
    
    @Column(name = "PM3_3")
    Integer pm3_3;
    
    @Column(name = "PM3_4")
    Integer pm3_4;
    
    @Column(name = "PM3_5")
    Integer pm3_5;
    
    @Column(name = "PM3_6")
    Integer pm3_6;
    
    @Column(name = "PM3_7")
    Integer pm3_7;
    
    @Column(name = "PM3_8")
    Integer pm3_8;
    
    @Column(name = "PM3_9")
    Integer pm3_9;
    
    @Column(name = "HARTICLE")
    String harticle;

    public String getHarticle() {
        return harticle;
    }

    public void setHarticle(String harticle) {
        this.harticle = harticle;
    }
    
    

    public Model getHmodel() {
        return hmodel;
    }

    public void setHmodel(Model hmodel) {
        this.hmodel = hmodel;
    }
    
    

    public BigDecimal getPm1() {
        return pm1;
    }

    public void setPm1(BigDecimal pm1) {
        this.pm1 = pm1;
    }

    public BigDecimal getPm2() {
        return pm2;
    }

    public void setPm2(BigDecimal pm2) {
        this.pm2 = pm2;
    }

    public Integer getPm3() {
        return pm3;
    }

    public void setPm3(Integer pm3) {
        this.pm3 = pm3;
    }

    public Integer getPm4() {
        return pm4;
    }

    public void setPm4(Integer pm4) {
        this.pm4 = pm4;
    }

    

    public BigDecimal getPm1_1() {
        return pm1_1;
    }

    public void setPm1_1(BigDecimal pm1_1) {
        this.pm1_1 = pm1_1;
    }

    public BigDecimal getPm1_2() {
        return pm1_2;
    }

    public void setPm1_2(BigDecimal pm1_2) {
        this.pm1_2 = pm1_2;
    }

    public BigDecimal getPm1_3() {
        return pm1_3;
    }

    public void setPm1_3(BigDecimal pm1_3) {
        this.pm1_3 = pm1_3;
    }

    public BigDecimal getPm1_4() {
        return pm1_4;
    }

    public void setPm1_4(BigDecimal pm1_4) {
        this.pm1_4 = pm1_4;
    }

    public BigDecimal getPm1_5() {
        return pm1_5;
    }

    public void setPm1_5(BigDecimal pm1_5) {
        this.pm1_5 = pm1_5;
    }

    public BigDecimal getPm1_6() {
        return pm1_6;
    }

    public void setPm1_6(BigDecimal pm1_6) {
        this.pm1_6 = pm1_6;
    }

    public BigDecimal getPm1_7() {
        return pm1_7;
    }

    public void setPm1_7(BigDecimal pm1_7) {
        this.pm1_7 = pm1_7;
    }

    public BigDecimal getPm1_8() {
        return pm1_8;
    }

    public void setPm1_8(BigDecimal pm1_8) {
        this.pm1_8 = pm1_8;
    }

    public BigDecimal getPm1_9() {
        return pm1_9;
    }

    public void setPm1_9(BigDecimal pm1_9) {
        this.pm1_9 = pm1_9;
    }

    public BigDecimal getPm2_1() {
        return pm2_1;
    }

    public void setPm2_1(BigDecimal pm2_1) {
        this.pm2_1 = pm2_1;
    }

    public BigDecimal getPm2_2() {
        return pm2_2;
    }

    public void setPm2_2(BigDecimal pm2_2) {
        this.pm2_2 = pm2_2;
    }

    public BigDecimal getPm2_3() {
        return pm2_3;
    }

    public void setPm2_3(BigDecimal pm2_3) {
        this.pm2_3 = pm2_3;
    }

    public BigDecimal getPm2_4() {
        return pm2_4;
    }

    public void setPm2_4(BigDecimal pm2_4) {
        this.pm2_4 = pm2_4;
    }

    public BigDecimal getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(BigDecimal pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public BigDecimal getPm2_6() {
        return pm2_6;
    }

    public void setPm2_6(BigDecimal pm2_6) {
        this.pm2_6 = pm2_6;
    }

    public BigDecimal getPm2_7() {
        return pm2_7;
    }

    public void setPm2_7(BigDecimal pm2_7) {
        this.pm2_7 = pm2_7;
    }

    public BigDecimal getPm2_8() {
        return pm2_8;
    }

    public void setPm2_8(BigDecimal pm2_8) {
        this.pm2_8 = pm2_8;
    }

    public BigDecimal getPm2_9() {
        return pm2_9;
    }

    public void setPm2_9(BigDecimal pm2_9) {
        this.pm2_9 = pm2_9;
    }

    public Integer getPm3_1() {
        return pm3_1;
    }

    public void setPm3_1(Integer pm3_1) {
        this.pm3_1 = pm3_1;
    }

    public Integer getPm3_2() {
        return pm3_2;
    }

    public void setPm3_2(Integer pm3_2) {
        this.pm3_2 = pm3_2;
    }

    public Integer getPm3_3() {
        return pm3_3;
    }

    public void setPm3_3(Integer pm3_3) {
        this.pm3_3 = pm3_3;
    }

    public Integer getPm3_4() {
        return pm3_4;
    }

    public void setPm3_4(Integer pm3_4) {
        this.pm3_4 = pm3_4;
    }

    public Integer getPm3_5() {
        return pm3_5;
    }

    public void setPm3_5(Integer pm3_5) {
        this.pm3_5 = pm3_5;
    }

    public Integer getPm3_6() {
        return pm3_6;
    }

    public void setPm3_6(Integer pm3_6) {
        this.pm3_6 = pm3_6;
    }

    public Integer getPm3_7() {
        return pm3_7;
    }

    public void setPm3_7(Integer pm3_7) {
        this.pm3_7 = pm3_7;
    }

    public Integer getPm3_8() {
        return pm3_8;
    }

    public void setPm3_8(Integer pm3_8) {
        this.pm3_8 = pm3_8;
    }

    public Integer getPm3_9() {
        return pm3_9;
    }

    public void setPm3_9(Integer pm3_9) {
        this.pm3_9 = pm3_9;
    }

    
    
    
    
    

    public String getTextsite() {
        return textsite;
    }

    public void setTextsite(String textsite) {
        this.textsite = textsite;
    }
    
    

    public String getOtvetst() {
        return otvetst;
    }

    public void setOtvetst(String otvetst) {
        this.otvetst = otvetst;
    }
    
    

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Razmeri getEndrazmeri() {
        return endrazmeri;
    }

    public void setEndrazmeri(Razmeri endrazmeri) {
        this.endrazmeri = endrazmeri;
    }
    
    

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public Model(Integer m) {
        model = m;
    }

    public Model() {
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public TipModel getTipmodel() {
        return tipmodel;
    }

    public void setTipmodel(TipModel tipmodel) {
        this.tipmodel = tipmodel;
    }

    public Razmeri getFirstrazmeri() {
        return firstrazmeri;
    }

    public void setFirstrazmeri(Razmeri firstrazmeri) {
        this.firstrazmeri = firstrazmeri;
    }

    public String getBeika() {
        return beika;
    }

    public void setBeika(String beika) {
        this.beika = beika;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Raskladchik getRaskladchik() {
        return raskladchik;
    }

    public void setRaskladchik(Raskladchik raskladchik) {
        this.raskladchik = raskladchik;
    }

    public Raskladchik getRaskladchik1() {
        return raskladchik1;
    }

    public void setRaskladchik1(Raskladchik raskladchik1) {
        this.raskladchik1 = raskladchik1;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
    
    
    
    
    
}
