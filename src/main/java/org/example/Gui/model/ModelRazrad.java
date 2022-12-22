/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Razrad;
import org.example.util.IORazrad;

/**
 *
 * @author ivan
 */
public class ModelRazrad  extends AbstractTableModel{
    List<Razrad> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelRazrad () {
        listCol.add("#");        
        listCol.add("№");
        listCol.add("Цена за час");                
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
                return list.get(rowIndex).getRazrad();
            case 1: 
                return list.get(rowIndex).getNom();    
            case 2: 
                return list.get(rowIndex).getSumma().setScale(2, RoundingMode.HALF_EVEN);
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IORazrad.getListRazrad(-1);
        fireTableDataChanged();
    }
    
}
