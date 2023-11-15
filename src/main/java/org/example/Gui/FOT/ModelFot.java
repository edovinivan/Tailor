/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.FOT;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Zadacha;
import org.example.util.HelpClass;
import org.example.util.IOZadacha;

/**
 *
 * @author ivan
 */
public class ModelFot extends AbstractTableModel{
    List<Zadacha> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelFot() {
        listCol.add("№");        
        listCol.add("Статус");  
        listCol.add("Номер задачи");
        listCol.add("Артикул");  
        listCol.add("Дата");  
        listCol.add("Д.Старт");
        listCol.add("Д.Закрытия");
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
                return list.get(rowIndex).getZadacha();            
            case 1: 
                switch(list.get(rowIndex).getStatus())
                {
                    case 0:
                    case 1:
                        return "Создана";
                    case 2:                        
                    case 3:
                        return "В работе";
                    default:    
                        return "Закрыта";
                }                
            case 2: 
                return list.get(rowIndex).getNomer();        
            case 3: 
                return list.get(rowIndex).getModel().getArticle();
            case 4: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 5: 
                if(list.get(rowIndex).getStatus()>1)
                    return HelpClass.getPrintDate(list.get(rowIndex).getDatestart());
                else
                    return "";                    
            case 6: 
                if(list.get(rowIndex).getStatus()==10){                    
                    return HelpClass.getPrintDate(list.get(rowIndex).getDateend());
                }
                else
                    return "";                   
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOZadacha.getListZadacha(-1, 0);
        fireTableDataChanged();
    }
    
}
