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
import org.example.logic.TipModel;
import org.example.util.IOTipModel;

/**
 *
 * @author ivan
 */
public class ModelTipModel extends AbstractTableModel
{
    List<TipModel> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelTipModel() {
        listCol.add("№");
        listCol.add("Название");        
        listCol.add("Стоимость"); 
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
                return list.get(rowIndex).getTipmodel();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getKoef().setScale(2, RoundingMode.HALF_UP);    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOTipModel.getListTipModel(-1);
        fireTableDataChanged();
    }
}
