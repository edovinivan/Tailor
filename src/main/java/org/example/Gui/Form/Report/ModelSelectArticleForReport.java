/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.Gui.Form.Report;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import org.example.logic.LModel1;
import org.example.util.HelpClass;
import org.example.util.IOModel;

/**
 *
 * @author edovin.ivan
 */
public class ModelSelectArticleForReport extends AbstractTableModel{
    List<LModel1> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelSelectArticleForReport() {
        listCol.add("ID");
        listCol.add("Выбрать");        
        listCol.add("Артикул");
        listCol.add("Название");       
        listCol.add("Дата");        
        listCol.add("Модель");                
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
                return list.get(rowIndex).getModel();
            case 1: 
                return list.get(rowIndex).getCoucom() == 1;
            case 2: 
                return list.get(rowIndex).getArticle();
            case 3: 
                return list.get(rowIndex).getName();
            case 4: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 5: 
                return list.get(rowIndex).getTipmodel();        
            
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {     
        list = IOModel.getListLModel1(false).stream()
                .filter(it-> {return it.getStatus()==2;})
                .peek(it->{ it.setCoucom(0); })
                .collect(Collectors.toList());
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 1)
            return Boolean.class;
        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==1;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex==1)
        {
            list.get(rowIndex).setCoucom((boolean)aValue?1:0);
        }
    }
    
    public List<String> getSelectArticle(){
        return list.stream()
                .filter(it->{ return it.getCoucom()==1;})
                .map(im->{return im.getArticle();})
                .collect(Collectors.toList());
    }
    
    public void setAllEnable(){
        for(LModel1 l: list){
            l.setCoucom(1);
        }
        fireTableDataChanged();
    }
    
    
    
}
