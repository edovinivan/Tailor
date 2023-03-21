/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model.model;

import java.awt.Component;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ModelOperation;
import org.example.util.IOModel;

/**
 *
 * @author ivan
 */
public class ModelOperationModel   extends AbstractTableModel{
    List<ModelOperation> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelOperationModel() {
        listCol.add("ID");
        listCol.add("№");
        listCol.add("Операция");
        listCol.add("Кол-во");        
        listCol.add("Описание");       
        listCol.add("Разряд");        
        listCol.add("Время");        
        listCol.add("Сумма");        
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
                return list.get(rowIndex).getModeloperation();
            case 1:
                return list.get(rowIndex).getNom();        
            case 2: 
                return list.get(rowIndex).getOperation().getName();
            case 3: 
                return list.get(rowIndex).getQty();
            case 4: 
                return list.get(rowIndex).getText();
            case 5: 
                return list.get(rowIndex).getRazrad().getNom();
            case 6: 
                return list.get(rowIndex).getTimes().setScale(1, RoundingMode.HALF_EVEN);
            case 7: 
                return list.get(rowIndex).getSummao().setScale(2, RoundingMode.HALF_EVEN);
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int mod)
    {
        list = IOModel.getListModelOperation(mod, -1);
        fireTableDataChanged();
    }
    
    
    // подсветка и картинки в таблицу                       
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column >= 5 || column <= 7) {
                cell.setHorizontalAlignment(RIGHT);
            }
            return cell;
        }

    };
}
