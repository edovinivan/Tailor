/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.analit.aRazmer;
import org.example.util.analit.IOAHelp;

/**
 *
 * @author ivan
 */
public class ModelARazmer  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<aRazmer> list = new ArrayList<>();
    

    public ModelARazmer() {
        listCol.add("ID");        
        listCol.add("Размер1C");          
        listCol.add("РазмерTailor");          
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
                return list.get(rowIndex).getA_razmer();            
            case 1: 
                return list.get(rowIndex).getName();            
            case 2: 
                return list.get(rowIndex).getRazmeri().getName();                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData()
    {
        list = IOAHelp.getListRazmer();
        fireTableDataChanged();
    }
}
