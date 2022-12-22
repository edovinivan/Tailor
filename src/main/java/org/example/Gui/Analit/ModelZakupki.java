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
import org.example.logic.plan.PZakupki;
import org.example.util.plan.IOZakupki;

/**
 *
 * @author ivan
 */
public class ModelZakupki  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<PZakupki> list = new ArrayList<>();
    

    public ModelZakupki() {
        listCol.add("ID");        
        listCol.add("Статус");          
        listCol.add("Дата");          
        listCol.add("Дата закупки");          
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
                return list.get(rowIndex).getPzakupki();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getDate1();
            case 3: 
                return list.get(rowIndex).getDate2();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData(Date d1, Date d2)
    {
        list = IOZakupki.getListPZakupki(d1, d2);
        fireTableDataChanged();
    }
    
}
