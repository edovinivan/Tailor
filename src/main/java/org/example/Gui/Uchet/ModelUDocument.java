/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Uchet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Uchet.UDocument;
import org.example.util.Uchet.IOUchet;

/**
 *
 * @author ivan
 */
public class ModelUDocument  extends AbstractTableModel{
    List<UDocument> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelUDocument () {
        listCol.add("№");
        listCol.add("Операция");        
        listCol.add("Вид");                
        listCol.add("Дата");                
        listCol.add("Сумма");                
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
                return list.get(rowIndex).getUdocument();
            case 1: 
                return list.get(rowIndex).getUoperation().getName();
            case 2: 
                return list.get(rowIndex).getUoperation().getPm()==1?"Приход":"Расход";
            case 3: 
                return list.get(rowIndex).getDates();
            case 4: 
                return list.get(rowIndex).getSumma().setScale(2);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        list = IOUchet.getListUDocument(d1, d2);
        fireTableDataChanged();
    }
    
}
