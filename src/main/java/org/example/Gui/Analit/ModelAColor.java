/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.analit.aColor;
import org.example.util.analit.IOAHelp;

/**
 *
 * @author ivan
 */
public class ModelAColor  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<aColor> list = new ArrayList<>();
    

    public ModelAColor() {
        listCol.add("IDA");        
        listCol.add("Цвет1С");  
        listCol.add("ЦветТ");       
        listCol.add("IDT");       
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
                return list.get(rowIndex).getA_color();            
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                if(list.get(rowIndex).getColor().getColor()==0)
                    return "";
                return list.get(rowIndex).getColor().getName();            
            case 3: 
                return list.get(rowIndex).getColor().getColor();                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData()
    {
        list = IOAHelp.getListColor();
        fireTableDataChanged();
    }
 
    public void updateVals(int ac, aColor a)
    {
        list.set(ac, a);
        fireTableDataChanged();
    }
}
