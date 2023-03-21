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
import org.example.logic.Document;
import org.example.util.HelpClass;
import org.example.util.IODocument;

/**
 *
 * @author ivan
 */
public class ModelDocument  extends AbstractTableModel{
    List<Document> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelDocument(int v) {
        listCol.add("№");
        listCol.add("Статус");
        listCol.add("Номер");
        listCol.add("Дата");        
        listCol.add("Фирма");
        listCol.add("Строк");
        listCol.add("Сумма");
        listCol.add("Вес");
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
                return list.get(rowIndex).getDocument();
            case 1: 
                return list.get(rowIndex).getStatus();    
            case 2: 
                return list.get(rowIndex).getNomer();
            case 3: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());            
            case 4: 
                return list.get(rowIndex).getAgent().getName();            
            case 5: 
                return list.get(rowIndex).getCounts();            
            case 6:
                return list.get(rowIndex).getDsumma().setScale(2, RoundingMode.HALF_UP);
            case 7:
                return list.get(rowIndex).getDves().setScale(2, RoundingMode.HALF_UP);
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        list = IODocument.getListDocument(vid, d1, d2);
        fireTableDataChanged();
    }
    
    public void setData()
    {
        list = IODocument.getListDocumentForReturnSclad();
        fireTableDataChanged();
    }
    
}
