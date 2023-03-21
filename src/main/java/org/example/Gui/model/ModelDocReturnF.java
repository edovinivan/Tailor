/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.DocReturnF;
import org.example.util.HelpClass;
import org.example.util.IODocReturn;
import org.example.util.IODocReturnF;

/**
 *
 * @author ivan
 */
public class ModelDocReturnF extends AbstractTableModel{
    List<DocReturnF> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelDocReturnF() {
        listCol.add("№");
        listCol.add("Статус");
        listCol.add("Номер");
        listCol.add("Дата");        
        listCol.add("Фирма");        
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
                return list.get(rowIndex).getDocreturnf();
            case 1: 
                return list.get(rowIndex).getStatus();    
            case 2: 
                return list.get(rowIndex).getNomer();
            case 3: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());            
            case 4: 
                return list.get(rowIndex).getAgent().getName();                     
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        list = IODocReturnF.getListDocReturnF(d1, d2);
        fireTableDataChanged();
    }
    
}
