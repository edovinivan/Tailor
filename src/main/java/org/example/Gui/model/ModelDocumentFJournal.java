/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.DocumentFJournal;
import org.example.util.IODocumentF;

/**
 *
 * @author ivan
 */
public class ModelDocumentFJournal   extends AbstractTableModel{
    List<DocumentFJournal> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelDocumentFJournal() {
        listCol.add("№");                
        listCol.add("Фурнитура");
        listCol.add("Цвет");        
        listCol.add("Кол-во");        
        listCol.add("МестоХранения");                
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
                return list.get(rowIndex).getDocumentfjournal();
            case 1: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();        
            case 2: 
                return list.get(rowIndex).getScladproduct().getColor().getName();    
            case 3: 
                return list.get(rowIndex).getQty().setScale(2);
            case 4: 
                return list.get(rowIndex).getScladproduct().getSclad().getName();            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int doc)
    {
        list = IODocumentF.getListDocumentFJournal(doc);
        fireTableDataChanged();
    }
    
}
