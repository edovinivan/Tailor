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
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

/**
 *
 * @author ivan
 */
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "GETPRODUCTANALIZNOVINKA",
	query = "select MODEL, ARTICLE, QTY, SUMMA, MINPRICE, MAXPRICE, LPRINT, LVISHIVKA, LFURNIT, LMODEL, ID, LDOPPAR, TIPPROD, ISSELECT from GET_PRODUCT_FOR_ANALIZ_NOVINKA(:G1, :G2, :D1, :D2) order by SUMMA desc",        
	resultClass = GetProductAnalizNovinka.class
	)
})
@Entity
public class GetProductAnalizNovinka implements Serializable {
    @Id
    @Column(name = "ID")
    Integer id;
    
    @Column(name = "MODEL")
    Integer model;
    
    @Column(name = "ARTICLE")
    String article;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "SUMMA")
    BigDecimal summa;
    
    @Column(name = "MINPRICE")
    BigDecimal minprice;
    
    @Column(name = "MAXPRICE")
    BigDecimal maxprice;
    
    @Column(name = "LPRINT")
    String lprint;
    
    @Column(name = "LVISHIVKA")
    String lvishivka;
    
    @Column(name = "LFURNIT")
    String lfurnit;
    
    @Column(name = "LMODEL")
    String lmodel;
    
    @Column(name = "LDOPPAR")
    String ldoppar;
    
    @Column(name = "TIPPROD")
    String tipprod;
    
    @Column(name = "ISSELECT")
    Integer isselect;
    
    @Transient
    Integer hint;   

    public Integer getHint() {
        return hint;
    }

    public void setHint(Integer hint) {
        this.hint = hint;
    }
    
    

    public Integer getIsselect() {
        return isselect;
    }

    public void setIsselect(Integer isselect) {
        this.isselect = isselect;
    }
    
    

    public String getTipprod() {
        return tipprod;
    }

    public void setTipprod(String tipprod) {
        this.tipprod = tipprod;
    }
    
    

    public GetProductAnalizNovinka() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public BigDecimal getMinprice() {
        return minprice;
    }

    public void setMinprice(BigDecimal minprice) {
        this.minprice = minprice;
    }

    public BigDecimal getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(BigDecimal maxprice) {
        this.maxprice = maxprice;
    }

    public String getLprint() {
        return lprint;
    }

    public void setLprint(String lprint) {
        this.lprint = lprint;
    }

    public String getLvishivka() {
        return lvishivka;
    }

    public void setLvishivka(String lvishivka) {
        this.lvishivka = lvishivka;
    }

    public String getLfurnit() {
        return lfurnit;
    }

    public void setLfurnit(String lfurnit) {
        this.lfurnit = lfurnit;
    }

    public String getLmodel() {
        return lmodel;
    }

    public void setLmodel(String lmodel) {
        this.lmodel = lmodel;
    }

    public String getLdoppar() {
        return ldoppar;
    }

    public void setLdoppar(String ldoppar) {
        this.ldoppar = ldoppar;
    }
    
    
    
}
