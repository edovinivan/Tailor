/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ZadachaNastilDop;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 */
public class ModelZadachaNastilDop   extends AbstractTableModel{
    List<ZadachaNastilDop> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    boolean edit = true;

    int shag;
    
    public ModelZadachaNastilDop(int shag1) {
        listCol.add("#");
        listCol.add("Размер");        
        listCol.add("Длина(мм)");  
        listCol.add("Кол-во слоев");  
        listCol.add("Изделий");  
        listCol.add("Д.Арт");  
        shag = shag1;
    }   

    public void setEditStop()
    {
        edit = false;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(edit)
        {
            // формируем настил
            if(shag == 1)
            {
                if(columnIndex == 2)
                    return true;
                if(columnIndex == 4)
                    return true;                
                return columnIndex == 5;
            }
            if(shag == 2)
                return columnIndex == 3;
            if(shag == 3)
                return columnIndex > 1;
        }
        return false;
    }    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        int k;
        try
        {
            k = Integer.parseInt((String)aValue);
        }catch(NumberFormatException e)
        { k = 0;}

        //Длина
        if(columnIndex==2)        
            list.get(rowIndex).setLight(k);            
        if(columnIndex==3)        
            list.get(rowIndex).setQty(k);
        if(columnIndex==4)        
            list.get(rowIndex).setKolsloi(k);
        if(columnIndex==5)        
            list.get(rowIndex).setKolsloidop(k);        
        
        IOZadachaNastil.setZBD(list.get(rowIndex).getZadachanastildop(), list.get(rowIndex).getLight(), list.get(rowIndex).getQty(), list.get(rowIndex).getKolsloi(), list.get(rowIndex).getKolsloidop());
        
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
                return list.get(rowIndex).getZadachanastildop();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getLight();
            case 3: 
                return list.get(rowIndex).getQty();
            case 4: 
                return list.get(rowIndex).getKolsloi();    
            case 5: 
                return list.get(rowIndex).getKolsloidop();        
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int zn)
    {
        list = IOZadachaNastil.getListNastilDopForNastil(zn);
        fireTableDataChanged();
    }
    
    
    
    
    
}
