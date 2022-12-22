/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PModelPlanHaupt;
import org.example.util.plan.IOPModelPlanHaupt;

/**
 *
 * @author ivan
 */
public class ModelModelPlanHaupt extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<PModelPlanHaupt> list = new ArrayList<>();    

    public ModelModelPlanHaupt() {        
        listCol.add("#");              //0         
        listCol.add("АнализС");          //1
        listCol.add("АнализПо");          //2
        listCol.add("Артикул");        //3
        listCol.add("Закупки");          //4
        listCol.add("Производство");          //5
        listCol.add("ПродажиС");          //6
        listCol.add("ПродажиПо");          //7
        
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
                return list.get(rowIndex).getPmodelplanhaupt();
            case 1: 
                return list.get(rowIndex).getDates1();
            case 2: 
                return list.get(rowIndex).getDates2();
            case 3: 
                return list.get(rowIndex).getModel().getArticle();
            case 4: 
                return list.get(rowIndex).getDates3();    
            case 5: 
                return list.get(rowIndex).getDates4();
            case 6: 
                return list.get(rowIndex).getDates5();
            case 7: 
                return list.get(rowIndex).getDates6();
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return listCol.get(column);
    }
    
    
    public void setData(Date d1, Date d2)
    { 
        list = IOPModelPlanHaupt.getListPModelPlanHaupt(d1, d2);
        fireTableDataChanged();
    }
    
    
    
}
