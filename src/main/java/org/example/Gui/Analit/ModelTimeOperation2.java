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
import org.example.logic.plan.PTimeChex;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class ModelTimeOperation2  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<PTimeChex> list = new ArrayList<>();
    

    public ModelTimeOperation2() {        
        listCol.add("#");              //0 
        listCol.add("Артикул");             //1 
        listCol.add("Цвет");             //2 
        listCol.add("Цех");          //3
        listCol.add("Кол-во");          //4
        
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
                return list.get(rowIndex).getPtimechex();            
            case 1: 
                return list.get(rowIndex).getPmodelplan().getModel().getArticle();
            case 2: 
                return list.get(rowIndex).getPmodelplan().getColor().getName();
            case 3: 
                return list.get(rowIndex).getChex().getName();
            case 4: 
                return list.get(rowIndex).getQty();
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return listCol.get(column);
    }
    
    
    public void setData(Date d1, Date d2)
    { 
        list = IOModelPlan.getListPModelPlanForTime(d1, d2);
        fireTableDataChanged();
    }
    
    
    
}
