/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.OperationTextGruppa;
import org.example.util.IOOperationTextGruppa;

/**
 *
 * @author edovin.ivan
 */
public class ModelOperationTextGruppa extends AbstractTableModel{
    List<OperationTextGruppa> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelOperationTextGruppa() {
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
                return list.get(rowIndex).getOperationtextgruppa();
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
        list = IOOperationTextGruppa.getListOperationTextGruppa();
        fireTableDataChanged();
    }
    
}
