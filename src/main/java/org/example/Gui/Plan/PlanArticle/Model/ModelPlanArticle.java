/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PlanArticle;
import org.example.util.plan.IOPlanArticle;

/**
 *
 * @author ivan
 */
public class ModelPlanArticle extends AbstractTableModel{

    public ModelPlanArticle() {
        lsCol.add("ID");
        lsCol.add("Дата");
        lsCol.add("Артикул");
        lsCol.add("Цвет");
        lsCol.add("Кол-во");
    }
    
    List<String> lsCol = new ArrayList<>();
    List<PlanArticle> ls = new ArrayList<>();

    @Override
    public int getRowCount() {
        return ls.size();
    }

    @Override
    public String getColumnName(int column) {
        return lsCol.get(column);
    }
    
    

    @Override
    public int getColumnCount() {
        return lsCol.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return ls.get(rowIndex).getPlanarticle();
            case 1: 
                return ls.get(rowIndex).getDates();
            case 2: 
                return ls.get(rowIndex).getModel().getArticle();
            case 3: 
                return ls.get(rowIndex).getColor().getName();
            case 4: 
                return ls.get(rowIndex).getQty();    
        }
        return null;
    }
    
    public void setData(Date d1, Date d2)
    {
        ls = IOPlanArticle.getListPlanArticle(d1, d2);
        fireTableDataChanged();
    }
    
}
