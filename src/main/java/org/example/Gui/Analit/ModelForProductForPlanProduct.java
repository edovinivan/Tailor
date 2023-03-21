/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PModelPlanProduct;
import org.example.util.HelpClass;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class ModelForProductForPlanProduct extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<PModelPlanProduct> list = new ArrayList<>();
    

    public ModelForProductForPlanProduct() {
        listCol.add("ID");        
        listCol.add("ТипПолотнаКК");          
        listCol.add("ВидПолотнаКК");          
        listCol.add("ЦветКК");                
        listCol.add("ВидПолотна");          
        listCol.add("Цвет");        
        listCol.add("Нужно");        
        listCol.add("Заказать");        
    }   
    
    int qty = 0;
    
    public void setQty(int qt)
    {
        qty = qt;
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
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==7;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex == 7)
        {            
            IOModelPlan.setQtyForPModelPlanProduct(list.get(rowIndex).getPmodelplanproduct(), HelpClass.GetBigDecimalIzText((String) aValue));
            list.get(rowIndex).setQty(HelpClass.GetBigDecimalIzText((String) aValue));
            return;
        }
        super.setValueAt(aValue, rowIndex, columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
       

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getPmodelplanproduct();
            case 1: 
                return list.get(rowIndex).getModelproduct().getTipproduct().getName();            
            case 2: 
                return list.get(rowIndex).getModelproduct().getProduct().getName();
            case 3: 
                return list.get(rowIndex).getModelproduct().getColor().getName();    
            case 4:    
                return list.get(rowIndex).getProduct().getName();
            case 5:    
                return list.get(rowIndex).getColor().getName();    
            case 6: 
                return list.get(rowIndex).getModelproduct().getQty_start().multiply(new BigDecimal(qty)).setScale(3);
            case 7: 
                return list.get(rowIndex).getQty().setScale(3);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData(int g)
    {
        list = IOModelPlan.getListPModelPlanProduct(g);
        fireTableDataChanged();
    }
    
}
