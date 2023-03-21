/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Analit;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.plan.PZakupkiJournal;
import org.example.util.plan.IOZakupki;

/**
 *
 * @author ivan
 */
public class ModelZakupkiJournal  extends AbstractTableModel{
    
    List<String> listCol = new ArrayList<>();
    List<PZakupkiJournal> list = new ArrayList<>();
    

    public ModelZakupkiJournal() {
        listCol.add("ID");                
        listCol.add("Дата");          
        listCol.add("Артикул");          
        listCol.add("Цвет");          
        listCol.add("Кол-во");
        listCol.add("PM");
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
                return list.get(rowIndex).getPzakupkijournal();
            case 1: 
                return list.get(rowIndex).getPmodelplan().getDates();
            case 2: 
                return list.get(rowIndex).getPmodelplan().getModel().getArticle();
            case 3: 
                return list.get(rowIndex).getPmodelplan().getColor().getName();
            case 4: 
                return list.get(rowIndex).getPmodelplan().getSumqty();
            case 5: 
                return list.get(rowIndex).getPmodelplan().getPmodelplan();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    
    public void setData(int z)
    {
        list = IOZakupki.getListPZakupkiJournal(z);
        fireTableDataChanged();
    }
    
}
