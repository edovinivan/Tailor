/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Operation;
import org.example.util.IOModel;
import org.example.util.IOOperation;

/**
 *
 * @author ivan
 */
public class ModelOperation   extends AbstractTableModel{
    List<Operation> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelOperation() {
        listCol.add("№");
        listCol.add("Название");        
        listCol.add("Группа");        
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
                return list.get(rowIndex).getOperation();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getOperationgruppa().getName();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOOperation.getListOperation(-1);
        fireTableDataChanged();
    }
    
    public void setDataForModel(int m)
    {
        list.clear();
        Operation o;
        for(org.example.logic.ModelOperation mo: IOModel.getListModelOperation(m, -1))
        {
            o = mo.getOperation();
            o.setOperation(mo.getModeloperation());
            list.add(o);
        }
        //list = IOOperation.getListOperation(-1);
        fireTableDataChanged();
    }
    
}
