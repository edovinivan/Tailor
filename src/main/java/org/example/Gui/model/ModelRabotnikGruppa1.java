/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ModelChex;
import org.example.logic.RabotnikGruppa;
import org.example.util.IOModel;
import org.example.util.IORabotnik;

/**
 *
 * @author ivan
 */
public class ModelRabotnikGruppa1 extends AbstractTableModel{
    List<RabotnikGruppa> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    boolean edit = true;
    
    public void stop_edit()
    {
        edit = false;
    }
      
    int model = 0;
    
    public ModelRabotnikGruppa1() {
        listCol.add("№");
        listCol.add("Швейный цех");        
        listCol.add("Исп.");        
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

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(!edit)
            return false;
        return columnIndex==2;
    }
    
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==2)
        {
            //(boolean)aValue
            list.get(rowIndex).setGruppa((boolean)aValue?1:0);
            IOModel.setModelChexForModelAndChex(model, list.get(rowIndex).getRabotnikgruppa() , (boolean)aValue?1:0);
            
        }
        else
            super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }   
    
    
    /**
     * только швейные цеха
     * @param m
     */
    public void setDataChex(int m)
    {
        model = m;
        list = IORabotnik.getListRabotnikGruppaChex();
        List<ModelChex> ls = IOModel.getListModelChexForModel(m);
        for(RabotnikGruppa r: list)
        {
            r.setGruppa(0);
            for(ModelChex l: ls)
            {
                if(l.getChex().getRabotnikgruppa().intValue() == r.getRabotnikgruppa().intValue())
                {
                    if(l.getVals()==1)
                        r.setGruppa(1);
                }
            }
        }
        fireTableDataChanged();
    }
    
}
