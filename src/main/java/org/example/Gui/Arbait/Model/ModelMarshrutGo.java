/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.RabotnikGruppa;
import org.example.logic.ZadachaKomplektovka;
import org.example.util.HelpClass;
import org.example.util.IOZadachaKomplektovka;

/**
 *
 * @author ivan
 */
public class ModelMarshrutGo  extends AbstractTableModel{
    List<ZadachaKomplektovka> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelMarshrutGo() {
        listCol.add("#");          //0
        listCol.add("&&");         //1   
        listCol.add("Номер");      //2
        listCol.add("Дата");       //3
        listCol.add("Швейный цех");//4          
        listCol.add("Кол-во");     //5              
        listCol.add("Артикул");    //6      
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
                return list.get(rowIndex).getZadachakomplektovka();
            case 1: 
                return list.get(rowIndex).getStatus()==10;
            case 2: 
                return list.get(rowIndex).getNomer();
            case 3: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 4: 
                return list.get(rowIndex).getChek().getName();
            case 5: 
                return list.get(rowIndex).getCounts();                        
            case 6:
                return list.get(rowIndex).getZadacha().getModel().getArticle();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==1)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if((Boolean)aValue)
            list.get(rowIndex).setStatus(10);
        else
            list.get(rowIndex).setStatus(0);
        //super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }    
    

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setDataForGo()
    {
        list = IOZadachaKomplektovka.getAllMarshrutForGo();
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==1;
    }
    
    public int getCountSelectRow()
    {
        for(ZadachaKomplektovka z: list)
            if(z.getStatus()==10)
                return 1;
        return 0;
    }
    
    
    public void marshrutGo(int c, Date dS, Date dr)
    {
        for(ZadachaKomplektovka z: list)
        {
            if(z.getStatus()==10)
            {
                z.setStatus(3);
                z.setDatasend(dS);
                z.setDataend(dr);
                z.setChek(new RabotnikGruppa(c));
                IOZadachaKomplektovka.setZadachaKomplektovka(z);
            }
        }
        setDataForGo();
    }
}
