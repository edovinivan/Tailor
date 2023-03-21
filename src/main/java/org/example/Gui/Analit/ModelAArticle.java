/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.analit.aArticle;
import org.example.util.analit.IOAHelp;

/**
 *
 * @author ivan
 */
public class ModelAArticle   extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<aArticle> list = new ArrayList<>();
    

    public ModelAArticle() {
        listCol.add("ID");        
        listCol.add("Артикул1С");  
        listCol.add("Название!С");  
        listCol.add("АртикулТ");       
        listCol.add("НазваниеТ");       
        listCol.add("IDT");       
        listCol.add("Ст");       
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
                return list.get(rowIndex).getA_article();
            case 1: 
                return list.get(rowIndex).getArticle();
            case 2: 
                return list.get(rowIndex).getName();    
            case 3: 
                if(list.get(rowIndex).getModel().getModel()==0)
                    return "";
                return list.get(rowIndex).getModel().getArticle();            
            case 4: 
                if(list.get(rowIndex).getModel().getModel()==0)
                    return "";
                return list.get(rowIndex).getModel().getName();                
            case 5: 
                return list.get(rowIndex).getModel().getModel();                
            case 6: 
                return list.get(rowIndex).getModel().getStatus();                    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData()
    {
        list = IOAHelp.getListArticle();
        fireTableDataChanged();
    }   
}
