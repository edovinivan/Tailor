/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Uchet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Uchet.UOperation;
import org.example.util.Uchet.IOUchet;

/**
 *
 * @author ivan
 */
public class ModelUOperation  extends AbstractTableModel{
    List<UOperation> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelUOperation() {
        listCol.add("№");
        listCol.add("Операция");        
        listCol.add("Вид");                
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
                return list.get(rowIndex).getUoperation();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getPm()==1?"Приход":"Расход";
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOUchet.getListUOperation();
        fireTableDataChanged();
    }
    
}
