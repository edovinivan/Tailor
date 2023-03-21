/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ZadachaKomplektovka;
import org.example.util.HelpClass;
import org.example.util.IOZadachaKomplektovka;

/**
 *
 * @author ivan
 */
public class ModelArticleInArbait  extends AbstractTableModel{
    List<ZadachaKomplektovka> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    
    public ModelArticleInArbait() {
        listCol.add("#");
        listCol.add("Статус");
        listCol.add("Дата");
        listCol.add("Номер");
        listCol.add("Цех");        
        listCol.add("Цвет");        
        listCol.add("Кол-во");        
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
                return list.get(rowIndex).getZadachakomplektovka();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 3: 
                return list.get(rowIndex).getNomer();
            case 4: 
                return list.get(rowIndex).getChek().getName();
            case 5: 
                return list.get(rowIndex).getColor().getName();
            case 6: 
                return list.get(rowIndex).getStr_cou();
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int art)
    {
        list = IOZadachaKomplektovka.getAllMarshrutForArticle1(art);
        fireTableDataChanged();
    }
    
}
