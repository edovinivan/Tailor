/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.Date;

/**
 *
 * @author ivan
 */
public class datePrognoz {
    int id;
    /**
     * Дата закупок
     */
    Date d1;
    /**
     * Дата производства
     */
    Date d2;
    /**
     * Дата начала продаж
     */
    Date d3;   
    
    /**
     * Дата окончания продаж
     */
    Date d6;   
    
    /**
     * Дата начала анализа
     */
    Date d4;   
    
    /**
     * Дата окончания анализа
     */
    Date d5;   
    
    int pmodel;
    
    boolean isRead;

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    

    public int getPmodel() {
        return pmodel;
    }

    public void setPmodel(int pmodel) {
        this.pmodel = pmodel;
    }
        

    public Date getD4() {
        return d4;
    }

    public void setD4(Date d4) {
        this.d4 = d4;
    }

    public Date getD5() {
        return d5;
    }

    public void setD5(Date d5) {
        this.d5 = d5;
    }
    
    

    public datePrognoz() {
        pmodel = 0;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getD1() {
        return d1;
    }

    public void setD1(Date d1) {
        this.d1 = d1;
    }

    public Date getD2() {
        return d2;
    }

    public void setD2(Date d2) {
        this.d2 = d2;
    }

    public Date getD3() {
        return d3;
    }

    public void setD3(Date d3) {
        this.d3 = d3;
    }

    public Date getD6() {
        return d6;
    }

    public void setD6(Date d6) {
        this.d6 = d6;
    }
    
    
}
