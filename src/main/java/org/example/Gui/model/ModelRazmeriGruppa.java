/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.RazmeriGruppa;
import org.example.util.IORazmeri;

/**
 *
 * @author ivan
 */
public class ModelRazmeriGruppa     extends AbstractTableModel{
    List<RazmeriGruppa > list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelRazmeriGruppa () {
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
                return list.get(rowIndex).getRazmerigruppa();
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
        list = IORazmeri.getListRazmeriGruppa(-1);
        fireTableDataChanged();
    }
    
}
