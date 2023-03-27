/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.OperationTextGruppaJournal;
import org.example.util.IOOperationTextGruppa;

/**
 *
 * @author edovin.ivan
 */
public class ModelOperationTextGruppaJournal extends AbstractTableModel{
    List<OperationTextGruppaJournal> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelOperationTextGruppaJournal() {
        listCol.add("#");
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
                return list.get(rowIndex).getOperationtextgruppajournal();
            case 1: 
                return list.get(rowIndex).getNom();
            case 2: 
                return list.get(rowIndex).getText();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int grup)
    {
        list = IOOperationTextGruppa.getListOperationTextGruppaJournal(grup);
        fireTableDataChanged();
    }
    
}
