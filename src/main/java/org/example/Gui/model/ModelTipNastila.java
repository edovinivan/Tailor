/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.TipNastila;
import org.example.util.IOTipNastila;

/**
 *
 * @author ivan
 */
public class ModelTipNastila extends AbstractTableModel
{
    List<TipNastila> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelTipNastila() {
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
                return list.get(rowIndex).getTipnastila();
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
        list = IOTipNastila.getListTipNastila(-1);
        fireTableDataChanged();
    }
}
