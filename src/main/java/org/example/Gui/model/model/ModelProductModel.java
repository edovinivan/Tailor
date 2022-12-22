/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model.model;


import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ModelProduct;
import org.example.util.IOModel;

/**
 *
 * @author ivan
 */
public class ModelProductModel    extends AbstractTableModel{
    List<ModelProduct> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    public ModelProductModel(int v) {
        listCol.add("№");
        listCol.add("Тип");
        listCol.add("Материал");        
        listCol.add("Цвет");       
        listCol.add("Цвет.ниток");        
        listCol.add("Кол-во");        
        listCol.add("Вес");
        vid = v;
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
                return list.get(rowIndex).getModelproduct();
            case 1: 
                return list.get(rowIndex).getTipproduct().getName();
            case 2: 
                return list.get(rowIndex).getProduct().getName();
            case 3: 
                return list.get(rowIndex).getColor().getName();
            case 4: 
                return list.get(rowIndex).getNitkicolor().getName();
            case 5: 
                return list.get(rowIndex).getQty().setScale(1, RoundingMode.HALF_UP);   
            case 6: 
                return list.get(rowIndex).getQty_start().setScale(3, RoundingMode.HALF_UP); 
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int mod)
    {
        list = IOModel.getListModelProduct(mod, -1, vid);
        fireTableDataChanged();
    }
    
}
