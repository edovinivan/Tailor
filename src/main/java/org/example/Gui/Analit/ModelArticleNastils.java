/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ivan
 */
public class ModelArticleNastils extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<List<String>> list = new ArrayList<>();
    

    public ModelArticleNastils() {        
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
        if(!list.get(rowIndex).get(columnIndex).equals("0"))         
            return list.get(rowIndex).get(columnIndex);
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if(column>1)
            return "<html>" + listCol.get(column).split("<>")[0] + "<br>" + listCol.get(column).split("<>")[1] + "</html>";
        return listCol.get(column);
    }
    
    
    public void setData(List<String> ls)
    {
        list.clear();
        listCol.clear();
        String str[];
        int i=0;
        List<String> lk;
        for(String s:ls)
        {
            str = s.split("!");
            if(i==0)
            {
                listCol.addAll(Arrays.asList(str));                
            }
            else
            {
                lk = new ArrayList<>();
                lk.addAll(Arrays.asList(str));
                list.add(lk);
            }
            i++;
        }
        
        fireTableDataChanged();
    }
    
}
