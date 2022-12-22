/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle.Model;

import java.util.Date;

/**
 *
 * @author ivan
 */
public class MapJournal implements Comparable<MapJournal>{
    int id;
    int status;
    String article;
    String color;
    String razmer;
    int qty;
    Date date;
    int sale;
    int balance;
    int inwork;  
    int salemoney;

    public MapJournal() {
    }

    public MapJournal(int id, int status, String article, String color, int qty, Date date, String razmer,  int sale, int balance, int inwork, int salemoney) {
        this.id = id;
        this.status = status;
        this.article = article;
        this.color = color;
        this.qty = qty;
        this.date = date;
        this.razmer = razmer;
        this.sale = sale;
        this.balance = balance;
        this.inwork = inwork;
        this.salemoney = salemoney;
    }
    
    /**
     * Расчетное количество
     * 
     * @return sale - balance - inwork
     */
    public int getQtyCalculating(){
        return sale - balance - inwork;
    }

    public String getRazmer() {
        return razmer;
    }

    public void setRazmer(String razmer) {
        this.razmer = razmer;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getInwork() {
        return inwork;
    }

    public void setInwork(int inwork) {
        this.inwork = inwork;
    }

    public int getSalemoney() {
        return salemoney;
    }

    public void setSalemoney(int salemoney) {
        this.salemoney = salemoney;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(MapJournal n) {
        return this.getArticle().compareTo(n.getArticle());
        
    }
}
