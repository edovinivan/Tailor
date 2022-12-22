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
public class ModelMPlan  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<String> list = new ArrayList<>();
    

    public ModelMPlan(int t) {        
        listCol.add("Операции");           //0 
        listCol.add("Время");           //1 
        
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
                return list.get(rowIndex).split("<!>")[0];
            case 1: 
                return new BigDecimal(list.get(rowIndex).split("<!>")[1]).setScale(0, RoundingMode.CEILING);
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return listCol.get(column);
    }
    
    
    public void setData(int m, int q)
    { 
        list = IOModelPlan.getTimeForModel(m, q);
        fireTableDataChanged();
    }
    
    
}
