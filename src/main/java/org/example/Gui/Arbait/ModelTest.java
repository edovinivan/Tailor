/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.LModel1;
import org.example.util.HelpClass;
import org.example.util.IOModel;

/**
 *
 * @author ivan
 */
public class ModelTest  extends AbstractTableModel{
    List<LModel1> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelTest() {
        for(int i=0;i<40;i++)
            listCol.add("№"+i); 
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
        return list.get(rowIndex).getArticle();
        /*switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getModel();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return rowIndex+1;    
            case 3: 
                return list.get(rowIndex).getArticle();
            case 4: 
                return list.get(rowIndex).getName();
            case 5: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 6: 
                return list.get(rowIndex).getTipmodel();        
            case 7: 
                return list.get(rowIndex).getCoucom();
            case 8: 
                return list.get(rowIndex).getChex();    
        }
        return null;*/
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(boolean all)
    {
        list = IOModel.getListLModel1(all);
        fireTableDataChanged();
    }
    
    
    public void addcol()
    {
        listCol.add("Add1");
        listCol.add("Add2");
        fireTableDataChanged();
        fireTableStructureChanged();
    }
   
    
    
    
}
