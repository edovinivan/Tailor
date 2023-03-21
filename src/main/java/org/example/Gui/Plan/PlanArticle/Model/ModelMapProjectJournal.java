/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import org.example.util.plannew.IOMapProjectJournal;

/**
 *
 * @author ivan
 */
public class ModelMapProjectJournal extends AbstractTableModel{
    public ModelMapProjectJournal() {
        colName.add("ID");
        colName.add("СТ");
        colName.add("Артикул");
        colName.add("Цвет");
        colName.add("Размер");
        colName.add("Кол-во");
        colName.add("Расчет");
        colName.add("Продаж");
        colName.add("Остаток");
        colName.add("В работе");        
        colName.add("Дата");        
    }

    List<MapJournal> listData = new ArrayList<>();
    List<String> colName = new ArrayList<>();
    
    private final IOMapProjectJournal iOMapProjectJournal = new IOMapProjectJournal();
    
    private boolean edit = true;
    
    
    public List<MapJournal> getListMapJournal(){
        return listData;
    }
    
    public void setEdit(boolean edit){
        this.edit = edit;
    }
    
    @Override
    public int getRowCount() {
        return listData.size();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {        
        if(columnIndex == 1) return true;
        return edit?columnIndex == 5:false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 1)
            return Boolean.class;
        if(columnIndex >= 5 && columnIndex <= 9 )
            return Integer.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex == 1){
            listData.get(rowIndex).setStatus(listData.get(rowIndex).getStatus()>0?0:1);
            fireTableDataChanged();
            return;
        }            
            
        if(columnIndex == 5){
            int qt;
            try {
                qt = (int)aValue;
                listData.get(rowIndex).setQty(qt);
                iOMapProjectJournal.updateQtyForMapProjectJournal(listData.get(rowIndex).getId() ,qt);
                fireTableDataChanged();
            } catch(NumberFormatException e){
                
            }            
        }
    }   
    
    

    @Override
    public int getColumnCount() {
        return colName.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return listData.get(rowIndex).getId();
            case 1: 
                return listData.get(rowIndex).getStatus()>0;    
            case 2:                     
                return listData.get(rowIndex).getArticle();
            case 3: 
                return listData.get(rowIndex).getColor();
            case 4: 
                return listData.get(rowIndex).getRazmer();    
            case 5: 
                return listData.get(rowIndex).getQty();
            case 6:
                return listData.get(rowIndex).getQtyCalculating();
            case 7:
                return listData.get(rowIndex).getSale();     
            case 8:
                return listData.get(rowIndex).getBalance();
            case 9:
                return listData.get(rowIndex).getInwork();
            case 10:
                return listData.get(rowIndex).getDate();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colName.get(column);
    }

    /**
     * Получить данные
     * @param mpp - номер плана
     * @param grouptArticle - получить группированные по артикулам или нет
     * @param grouptColor
     * 
     */
    public void setData(int mpp, boolean grouptArticle, boolean grouptColor) {
        IOMapProjectJournal iOMapProject = new IOMapProjectJournal();
        if (grouptColor) { // группировка по цветам            
           listData = iOMapProject.getListLMapProjectJournalGrouptColor(mpp)
                        .stream()
                        .map((t) -> {
                            return new MapJournal(t.getId(), 0, t.getArticle(), t.getColor(), t.getQty(), t.getDates(), "", t.getSale(), t.getBalance(), t.getInwork(), t.getSalemoney());
                        })
                        //.sorted()
                        .collect(Collectors.toList());
        } else {
            if (grouptArticle) { // группировка по артикулам
                listData = iOMapProject.getListLMapProjectJournalGroupt(mpp)
                        .stream()
                        .map((t) -> {
                            return new MapJournal(t.getId(), 0, t.getArticle(), "", t.getQty(), t.getDates(), "", t.getSale(), t.getBalance(), t.getInwork(), t.getSalemoney());
                        })
                        //.sorted()
                        .collect(Collectors.toList());
            } else {
                listData = iOMapProject.getListLMapProjectJournal(mpp)
                        .stream()
                        .map((t) -> {
                            return new MapJournal(t.getId(), t.getStatus(), t.getArticle(), t.getColor(), t.getQty(), t.getDates(), t.getRazmeriname(), t.getSale(), t.getBalance(), t.getInwork(), t.getSalemoney());
                        })
                        //.sorted()
                        .collect(Collectors.toList());
            }

        }
        
        fireTableDataChanged();
    }
    
    
    /**
     * Сортировать данные по ABC
     */
    public void sortABC(){
        listData.sort((o1, o2) -> {
            return o2.getSalemoney()  - o1.getSalemoney();
        });                
        fireTableDataChanged();
    }
    
     /**
     * Сортировать данные по артикулу
     */
    public void sortArticle(){
        Collections.sort(listData);                
        fireTableDataChanged();
    }
    
    
    /**
     * Добавить в работе
     * @param ls
     */
    public void addInWork(Map<String, Integer> ls){
        listData.stream()                
                .forEach(t->{
                    if(ls.containsKey(t.getArticle() + "-" +t.getColor() + "-" + t.getRazmer())){
                        t.setInwork(ls.get(t.getArticle() + "-" +t.getColor() + "-" + t.getRazmer()));
                    }
                });
        fireTableDataChanged();        
    }
}
