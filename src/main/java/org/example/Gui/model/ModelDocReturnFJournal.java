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
import org.example.logic.DocReturnFJournal;
import org.example.util.IODocReturnF;

/**
 *
 * @author ivan
 */
public class ModelDocReturnFJournal  extends AbstractTableModel{
    List<DocReturnFJournal> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelDocReturnFJournal() {
        listCol.add("№");        
        listCol.add("Паспорт");
        listCol.add("Фурнитура");
        listCol.add("Цвет");
        listCol.add("Цена"); 
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
                return list.get(rowIndex).getDocreturnfjournal();
            case 1: 
                return list.get(rowIndex).getScladproduct().getPasport();        
            case 2: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();    
            case 3: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 4: 
                return list.get(rowIndex).getScladproduct().getPrice().setScale(2, RoundingMode.HALF_UP);                        
            case 5: 
                return list.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_UP);    
            case 6: 
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
        list = IODocReturnF.getListDocReturnFJournalForDocument(doc);
        fireTableDataChanged();
    }
    
}
