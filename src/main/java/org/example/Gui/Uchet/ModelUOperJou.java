/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Uchet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Uchet.UOperDoc;
import org.example.logic.Uchet.UOperJou;
import org.example.util.HelpClass;
import org.example.util.IOOperator;
import org.example.util.Uchet.IOUOperDoc;

/**
 *
 * @author ivan
 */
public class ModelUOperJou  extends AbstractTableModel{
    List<UOperJou> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelUOperJou() {
        listCol.add("№");
        listCol.add("Начало");        
        listCol.add("Окончание");        
        listCol.add("Дата создания");                
        listCol.add("Комментарий");                        
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
                return list.get(rowIndex).getUoperjou();
            case 1: 
                return HelpClass.getPrintDate3(list.get(rowIndex).getBdates());
            case 2: 
                return HelpClass.getPrintDate3(list.get(rowIndex).getEdates());
            case 3: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 4:     
                return list.get(rowIndex).getComment();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int ud)
    {
        
        list = IOUOperDoc.getListUOperJou(ud);
        fireTableDataChanged();
    }
    
}
