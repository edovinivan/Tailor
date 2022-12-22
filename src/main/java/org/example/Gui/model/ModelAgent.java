/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Agent;
import org.example.util.IOAgent;

/**
 *
 * @author ivan
 */
public class ModelAgent   extends AbstractTableModel{
    List<Agent> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelAgent(int v) {
        listCol.add("№");
        listCol.add("Название");  
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
                return list.get(rowIndex).getAgent();
            case 1: 
                return list.get(rowIndex).getName();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOAgent.getListAgent(-1, vid);
        fireTableDataChanged();
    }
    
    
    public void setDataAll()
    {
        list = IOAgent.getListAgent(-1, vid);
        list.add(new Agent(0 , "Нет"));
        fireTableDataChanged();
    }
    
    
    
}
