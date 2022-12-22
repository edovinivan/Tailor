/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.example.logic.RabotnikOperation;
import org.example.logic.ZadachaKomplektovka;

/**
 *
 * @author ivan
 */
public class ModelMarshrutWork  extends AbstractTableModel{
    List<RabotnikOperation> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelMarshrutWork() {
        listCol.add("#");
        listCol.add("Операция");
        listCol.add("По маршруту");
        listCol.add("Выполненно");
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
                return list.get(rowIndex);
        }
        return null;
    }
    
    
    
}


