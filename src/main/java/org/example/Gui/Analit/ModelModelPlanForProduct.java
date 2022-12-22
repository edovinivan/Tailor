/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PModelPlanProduct;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class ModelModelPlanForProduct  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<PModelPlanProduct> list = new ArrayList<>();
    

    public ModelModelPlanForProduct() {
        listCol.add("ID");                        
        listCol.add("ModelPlan");                        
        listCol.add("ДатаР");          
        listCol.add("Артикул");
        listCol.add("ТипПолотна");                
        listCol.add("ВидПолотна");          
        listCol.add("Кол-во");          
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
                return list.get(rowIndex).getPmodelplanproduct();
            case 1: 
                return list.get(rowIndex).getPmodelplan().getPmodelplan();
            case 2: 
                return list.get(rowIndex).getPmodelplan().getDates();
            case 3: 
                return list.get(rowIndex).getPmodelplan().getModel().getArticle();
            case 4: 
                return list.get(rowIndex).getModelproduct().getTipproduct().getName();
            case 5: 
                return list.get(rowIndex).getProduct().getName();
            case 6: 
                return list.get(rowIndex).getQty().setScale(2);    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData(int zakupki, int product, int color)
    {
        list = IOModelPlan.getPModelPlanProductForZakupkiForColorAndProduct(zakupki, product, color);
        fireTableDataChanged();
    }
    
}
