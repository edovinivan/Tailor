/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.Rabotnik;
import org.example.util.IORabotnik;

/**
 *
 * @author ivan
 */
public class ModelRabotnik  extends AbstractTableModel{
    List<Rabotnik> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelRabotnik() {
        listCol.add("№");
        listCol.add("Название");        
        listCol.add("Группа");
        listCol.add("Коэффициент");        
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
                return list.get(rowIndex).getRabotnik();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getRabotnikgruppa().getName();
            case 3: 
                return list.get(rowIndex).getKoef().setScale(2, RoundingMode.HALF_EVEN);    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IORabotnik.getListRabotnik(-1);
        fireTableDataChanged();
    }
    
    /**
     * Получить работников из группы
     * @param rg 
     */
    public void setData(int rg)
    {
        list = IORabotnik.getListRabotnikIzGruppa(rg);
        fireTableDataChanged();
    }
    
}
