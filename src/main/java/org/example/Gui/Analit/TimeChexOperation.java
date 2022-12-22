/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

/**
 *
 * @author ivan
 */
public class TimeChexOperation {
    int chex;
    int oper;
    String chexName;
    String operName;
    // сколько уже есть в цехе
    int qty_chex;
    // сколько в задаче
    int qty_pm;
    // сколько максимальное значение
    int qty_max;
    
    //сколько операций в цехе в настоящее время
    int qty_current;

    public int getQty_current() {
        return qty_current;
    }

    public void setQty_current(int qty_current) {
        this.qty_current = qty_current;
    }
    
    

    public String getChexName() {
        return chexName;
    }

    public void setChexName(String chexName) {
        this.chexName = chexName;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }
        
    public TimeChexOperation() {
    }

    public int getChex() {
        return chex;
    }

    public void setChex(int chex) {
        this.chex = chex;
    }

    public int getOper() {
        return oper;
    }

    public void setOper(int oper) {
        this.oper = oper;
    }

    public int getQty_chex() {
        return qty_chex;
    }

    public void setQty_chex(int qty_chex) {
        this.qty_chex = qty_chex;
    }

    public int getQty_pm() {
        return qty_pm;
    }

    public void setQty_pm(int qty_pm) {
        this.qty_pm = qty_pm;
    }

    public int getQty_max() {
        return qty_max;
    }

    public void setQty_max(int qty_max) {
        this.qty_max = qty_max;
    }

   
    
    
}
