/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Measure;
import org.example.util.IOProduct;

/**
 *
 * @author ivan
 */
public class ModelMeasure    extends AbstractTableModel{
    List<Measure> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelMeasure() {
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
                return list.get(rowIndex).getMeasure();
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
        list = IOProduct.getListMeasure(-1);
        fireTableDataChanged();
    }
    
}
