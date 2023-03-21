/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Revizia;
import org.example.util.HelpClass;
import org.example.util.IODocReturn;
import org.example.util.IORevizia;

/**
 *
 * @author ivan
 */
public class ModelRevizia  extends AbstractTableModel{
    List<Revizia> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelRevizia() {
        listCol.add("№");
        listCol.add("Статус");
        listCol.add("Номер");
        listCol.add("Дата");                
        listCol.add("ВесДБ");
        listCol.add("ВесНашли");
        listCol.add("Отклонение");
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
                return list.get(rowIndex).getRevizia();
            case 1: 
                return list.get(rowIndex).getStatus();    
            case 2: 
                return list.get(rowIndex).getNomer();
            case 3: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());                        
            case 4: 
                return list.get(rowIndex).getSvesdb().setScale(2, RoundingMode.HALF_UP);
            case 5: 
                return list.get(rowIndex).getSves().setScale(2, RoundingMode.HALF_UP);
            case 6: 
                return list.get(rowIndex).getSves().subtract(list.get(rowIndex).getSvesdb()).setScale(2, RoundingMode.HALF_UP);    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        list = IORevizia.getListRevizia(d1, d2);
        fireTableDataChanged();
    }
    
}
