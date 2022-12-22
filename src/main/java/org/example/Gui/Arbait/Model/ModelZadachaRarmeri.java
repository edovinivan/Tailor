/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ZadachaRazmeri;
import org.example.util.IOZadacha;

/**
 *
 * @author ivan
 */
public class ModelZadachaRarmeri   extends AbstractTableModel{
    List<ZadachaRazmeri> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    boolean flag_edit_stop = false;
    int hQty = 0;
    
    public void setEditStop()
    {
        flag_edit_stop = true;
    }
    
    public ModelZadachaRarmeri() {
        listCol.add("№");
        listCol.add("Размер");  
        listCol.add("Кол-во");  
    }   

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(flag_edit_stop)  return false;
        return columnIndex == 2;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int l = 0;
        try
        {
            l = Integer.parseInt(String.valueOf(aValue));
        }
        catch(NumberFormatException e) {}
        list.get(rowIndex).setQty(l);
        IOZadacha.setQtyForZR(list.get(rowIndex).getZadacharazmeri(), l);
        IOZadacha.executeProductForZadacha(list.get(rowIndex).getZadacha().getZadacha());
        sethQty();
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
                return list.get(rowIndex).getZadacharazmeri();
            case 1: 
                return list.get(rowIndex).getRazmeri().getName();
            case 2: 
                return list.get(rowIndex).getQty();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int z)
    {
        list = IOZadacha.getListZadachaRazmeri(z, 0);
        sethQty();
        fireTableDataChanged();
    }
    
    private void sethQty()
    {
        hQty = 0;
        for(ZadachaRazmeri z: list)
            hQty = hQty + z.getQty();
    }
    
    public int getHQty()
    {
        return hQty;
    }
    
    
}
