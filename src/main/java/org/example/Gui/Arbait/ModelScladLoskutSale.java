/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ScladLoskutSale;
import org.example.util.HelpClass;
import org.example.util.IOScladLoskut;

/**
 *
 * @author ivan
 */
public class ModelScladLoskutSale  extends AbstractTableModel{
    List<ScladLoskutSale> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    
    public ModelScladLoskutSale() {
        listCol.add("#");           //0
        listCol.add("Дата");        //2   
        listCol.add("Кол-во");      //5   
        listCol.add("Тип полотна"); //3              
        listCol.add("Настил"); //4              
        listCol.add("Причина");   //5    
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
                return list.get(rowIndex).getScladloskutsale();                        
            case 1: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 2: 
                return list.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_UP);                    
            case 3: 
                return list.get(rowIndex).getScladloskut().getProduct().getName();    
            case 4: 
                return list.get(rowIndex).getScladloskut().getZadachanastil().getNomer();
            case 5: 
                return list.get(rowIndex).getScladloskutsaleop().getName();    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        list = IOScladLoskut.getListScladLoskutSale(d1, d2);
        fireTableDataChanged();
        
    }
    
}
