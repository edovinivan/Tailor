/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.FurnituraScladAll;
import org.example.util.IODocument;

/**
 *
 * @author ivan
 */
public class ModelFurnituraScladAll  extends AbstractTableModel{
    List<FurnituraScladAll> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelFurnituraScladAll() {
        listCol.add("#");
        listCol.add("Паспорт");        
        listCol.add("Название");        
        listCol.add("Цвет");        
        listCol.add("Кол-во");        
        listCol.add("Цена");        
        listCol.add("Сумма");        
        listCol.add("МестоХ");        
        listCol.add("Дата");        
        listCol.add("Поставщик");                
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
                return list.get(rowIndex).getPassport();    
            case 2: 
                return list.get(rowIndex).getProduct();
            case 3: 
                return list.get(rowIndex).getColor();
            case 4: 
                return list.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_UP);
            case 5: 
                return list.get(rowIndex).getPrice().setScale(2, RoundingMode.HALF_UP);
            case 6: 
                return list.get(rowIndex).getSumma().setScale(2, RoundingMode.HALF_UP);
            case 7: 
                return list.get(rowIndex).getSclad();    
            case 8: 
                return list.get(rowIndex).getDates();
            case 9: 
                return list.get(rowIndex).getAgent();
            
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IODocument.getListFurnituraScladAll();
        fireTableDataChanged();
    }
    
}
