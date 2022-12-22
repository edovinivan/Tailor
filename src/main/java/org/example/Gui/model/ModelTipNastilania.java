/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.TipNastilania;
import org.example.util.IOTipNastila;

/**
 *
 * @author ivan
 */
public class ModelTipNastilania extends AbstractTableModel
{
    List<TipNastilania> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelTipNastilania() {
        listCol.add("№");
        listCol.add("Название");        
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
                return list.get(rowIndex).getTipnastilania();
            case 1: 
                return list.get(rowIndex).getName();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOTipNastila.getListTipNastilania(-1);
        fireTableDataChanged();
    }
    
}
