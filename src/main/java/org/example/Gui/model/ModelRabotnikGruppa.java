/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.RabotnikGruppa;
import org.example.util.IORabotnik;

/**
 *
 * @author ivan
 */
public class ModelRabotnikGruppa extends AbstractTableModel{
    List<RabotnikGruppa> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelRabotnikGruppa() {
        listCol.add("№");
        listCol.add("Название");        
        listCol.add("Швейный цех");        
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
                return list.get(rowIndex).getRabotnikgruppa();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getGruppa()==1;    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==2)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void setData()
    {
        list = IORabotnik.getListRabotnikGruppa(-1);
        fireTableDataChanged();
    }
    
    /**
     * только швейные цеха
     */
    public void setDataChex()
    {
        list = IORabotnik.getListRabotnikGruppaChex();
        fireTableDataChanged();
    }
    
}
