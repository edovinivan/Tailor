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
import org.example.logic.GetHistoryFurnitura;
import org.example.util.IODocumentF;

/**
 *
 * @author ivan
 */
public class ModelHistoryFurnitura  extends AbstractTableModel{
    List<GetHistoryFurnitura> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int product = 0;
    
    public int getProd()
    {
        return product;
    }
    
    public ModelHistoryFurnitura() {
        listCol.add("ID");
        listCol.add("ID1");
        listCol.add("GID");
        listCol.add("Фурнитура");        
        listCol.add("Цвет");        
        listCol.add("Кол-во");        
        listCol.add("Цена");        
        listCol.add("Дата");        
        listCol.add("Агент");        
        listCol.add("Операция");                
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
                return list.get(rowIndex).getId1();
            case 2: 
                return list.get(rowIndex).getGid();
            case 3: 
                return list.get(rowIndex).getName();
            case 4: 
                return list.get(rowIndex).getColor();
            case 5: 
                return list.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_UP);
            case 6: 
                return list.get(rowIndex).getPrice().setScale(2, RoundingMode.HALF_UP);
            case 7: 
                return list.get(rowIndex).getDates();
            case 8: 
                return list.get(rowIndex).getAgent();
            case 9: 
                return list.get(rowIndex).getOperations();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int prod, int sp)
    {
        list = IODocumentF.getGetHistoryFurnitura(prod, sp);
        if(!list.isEmpty())
            product = list.get(0).getProduct();
        fireTableDataChanged();
    }
    
}
