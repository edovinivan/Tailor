/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.FurnituraReturnSclad;
import org.example.util.IOFurnituraReturnSclad;

/**
 *
 * @author ivan
 */
public class ModelFurnituraReturnSclad extends AbstractTableModel{
    List<FurnituraReturnSclad> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelFurnituraReturnSclad() {
        listCol.add("#");
        listCol.add("СТ");
        listCol.add("Фурнитура");        
        listCol.add("Цвет");        
        listCol.add("Кол-во");        
        listCol.add("Дата");        
        listCol.add("Цех");        
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
                return list.get(rowIndex).getFurniturareturnsclad();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();
            case 3: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 4: 
                return list.get(rowIndex).getQty().setScale(2);
            case 5: 
                return list.get(rowIndex).getDates();    
            case 6: 
                return list.get(rowIndex).getChex().getName();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int c, Date d1, Date d2)
    {
        list = IOFurnituraReturnSclad.getListFurnituraReturnSclad(c, d1, d2);
        fireTableDataChanged();
    }
    
    
}
