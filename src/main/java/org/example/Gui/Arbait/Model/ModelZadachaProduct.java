/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.awt.Component;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaProduct;
import org.example.util.IOZadacha;

/**
 *
 * @author ivan
 */
public class ModelZadachaProduct   extends AbstractTableModel{
    List<ZadachaProduct> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelZadachaProduct(int v) {
        vid = v;
        listCol.add("№");
        listCol.add("Материал");  
        listCol.add("Цвет");  
        listCol.add("Кол-во на 1");  
        listCol.add("Кол-во");  
        listCol.add("Набрали");  
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
                return list.get(rowIndex).getZadachaproduct();
            case 1: 
                return list.get(rowIndex).getModelproduct().getProduct().getName();
            case 2: 
                return list.get(rowIndex).getModelproduct().getColor().getName();    
            case 3: 
                return list.get(rowIndex).getQty1().setScale(2, RoundingMode.HALF_EVEN);
            case 4: 
                return list.get(rowIndex).getQty().setScale(2, RoundingMode.HALF_EVEN);
            case 5: 
                return list.get(rowIndex).getAll_qty().setScale(2, RoundingMode.HALF_EVEN);
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int z)
    {
        list = IOZadacha.getListZadachaProduct(z, 0, vid);
        fireTableDataChanged();
    }
    
    
    
    // подсветка и картинки в таблицу                       
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column == 3 || column == 4 || column == 5) {
                cell.setHorizontalAlignment(RIGHT);
            }
            return cell;
        }

    };
    
}
