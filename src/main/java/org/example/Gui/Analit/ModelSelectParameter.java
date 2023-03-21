/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class ModelSelectParameter  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<parameterSelect> list = new ArrayList<>();
    

    public ModelSelectParameter() {        
        listCol.add("№");            //0 
        listCol.add("Параметр");      //0 
        listCol.add("Выбор");         //1 
        
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
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==2)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==2)
        {
            list.get(rowIndex).setSelect((boolean)aValue?1:0);
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getParameter();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getSelect()==1;            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return listCol.get(column);
    }
    
    
    public void setData(List<parameterSelect> ls)
    { 
        list = ls;
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==2;
    }
    
    
    public List<parameterSelect> getData()
    {
        return list;
    }
    
    //снять со всех выделение
    public void selectAllNull()
    {
        for(parameterSelect p: list)
            p.setSelect(0);
        fireTableDataChanged();
    }
    //выделить все
    public void selectAllTrue()
    {
        for(parameterSelect p: list)
            p.setSelect(1);
        fireTableDataChanged();
    }
    
    
}
