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
import org.example.logic.ScladLoskut;
import org.example.util.HelpClass;
import org.example.util.IOScladLoskut;

/**
 *
 * @author ivan
 */
public class ModelSclasLoskut  extends AbstractTableModel{
    List<ScladLoskut> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    
    public ModelSclasLoskut() {
        listCol.add("#");          //0
        listCol.add("Ст");      //1        
        listCol.add("Дата");     //2   
        listCol.add("Тип полотна");     //3          
        
        listCol.add("Настил");     //5   
        listCol.add("Цвет");     //5   
        listCol.add("Пришло");     //4   
        listCol.add("Остаток");     //6
        
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
                
                return list.get(rowIndex).getScladloskut();                        
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 3: 
                return list.get(rowIndex).getProduct().getName();                
            case 4: 
                return list.get(rowIndex).getZadachanastil().getNomer();
            case 5:
                return list.get(rowIndex).getNamecolor();
            case 6: 
                return list.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_UP);    
            case 7: 
                return list.get(rowIndex).getOstatok().setScale(2, RoundingMode.HALF_UP);    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int tip, boolean view_all)
    {
        
        int n,m;
        n = 1;
        m = 2;
        if(tip==1)
        {
            n = 0;
            m = 0;
        }
        list = IOScladLoskut.getListScladLoskut(n, m, view_all);
        
        //for(ScladLoskut s: list)
        //    System.out.println(s.getNamecolor());
        
        fireTableDataChanged();
        
    }

    
}
