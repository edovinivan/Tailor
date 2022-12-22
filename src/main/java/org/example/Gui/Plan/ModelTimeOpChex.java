/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PTimeOpChex;
import org.example.util.plan.IOTimeOpChex;

/**
 *
 * @author ivan
 */
public class ModelTimeOpChex extends AbstractTableModel{
    List<PTimeOpChex> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelTimeOpChex() {
        listCol.add("#");
        listCol.add("№");
        listCol.add("Цех");
        listCol.add("Операция");
        listCol.add("Время");        
    }   
    
    public void setVid(int vd)
    {
        vid = vd;
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
                return list.get(rowIndex).getPtimeopchex();
            case 1: 
                return rowIndex + 1;
            case 2: 
                return list.get(rowIndex).getChex().getName();
            case 3: 
                return list.get(rowIndex).getOperationgruppa().getName();
            case 4: 
                return list.get(rowIndex).getTimes();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOTimeOpChex.getListPTimeOpChex(0);
        fireTableDataChanged();
    }
    
}
