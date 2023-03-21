/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;
import org.example.util.analit.IOAnalitika;

/**
 *
 * @author ivan
 */
public class ModelTimeOfChex extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<TimeOfChex> list = new ArrayList<>();
    

    public ModelTimeOfChex() {   
        listCol.add("Цех");
        listCol.add("Гр.Операций");
        listCol.add("В цеху");
        listCol.add("Максимальное");
        listCol.add("Для маршрута");
        listCol.add("Старт");
        listCol.add("#");
    }   
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
                return list.get(rowIndex).getChexname();
            case 1:
                return list.get(rowIndex).operationgruppaname;    
            case 2:
                return list.get(rowIndex).getQtychex().setScale(0, RoundingMode.HALF_UP);    
            case 3:
                return list.get(rowIndex).getQtymax().setScale(0, RoundingMode.HALF_UP);    
            case 4:
                return list.get(rowIndex).getQtytimemodel().setScale(0, RoundingMode.HALF_UP);                        
            case 5:
                return list.get(rowIndex).getStart().setScale(1, RoundingMode.HALF_UP);                        
            case 6:
                return list.get(rowIndex).getOptima();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {        
        return listCol.get(column);
    }
    
    
    public void setData(int model, int qty)
    {  
        TimeOfChex t;
        String ss[];
        Map<Integer, BigDecimal> sh = new HashMap<>();
        for(String s: IOAnalitika.getTimeForModel(model, qty))
        {
            ss = s.split("<!>");
            t = new TimeOfChex();
            t.setChex(Integer.parseInt(ss[0]));
            t.setChexname(ss[1]);
            t.setOperationgruppa(Integer.parseInt(ss[2]));
            t.setOperationgruppaname(ss[3]);
            t.setQtymax(new BigDecimal(ss[5]));
            t.setQtychex(new BigDecimal(ss[4]));
            t.setQtytimemodel(new BigDecimal(ss[6]));
            t.setStart(t.getQtychex().divide(t.getQtymax().divide(new BigDecimal("30"), 6, RoundingMode.HALF_UP),6, RoundingMode.HALF_UP ));
            t.setOptima(0);
            list.add(t);
            // если нужно выполнять операции по данной группе операций
            if(t.getQtytimemodel().signum()>0)
            {
                // если еще нет этого значения цеха то добавим новое
                if (!sh.containsKey(t.getChex())) 
                {
                    sh.put(t.getChex(), t.getStart());
                }
                else
                {
                    if(sh.get(t.getChex()).compareTo(t.getStart())<0)
                        sh.put(t.getChex(), t.getStart());
                }
            }
        }    
        
        int cm = 0;
        BigDecimal tm = BigDecimal.ZERO;
        int i=0;
        for (Map.Entry entry : sh.entrySet()) 
        {
            if(i==0)
            {
                cm = (int) entry.getKey();
                tm = (BigDecimal) entry.getValue();
            }
            if(tm.compareTo((BigDecimal) entry.getValue())>0)
            {
                cm = (int) entry.getKey();
                tm = (BigDecimal) entry.getValue();
            }
            i++;
        }
        for(TimeOfChex r: list)
        {
            if(r.getChex()==cm)
            {
                r.setOptima(1);
                if(r.getStart().compareTo(tm)==0)
                    r.setOptima(2);
            }
        }
        //System.out.println("CM = " + cm + "VAL = " + tm.toString());
        fireTableDataChanged();
    }
    
}
