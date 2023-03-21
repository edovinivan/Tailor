/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.MModelProperty;
import org.example.util.IOMProperty;

/**
 *
 * @author ivan
 */
public class ModelMModelProperty  extends AbstractTableModel{
    List<MModelProperty> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelMModelProperty() {
        listCol.add("№");
        listCol.add("Артикул");        
        listCol.add("Характеристика");        
        listCol.add("Значение");        
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
                return list.get(rowIndex).getMmodelproperty();
            case 1: 
                return list.get(rowIndex).getModel().getArticle();
            case 2: 
                return list.get(rowIndex).getMproperty().getName();    
            case 3: 
                return list.get(rowIndex).getValuest();    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOMProperty.getListMModelProperty();
        fireTableDataChanged();
    }
    
}
