/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.DocumentReturn;
import org.example.util.HelpClass;
import org.example.util.IODocument;

/**
 *
 * @author ivan
 */
public class ModelDocumentReturn  extends AbstractTableModel{
    List<DocumentReturn> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    int vid;
    /**
     * 
     * @param v вид
     */
    public ModelDocumentReturn(int v) {
        listCol.add("№");
        listCol.add("Паспорт");
        if(v==1)
            listCol.add("Полотно");
        else
            listCol.add("Фурнитура");
        listCol.add("Цвет");
        if(v==1)
            listCol.add("Вес");        
        else
            listCol.add("Кол-во");        
        listCol.add("Агент");
        listCol.add("Дата");
        listCol.add("Текст");
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
                return list.get(rowIndex).getDocumentreturn();
            case 1: 
                return list.get(rowIndex).getScladproduct().getPasport();    
            case 2: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();
            case 3: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 4: 
                if(vid==1)
                    return list.get(rowIndex).getScladproduct().getVes().setScale(2, RoundingMode.HALF_EVEN);
                else
                    return list.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_EVEN);
            case 5: 
                return list.get(rowIndex).getAgent().getName();            
            case 6: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 7: 
                return list.get(rowIndex).getText();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d)
    {
        list = IODocument.getListDocumentReturn(d, vid);
        fireTableDataChanged();
    }
    
}
