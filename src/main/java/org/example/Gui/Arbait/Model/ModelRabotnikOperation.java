/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.LRabotnikOperation;
import org.example.util.HelpClass;
import org.example.util.IORabotnikOperation;

/**
 *
 * @author ivan
 */
public class ModelRabotnikOperation extends AbstractTableModel{
    //List<RabotnikOperation> list = new ArrayList<>();
    List<LRabotnikOperation> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelRabotnikOperation() {
        listCol.add("№");        
        listCol.add("Ст");        
        listCol.add("Дата");
        listCol.add("Сотрудник");
        listCol.add("Артикул");
        listCol.add("Маршрут");  
        listCol.add("Операция");
        listCol.add("Цена");  
        listCol.add("Кол-во");  
        listCol.add("Время");
        listCol.add("Сумма");
        listCol.add("Цех");
        listCol.add("#");
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
                return list.get(rowIndex).getStatus();    
            case 2: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());    
            case 3: 
                return list.get(rowIndex).getRabotnik();    
            case 4: 
                return list.get(rowIndex).getArticle();
            case 5: 
                return list.get(rowIndex).getNomer();
            case 6: 
                return list.get(rowIndex).getOperations();        
            case 7: 
                return 0;
            case 8: 
                return list.get(rowIndex).getQty();
            case 9: 
                return 0;
            case 10: 
                return list.get(rowIndex).getSumma().setScale(2, RoundingMode.HALF_EVEN);                
            case 11: 
                return list.get(rowIndex).getChexname();
            case 12: 
                return list.get(rowIndex).getChex();    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        list = IORabotnikOperation.getLRabotnikOperation1(d1, d2);
        fireTableDataChanged();
    }
    

    
}
