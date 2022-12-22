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
import org.example.logic.DocReturnJournal;
import org.example.util.IODocReturn;

/**
 *
 * @author ivan
 */
public class ModelDocReturnJournal  extends AbstractTableModel{
    List<DocReturnJournal> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelDocReturnJournal() {
        listCol.add("№");        
        listCol.add("Паспорт");
        listCol.add("Полотно");
        listCol.add("Цвет");
        listCol.add("Цена"); 
        listCol.add("Длина");
        listCol.add("Вес");
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
                return list.get(rowIndex).getDocreturnjournal();
            case 1: 
                return list.get(rowIndex).getScladproduct().getPasport();        
            case 2: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();    
            case 3: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 4: 
                return list.get(rowIndex).getScladproduct().getPrice().setScale(2, RoundingMode.HALF_UP);                        
            case 5: 
                return list.get(rowIndex).getScladproduct().getLight().setScale(2, RoundingMode.HALF_UP);    
            case 6: 
                return list.get(rowIndex).getScladproduct().getVes().setScale(2, RoundingMode.HALF_UP);
            case 7: 
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
        list = IODocReturn.getListDocReturnJournalForDocument(doc);
        fireTableDataChanged();
    }
    
}
