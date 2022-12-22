/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Plan.PlanArticle.Model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.MapProject;
import org.example.util.plannew.IOMapProject;

/**
 *
 * @author ivan
 */
public class ModelMapProject extends AbstractTableModel{

    public ModelMapProject() {
        colName.add("ID");
        colName.add("Статус");
        colName.add("Название");
        colName.add("Старт");
        colName.add("Окончание");        
    }

    List<MapProject> listData = new ArrayList<>();
    List<String> colName = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return listData.size();
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
                return listData.get(rowIndex).getMapproject();
            case 1: 
                return listData.get(rowIndex).getStatus();    
            case 2: 
                return listData.get(rowIndex).getName();
            case 3: 
                return listData.get(rowIndex).getStart_date();
            case 4: 
                return listData.get(rowIndex).getEnd_date();
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colName.get(column);
    }

    public void setData(LocalDate d1, LocalDate d2){
        IOMapProject iOMapProject = new IOMapProject();
        listData = iOMapProject.getListObject(
                Date.from(d1.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(d2.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                
        fireTableDataChanged();
    }
    
    
}
