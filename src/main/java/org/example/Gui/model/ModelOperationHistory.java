/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.OperationHistory;
import org.example.util.HelpClass;
import org.example.util.IOOperationHistory;

/**
 *
 * @author ivan
 */
public class ModelOperationHistory   extends AbstractTableModel{
    List<OperationHistory> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

  
    public ModelOperationHistory() {
        listCol.add("№");
        listCol.add("Дата");
        listCol.add("Операция");        
        listCol.add("Пользователь");        
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
                return list.get(rowIndex).getOperationhistory();
            case 1: 
                return HelpClass.getPrintDate3(list.get(rowIndex).getDates());
            case 2: 
                return list.get(rowIndex).getOperations();
            case 3: 
                return list.get(rowIndex).getOper().getName();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int vid, int doc)
    {
        list = IOOperationHistory.getListOperationHistory(doc, vid);
        fireTableDataChanged();
    }
    
    
    
}
