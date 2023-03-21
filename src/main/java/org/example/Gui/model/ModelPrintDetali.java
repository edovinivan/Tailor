/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.PrintDetali;
import org.example.util.IOPrintDetali;

/**
 *
 * @author ivan
 */
public class ModelPrintDetali extends AbstractTableModel{
    List<PrintDetali> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    int vid;
    
    public ModelPrintDetali(int v) {
        listCol.add("№");
        listCol.add("Название"); 
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
                return list.get(rowIndex).getPrintdetali();
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
        list = IOPrintDetali.getListPrintDetali(-1, vid);
        fireTableDataChanged();
    }
    
}
