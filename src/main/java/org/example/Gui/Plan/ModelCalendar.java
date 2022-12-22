/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PCalendar;
import org.example.util.HelpClass;
import org.example.util.plan.IOTimeOpChex;

/**
 *
 * @author ivan
 */
public class ModelCalendar  extends AbstractTableModel{
    List<PCalendar> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    
    public ModelCalendar() {
        listCol.add("#");
        listCol.add("Дата");
        listCol.add("Цех");
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
                return list.get(rowIndex).getPcalendar();
            case 1: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 2: 
                return list.get(rowIndex).getChex().getName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOTimeOpChex.getListPCalendar();
        fireTableDataChanged();
    }
    
}
