/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PModelPlan;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class ModelModelPlan1 extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<PModelPlan> list = new ArrayList<>();
    

    public ModelModelPlan1() {        
        listCol.add("#");              //0     
        listCol.add("Артикул");        //6
        listCol.add("Цвет");           //7        
        listCol.add("Кол-во");         //9        
        listCol.add("%");           //12         
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
                return list.get(rowIndex).getPmodelplan();            
            case 1: 
                return list.get(rowIndex).getModel().getArticle();
            case 2: 
                return list.get(rowIndex).getColor().getName();            
            case 3: 
                return list.get(rowIndex).getSumqty()-list.get(rowIndex).getSumqtychex();            
            case 4: 
                return list.get(rowIndex).getSumqtychex()>0?1:0;    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return listCol.get(column);
    }
    
    
    public void setData(Date d1, Date d2)
    { 
        list = IOModelPlan.getListPModelPlan(d1, d2);
        fireTableDataChanged();
    }
    
    public void setDataModel(int mod, Date d1, Date d2)
    { 
        list = IOModelPlan.getListPModelForModel(mod, d1, d2);
        fireTableDataChanged();
    }
    
    /**
     * Получить нераспределенные задачи за периуд
     * @param d1
     * @param d2 
     */
    public void setDataForNoChex(Date d1, Date d2)
    { 
        list = IOModelPlan.getListPModelPlanForNoChex(d1, d2);
        fireTableDataChanged();
    }
    
    
}
