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
import org.example.logic.plan.PModelPlan;
import org.example.util.plan.IOModelPlan;

/**
 *
 * @author ivan
 */
public class ModelModelPlan extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<PModelPlan> list = new ArrayList<>();
    

    public ModelModelPlan() {        
        listCol.add("#");              //0 
        listCol.add("№");             //1 
        listCol.add("СТ");             //2 
        listCol.add("ДатаР");          //3
        listCol.add("ДатаЗ");          //4
        listCol.add("ДатаФ");          //5
        listCol.add("Артикул");        //6
        listCol.add("Цвет");           //7
        listCol.add("Размеров");       //8
        listCol.add("Кол-во");         //9
        listCol.add("Цех");            //10         
        listCol.add("Арт");            //11         
        listCol.add("Арт#");           //12         
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
                return list.get(rowIndex).getPmodelplan();
            case 1: 
                return rowIndex + 1;
            case 2: 
                return list.get(rowIndex).getStatus();
            case 3: 
                return list.get(rowIndex).getDates();
            case 4: 
                return list.get(rowIndex).getDates1();    
            case 5: 
                return list.get(rowIndex).getDates2();
            case 6: 
                return list.get(rowIndex).getModel().getArticle();
            case 7: 
                return list.get(rowIndex).getColor().getName();
            case 8: 
                return list.get(rowIndex).getCounts();
            case 9: 
                return list.get(rowIndex).getSumqty();
            case 10: 
                return list.get(rowIndex).getChex().getName();            
            case 11: 
                return list.get(rowIndex).getModel().getStatus();
            case 12: 
                return list.get(rowIndex).getModel().getModel();    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        return listCol.get(column);
    }
    
    
    public void setData(Date d1, Date d2)
    { 
        list = IOModelPlan.getListPModelPlan(d1, d2);
        fireTableDataChanged();
    }
    
    public void setDataModel(int mod, Date d1, Date d2)
    { 
        list = IOModelPlan.getListPModelForModel(mod, d1, d2);
        fireTableDataChanged();
    }
    
    /**
     * Получить нераспределенные задачи за периуд
     * @param d1
     * @param d2 
     */
    public void setDataForNoChex(Date d1, Date d2)
    { 
        list = IOModelPlan.getListPModelPlanForNoChex(d1, d2);
        fireTableDataChanged();
    }
    
    
}
