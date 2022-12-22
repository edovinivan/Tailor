/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model;

import java.awt.Component;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.Product;
import org.example.util.IOProduct;

/**
 *
 * @author ivan
 * модель таблицы товаров
 */
public class ModelProduct extends AbstractTableModel{
    List<Product> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelProduct() {
        listCol.add("№");
        listCol.add("Название");
        listCol.add("Коэффициент");
        listCol.add("Ед.Изм.");
        listCol.add("Группа");
    }   
    
    public void setVid(int vd)
    {
        vid = vd;
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
                return list.get(rowIndex).getProduct();
            case 1: 
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getKoef().setScale(2, RoundingMode.HALF_EVEN);    
            case 3: 
                return list.get(rowIndex).getMeasure().getName();        
            case 4: 
                return list.get(rowIndex).getProductgruppa().getName();        
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOProduct.getListProduct(-1, vid);
        fireTableDataChanged();
    }
    

    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 2 || column == 3) 
                cell.setHorizontalAlignment(RIGHT);
            else
                cell.setHorizontalAlignment(LEFT);
            return cell;
        }

    };
    
    
}
