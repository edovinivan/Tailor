/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Operator;
import org.example.util.IOOperator;

/**
 *
 * @author ivan
 */
public class ModelOperator  extends AbstractTableModel{
    List<Operator> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelOperator() {
        listCol.add("№");
        listCol.add("ФИО");        
        listCol.add("Работник");        
        listCol.add("Подразделение");        
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
                return list.get(rowIndex).getOperator();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getRabotnik().getName();    
            case 3: 
                return list.get(rowIndex).getRabotnikgruppa().getName();    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOOperator.getListOperator(-1);
        fireTableDataChanged();
    }
    
}
