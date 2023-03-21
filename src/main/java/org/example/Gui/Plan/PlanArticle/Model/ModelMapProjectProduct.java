/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle.Model;

import org.example.Gui.Plan.PlanArticle.MapProjectProduct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.util.plannew.IOMapPlanProduct;

/**
 *
 * @author ivan
 */
public class ModelMapProjectProduct extends AbstractTableModel{
    
    List<MapProjectProduct> lsData = new ArrayList<>();
    List<String> cols = new ArrayList<>();

    public ModelMapProjectProduct() {
        cols = Arrays.asList("ID", "IO" ,"Полотно", "Цвет", "Кол-во");
    }
    
    

    @Override
    public int getRowCount() {
        return lsData.size();
    }

    @Override
    public int getColumnCount() {
        return cols.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 1)
            return Boolean.class;
        if(columnIndex == 4)
            return BigDecimal.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        lsData.get(rowIndex).setCheck((boolean)aValue);        
    }  

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return lsData.get(rowIndex).getId();
            case 1:
                return lsData.get(rowIndex).isCheck();
            case 2:
                return lsData.get(rowIndex).getProduct();
            case 3:
                return lsData.get(rowIndex).getColor();
            case 4:
                return lsData.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_UP);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return cols.get(column);
    }
    
    
    public void loadData(int plan){
        IOMapPlanProduct iOMapPlanProduct = new IOMapPlanProduct();
        lsData = iOMapPlanProduct.getListMapProjectProductForPlan(plan);
        fireTableDataChanged();        
    }
    
    public List<MapProjectProduct> getListMapPP(){
        return lsData;
    }
    
    public void addDeselect(){
        lsData.forEach(t->{t.setCheck(false);});
        fireTableDataChanged();
    }
    
    public void addSelect(){
        lsData.forEach(t->{t.setCheck(true);});
        fireTableDataChanged();
    }
    
}
