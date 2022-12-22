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
import org.example.logic.DocumentJournal;
import org.example.util.IODocument;

/**
 *
 * @author ivan
 */
public class ModelDocumentJournal   extends AbstractTableModel{
    List<DocumentJournal> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelDocumentJournal(int v) {
        vid = v;
        listCol.add("№");        
        listCol.add("Паспорт");
        listCol.add(vid == 1?"Полотно":"Фурнитура");
        listCol.add("Цвет");
        listCol.add("Цена");
        listCol.add(vid==1?"ШиринаП":"Кол-во");
        listCol.add(vid==1?"Ширина":"Кол-во");
        listCol.add("ДлинаП");
        listCol.add("Длина");
        listCol.add("Вес");
        listCol.add("МестоХранения");        
        listCol.add("П");        
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
                return list.get(rowIndex).getDocumentjournal();
            case 1: 
                return list.get(rowIndex).getPasport();        
            case 2: 
                return list.get(rowIndex).getProduct().getName();    
            case 3: 
                return list.get(rowIndex).getColor().getName();
            case 4: 
                return list.get(rowIndex).getPrice().setScale(2, RoundingMode.HALF_UP);
            case 5: 
                return list.get(rowIndex).getWidthtemp().setScale(1, RoundingMode.HALF_EVEN);    
            case 6: 
                return list.get(rowIndex).getWidth().setScale(1, RoundingMode.HALF_EVEN);
            case 7: 
                return list.get(rowIndex).getLighttemp().setScale(2, RoundingMode.HALF_UP);
            case 8: 
                return list.get(rowIndex).getLight().setScale(2, RoundingMode.HALF_UP);    
            case 9: 
                return list.get(rowIndex).getVes().setScale(2, RoundingMode.HALF_UP);
            case 10: 
                return list.get(rowIndex).getSclad().getName();
            case 11: 
                return list.get(rowIndex).getStatus();    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int doc)
    {
        list = IODocument.getListDocumentJournal(doc);
        fireTableDataChanged();
    }
    
}
