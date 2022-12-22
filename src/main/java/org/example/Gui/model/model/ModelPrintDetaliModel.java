/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ModelPrintDetali;
import org.example.util.IOModel;

/**
 *
 * @author ivan
 */
public class ModelPrintDetaliModel    extends AbstractTableModel{
    List<ModelPrintDetali> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    int vid;
    
    public ModelPrintDetaliModel(int v) {
        listCol.add("№");
        listCol.add("Деталь");        
        listCol.add("PD");        
        vid = v;
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
                return list.get(rowIndex).getModelprintdetali();
            case 1: 
                return list.get(rowIndex).getPrintdetali().getName();
            case 2: 
                return list.get(rowIndex).getPrintdetali().getPrintdetali();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int model)
    {
        list = IOModel.getListModelPrintDetali(model, -1, vid);
        fireTableDataChanged();
    }
    
}
