/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.example.logic.analit.aGetGruppa2;
import org.example.util.analit.IOAnalitika;

/**
 *
 * @author ivan
 */
public class SalePeriod {
    
    // начало периода
    private Date d1;
    // конец периода
    private Date d2;
    // список продаж
    private List<aGetGruppa2> list = new ArrayList<>();
    
    public void setData(int g1, int g2, int ver, Date d3, Date d4, int ik)
    {
        if(ver == 2)
            list = IOAnalitika.getGruppa2_v2(g1, g2, d1, d2, d3, d4, ik);
        else
            list = IOAnalitika.getGruppa2(g1, g2, d1, d2);
        //System.out.println(list.size());
    }

    public SalePeriod() {
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

    public List<aGetGruppa2> getList() {
        return list;
    }

    public void setList(List<aGetGruppa2> list) {
        
        this.list = list;
    }
    
    
    
}
