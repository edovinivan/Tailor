/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ZadachaDopScladProduct;
import org.example.util.IOZadachaDopSP;

/**
 *
 * @author ivan
 */
public class ModelZadachaDopSP  extends AbstractTableModel{
    List<ZadachaDopScladProduct> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelZadachaDopSP() {
        listCol.add("№");
        listCol.add("Паспорт");  
        listCol.add("Материал");  
        listCol.add("Цвет");  
        listCol.add("Ширина");  
        listCol.add("Вес");                  
        listCol.add("Длина"); 
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
                return list.get(rowIndex).getZadachadopscladproduct();
            case 1: 
                return list.get(rowIndex).getScladproduct().getPasport();
            case 2: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();
            case 3: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 4: 
                return list.get(rowIndex).getScladproduct().getWidth().setScale(2, RoundingMode.HALF_UP);
            case 5: 
                return list.get(rowIndex).getScladproduct().getVes().setScale(2, RoundingMode.HALF_UP);
            case 6: 
                return list.get(rowIndex).getScladproduct().getLight().setScale(2, RoundingMode.HALF_UP);
            case 7: 
                return list.get(rowIndex).getScladproduct().getScladproduct();            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int s)
    {
        list = IOZadachaDopSP.getListZadachaDopScladProduct(s);
        fireTableDataChanged();
    }
    
}
