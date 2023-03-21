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

/**
 *
 * @author ivan
 */
public class ModelTimeChexOperation extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<TimeChexOperation> list = new ArrayList<>();
    

    public ModelTimeChexOperation() {           
        listCol.add("Цех");
        listCol.add("Гр.Операций");        
        listCol.add("Макс.");
        listCol.add("Цех");
        listCol.add("Арт");
        listCol.add("Now");
        
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
                return list.get(rowIndex).getChexName();
            case 1:
                return list.get(rowIndex).getOperName();
            case 2:
                return new BigDecimal(list.get(rowIndex).getQty_max()).divide(new BigDecimal(3600), 6, RoundingMode.CEILING).setScale(1, RoundingMode.HALF_UP);
            case 3:
                return new BigDecimal(list.get(rowIndex).getQty_chex()).divide(new BigDecimal(3600), 6, RoundingMode.CEILING).setScale(1, RoundingMode.HALF_UP);
                //return list.get(rowIndex).getQty_chex();
            case 4:
                return new BigDecimal(list.get(rowIndex).getQty_pm()).divide(new BigDecimal(3600), 6, RoundingMode.CEILING).setScale(1, RoundingMode.HALF_UP);
                
            case 5:
                return new BigDecimal(list.get(rowIndex).getQty_current()).divide(new BigDecimal(3600), 6, RoundingMode.CEILING).setScale(1, RoundingMode.HALF_UP);
                //return list.get(rowIndex).getQty_pm();                                   
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {        
        return listCol.get(column);
    }
    
    public void setDate(List<TimeChexOperation> ls)
    {
        list = ls;
        fireTableDataChanged();
    }
}
