/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Form.Report;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Agent;
import org.example.logic.Report;
import org.example.util.IOAgent;
import org.example.util.IOReport;

/**
 *
 * @author ivan
 */
public class ModelReport  extends AbstractTableModel{
    List<Report> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelReport() {
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
                return list.get(rowIndex).getReport();
            case 1: 
                return list.get(rowIndex).getName();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int tip)
    {
        list = IOReport.getListReport(tip);
        fireTableDataChanged();
    }
    
}
