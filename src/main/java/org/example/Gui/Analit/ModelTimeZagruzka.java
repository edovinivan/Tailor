/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.analit.Get_TimeOp_for_ModelPlan;
import org.example.util.analit.IOAnalitika;

/**
 *
 * @author ivan
 */
public class ModelTimeZagruzka extends AbstractTableModel{
     
    List<String> listCol = new ArrayList<>();
    List<Get_TimeOp_for_ModelPlan> list = new ArrayList<>();
    

    public ModelTimeZagruzka() {     
        listCol.add("ID");
        listCol.add("Операции");
        listCol.add("Максимальное");
        listCol.add("Запланированно");
        listCol.add("В задаче");
        
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
                return list.get(rowIndex).getId();
            case 1: 
                return list.get(rowIndex).getOpname();
            case 2: 
                return list.get(rowIndex).getMaxt().longValue();
            case 3: 
                return list.get(rowIndex).getQtyop().longValue();                        
            case 4: 
                return list.get(rowIndex).getQtymplan().longValue();
                
        }
        return null; 
    }

    @Override
    public String getColumnName(int column) {        
        return listCol.get(column);
    }
    
    
    public void setData(int mp, Date d1,Date d2)
    {
        list = IOAnalitika.getGet_TimeOp_for_ModelPlan(mp, d1, d2);
        fireTableDataChanged();
    }
    
}
