/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.logic.analit;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

/**
 *
 * @author ivan
 */
@NamedNativeQueries({
	@NamedNativeQuery(
	name = "A_GET_GRUPPA2",
	query = "select ART, ART_ART, ART_NAME, SPRICE, QTY, NOST, PLANS from A_GET_GRUPPA2(:G1, :G2, :D1, :D2, :D3, :D4, :IK) order by sprice",        
	resultClass = aGetGruppa2.class
	)
})
@Entity
//@Table(name = "aJ")
public class aGetGruppa2 implements Serializable {
    @Id
    @Column(name = "ART")
    Integer art;
    
    @Column(name = "ART_ART")
    String article;
    
    @Column(name = "ART_NAME")
    String art_name;
    
    @Column(name = "SPRICE")
    BigDecimal sprice;
    
    @Column(name = "QTY")
    BigDecimal qty;
    
    @Column(name = "NOST")
    Integer nost;
    
    @Column(name = "PLANS")
    Integer plans;

    public Integer getPlans() {
        return plans;
    }

    public void setPlans(Integer plans) {
        this.plans = plans;
    }
    
    

    public Integer getNost() {
        return nost;
    }

    public void setNost(Integer nost) {
        this.nost = nost;
    }
    
    

    public aGetGruppa2() {
    }

    public Integer getArt() {
        return art;
    }

    public void setArt(Integer art) {
        this.art = art;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArt_name() {
        return art_name;
    }

    public void setArt_name(String art_name) {
        this.art_name = art_name;
    }

    public BigDecimal getSprice() {
        return sprice.multiply(new BigDecimal("-1"));
    }

    public void setSprice(BigDecimal sprice) {
        this.sprice = sprice;
    }

    public BigDecimal getQty() {
        return qty.multiply(new BigDecimal("-1"));
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
    
    
}
