/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle;

import java.math.BigDecimal;

/**
 *
 * @author ivan
 * Отображение полотен нужных для задачи
 */
public class MapProjectProduct {
    
    int id;
    String product;
    String color;
    BigDecimal qty;
    boolean check;
    String articles;

    public MapProjectProduct(int id, String product, String color, BigDecimal qty, String articles) {
        this.id = id;
        this.product = product;
        this.color = color;
        this.qty = qty;
        this.check = true;
        this.articles = articles;
    }

    public String getArticles() {
        return articles;
    }

    public void setArticles(String articles) {
        this.articles = articles;
    }
    
    
    

    public MapProjectProduct() {
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
    
    
    
}
