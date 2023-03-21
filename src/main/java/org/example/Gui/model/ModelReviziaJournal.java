/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ReviziaJournal;
import org.example.util.HelpClass;
import org.example.util.IORevizia;

/**
 *
 * @author ivan
 */
public class ModelReviziaJournal  extends AbstractTableModel{
    List<ReviziaJournal> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public boolean stop_edit = true;
    
    public ModelReviziaJournal() {
        listCol.add("№");        
        listCol.add("Паспорт");
        listCol.add("Полотно");
        listCol.add("Цвет");                
        listCol.add("ВесБД");
        listCol.add("ВесНашли");
        listCol.add("Отклонение");
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
                return list.get(rowIndex).getReviziajournal();
            case 1: 
                return list.get(rowIndex).getScladproduct().getPasport();        
            case 2: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();    
            case 3: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 4: 
                return list.get(rowIndex).getVesdb().setScale(2, RoundingMode.HALF_UP);                        
            case 5: 
                return list.get(rowIndex).getVes().setScale(2, RoundingMode.HALF_UP);                
            case 6: 
                return list.get(rowIndex).getVes().subtract(list.get(rowIndex).getVesdb()).setScale(2, RoundingMode.HALF_UP);                    
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
        list = IORevizia.getListReviziaJournalForRevizia(doc);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(stop_edit)
            return columnIndex==5;
        else
            return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        if(HelpClass.checkTextForBigDecimal(aValue.toString()))
        {
            if(HelpClass.GetBigDecimalIzText(aValue.toString()).signum()<0)
                aValue = "0";
            list.get(rowIndex).setVes(HelpClass.GetBigDecimalIzText(aValue.toString()));
            IORevizia.updateQtyForReviziaJournal(list.get(rowIndex).getReviziajournal(), HelpClass.GetBigDecimalIzText(aValue.toString()));
            fireTableDataChanged();
        }        
    }
    
    
    public void updateQty(int rj, BigDecimal qty)
    {
        for(ReviziaJournal r: list)
        {
            if(r.getReviziajournal() == rj)
            {
                r.setVes(qty);
                IORevizia.updateQtyForReviziaJournal(rj, qty);
                fireTableDataChanged();
            }
        }        
    }
    
    
}
