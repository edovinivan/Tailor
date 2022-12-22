/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.ZadachaKomplektovkaPretenziaRazmer;
import org.example.util.HelpClass;
import org.example.util.IOZadachaKomplektovkaPretenzia;

/**
 *
 * @author ivan
 */
public class ModelPretenzia  extends AbstractTableModel{
    List<ZadachaKomplektovkaPretenziaRazmer> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    boolean edit_3_4 = false;
    boolean edit_5 = false;
    
    public ModelPretenzia() {
        listCol.add("#");          //0
        listCol.add("Размер");     //1   
        listCol.add("Кол-во");     //2   
        listCol.add("Брак");     //3   
        listCol.add("Вопрос");     //4
        listCol.add("Ответ");      //5        
    }   

        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }
    
    public void setEditRom3_4(boolean fl)
    {
        edit_3_4 = fl;
    }
    
    public void setEditRom5(boolean fl)
    {
        edit_5 = fl;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 3)
            return edit_3_4;
        if(columnIndex == 4)
            return edit_3_4;
        if(columnIndex == 5)
            return edit_5;
        return false;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getZkpretenziarazmer();
            case 1: 
                return list.get(rowIndex).getZkrazmer().getRazmeri().getName();
            case 2: 
                return list.get(rowIndex).getZkrazmer().getQty();
            case 3: 
                return list.get(rowIndex).getQty();    
            case 4: 
                return list.get(rowIndex).getVopros();
            case 5: 
                return list.get(rowIndex).getOtvet();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int zkp)
    {
        list = IOZadachaKomplektovkaPretenzia.getListZKPretenziaRazmer(zkp);
        fireTableDataChanged();
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // колво
        if(columnIndex==3)
        {
            list.get(rowIndex).setQty(HelpClass.GetIntIzText(String.valueOf(aValue)));
            IOZadachaKomplektovkaPretenzia.setZadachaKomplektovkaPretenziaRazmer(list.get(rowIndex));
        }
        if(columnIndex==4)
        {
            list.get(rowIndex).setVopros(String.valueOf(aValue));
            IOZadachaKomplektovkaPretenzia.setZadachaKomplektovkaPretenziaRazmer(list.get(rowIndex));
        }
        if(columnIndex==5)
        {
            list.get(rowIndex).setOtvet(String.valueOf(aValue));
            IOZadachaKomplektovkaPretenzia.setZadachaKomplektovkaPretenziaRazmer(list.get(rowIndex));
        }        
    }
    
    
    
}
