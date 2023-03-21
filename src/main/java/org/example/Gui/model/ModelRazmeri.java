/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Razmeri;
import org.example.util.IORazmeri;

/**
 *
 * @author ivan
 */
public class ModelRazmeri      extends AbstractTableModel{
    List<Razmeri> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelRazmeri () {
        listCol.add("#");        
        listCol.add("№");
        listCol.add("Название");        
        listCol.add("Группа");        
        listCol.add("Размер1С");                
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
                return list.get(rowIndex).getRazmeri();
            case 1: 
                return list.get(rowIndex).getNom();    
            case 2: 
                return list.get(rowIndex).getName();
            case 3: 
                return list.get(rowIndex).getRazmerigruppa().getName();    
            case 4: 
                return list.get(rowIndex).getArazmer().getName();    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IORazmeri.getListRazmeri(-1);
        fireTableDataChanged();
    }
    
    
    /**
     * Размеры для модели
     * @param model_id 
     */
    public void setData(int model_id)
    {
        list = IORazmeri.getListRazmeriForArticle(model_id);
        fireTableDataChanged();
    }
}