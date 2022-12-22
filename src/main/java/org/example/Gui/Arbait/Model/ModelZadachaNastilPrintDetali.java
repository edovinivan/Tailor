/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ZadachaNastilPrintDetali;
import org.example.util.HelpClass;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 */
public class ModelZadachaNastilPrintDetali  extends AbstractTableModel{
    List<ZadachaNastilPrintDetali> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelZadachaNastilPrintDetali() {
        listCol.add("#");         //0
        listCol.add("Тип");       //1   
        listCol.add("Деталь");    //2
        listCol.add("Кол-во");    //3        
    }   

        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    long d;
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getZadachanastilprintdetali();
            case 1: 
                return list.get(rowIndex).getModelprintdetali().getVid()==1?"П":(list.get(rowIndex).getModelprintdetali().getVid()==2?"В":"ТП");
            case 2: 
                return list.get(rowIndex).getModelprintdetali().getPrintdetali().getName();
            case 3: 
                return list.get(rowIndex).getQty();            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int zn, boolean flag)
    {
        list = IOZadachaNastil.getListZadachaNastilPrintDetaliForZN(zn, flag);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int r = HelpClass.GetIntIzText((String) aValue);
        IOZadachaNastil.updateQtyForPrintDetaliNadachaNastil(list.get(rowIndex).getZadachanastilprintdetali(), r);
        list.get(rowIndex).setQty(r);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==3;
    }
    
    
    
}
