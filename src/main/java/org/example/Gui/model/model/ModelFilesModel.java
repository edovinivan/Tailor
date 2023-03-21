/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ModelFiles;
import org.example.util.IOModel;

/**
 *
 * @author ivan
 */
public class ModelFilesModel extends AbstractTableModel{
    List<ModelFiles> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelFilesModel() {
        listCol.add("№");
        listCol.add("Гл");
        listCol.add("Файл");        
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
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==1)
            return Boolean.class;
        else
            return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getModelfiles();
            case 1: 
                return list.get(rowIndex).getHaupt()==1;
            case 2: 
                return list.get(rowIndex).getFiles().getName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int mod)
    {
        list = IOModel.getListModelFiles(mod, 0);
        fireTableDataChanged();
    }

    
}
