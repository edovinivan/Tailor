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
import org.example.util.HelpClass;
import org.example.util.IOOperator;
import org.example.util.Uchet.IOUOperDoc;

/**
 *
 * @author ivan
 */
public class ModelUOperDoc  extends AbstractTableModel{
    List<UOperDoc> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelUOperDoc() {
        listCol.add("№");
        listCol.add("Ст");        
        listCol.add("Операция");        
        listCol.add("Дата создания");                
        listCol.add("Время выполнения");                
        listCol.add("Оператор");                
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
                return list.get(rowIndex).getUoperdoc();
            case 2: 
                return list.get(rowIndex).getName();
            case 1: 
                return list.get(rowIndex).getStatus();    
            case 3: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 4:     
                return (list.get(rowIndex).getMinutest()/60)+":"+(list.get(rowIndex).getMinutest()%60);
            case 5:
                return list.get(rowIndex).getOperator().getName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        
        list = IOUOperDoc.getListUOperDoc(d1, d2, IOOperator.operator.getOperator()==1?0:IOOperator.operator.getOperator());                
        fireTableDataChanged();
    }
    
}
