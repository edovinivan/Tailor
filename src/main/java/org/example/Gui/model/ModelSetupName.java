/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Operator;
import org.example.logic.OperatorSetup;
import org.example.logic.SetupName;
import org.example.util.IOOperator;

/**
 *
 * @author ivan
 */
public class ModelSetupName  extends AbstractTableModel{
    List<SetupName> list = new ArrayList<>();
    List<OperatorSetup> listS = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelSetupName() {
        listCol.add("№");
        listCol.add("Настройка");        
        listCol.add("R");        
        listCol.add("W");        
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
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if((Boolean)aValue)
        {
            if(columnIndex==2)
                list.get(rowIndex).setVal(1);
            if(columnIndex==3)
                list.get(rowIndex).setVal(2);    
            //list.get(rowIndex).setVal(columnIndex==2?2:2);
        }
        else
        {
            if(columnIndex==2)
                list.get(rowIndex).setVal(0);
            if(columnIndex==3)
                list.get(rowIndex).setVal(1);    
            //list.get(rowIndex).setVal(columnIndex==2?0:0);
        }
        fireTableDataChanged();
    }    
    

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex>1;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex>1)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }   
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getSetupname();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getVal()>0;
            case 3: 
                return list.get(rowIndex).getVal()>1;    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int o)
    {
        list = IOOperator.getListSetupName();
        listS = IOOperator.getListOperatorSetup(o);
        for(OperatorSetup s: listS)
        {
            for(SetupName n: list)
            {
                if(Objects.equals(n.getSetupname(), s.getSetupname().getSetupname()))
                    n.setVal(s.getVal());
            }
        }
        fireTableDataChanged();
    }
    
    /**
     * Получить список прав
     * @param o
     * @return 
     */
    public List<OperatorSetup> getOS(int o)
    {
        listS.clear();
        OperatorSetup p;
        for(SetupName s: list)
        {
            p = new OperatorSetup();
            p.setOperator(new Operator(o));
            p.setOperatorsetup(0);
            p.setSetupname(s);
            p.setVal(s.getVal());
            listS.add(p);            
        }
        return listS;
    }
    
}
