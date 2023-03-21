/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ModelKleevaya;
import org.example.util.IOModel;

/**
 *
 * @author ivan
 */
public class ModelKleevayaModel extends AbstractTableModel{
    List<ModelKleevaya> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelKleevayaModel() {
        listCol.add("№");
        listCol.add("Клеевая");        
        listCol.add("Кол-во");        
        listCol.add("Цвет");        
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
                return list.get(rowIndex).getModelkleevaya();
            case 1: 
                return list.get(rowIndex).getKleevaya().getName();
            case 2: 
                return list.get(rowIndex).getQty();    
            case 3: 
                return list.get(rowIndex).getColor();        
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int mod)
    {
        list = IOModel.getListModelKleevaya(mod, -1);
        fireTableDataChanged();
    }
    
}
