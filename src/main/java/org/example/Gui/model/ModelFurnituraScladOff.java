/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.FurnituraOffAll;
import org.example.logic.FurnituraScladOff;
import org.example.util.IODocumentF;
import org.example.util.IOFurnituraScladOff;

/**
 *
 * @author ivan
 */
public class ModelFurnituraScladOff   extends AbstractTableModel{
    List<FurnituraScladOff> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelFurnituraScladOff() {
        listCol.add("#");        
        listCol.add("Фурнитура");        
        listCol.add("Цвет");        
        listCol.add("Кол-во");        
        listCol.add("Дата");        
        listCol.add("Пояснение");        
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
                return list.get(rowIndex).getFurniturascladoff();
            case 1: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();
            case 2: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 3: 
                return list.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_UP);
            case 4: 
                return list.get(rowIndex).getDates();
            case 5: 
                return list.get(rowIndex).getTexts();    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        list = IOFurnituraScladOff.getListFurnituraScladOff(d1, d2);
        fireTableDataChanged();
    }
    
}
