/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.util.IORabotnikOperation;

/**
 *
 * @author ivan
 */
public class ModelGrossMarshRabOperat extends AbstractTableModel{
    //List<RabotnikOperation> list = new ArrayList<>();
    List<String> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelGrossMarshRabOperat() {
        listCol.add("ID");        
        listCol.add("№");        
        listCol.add("Операция");
        listCol.add("Кол-во");
        listCol.add("Выполнено");
        listCol.add("Артикул");  
        listCol.add("Маршрут");
        listCol.add("Задача");  
        listCol.add("Цех");          
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
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        //System.out.println(rowIndex + "  -  " + columnIndex);
        if(columnIndex==0)
            return rowIndex + 1;
        return list.get(rowIndex).split("<!>")[columnIndex-1];
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(Date d1, Date d2)
    {
        list = IORabotnikOperation.getLGrossRabotnikOperation(d1, d2);
        //System.out.println(list.size());
        //for(String s: list)
        //    System.out.println(s);
        fireTableDataChanged();
    }
    
    
}
