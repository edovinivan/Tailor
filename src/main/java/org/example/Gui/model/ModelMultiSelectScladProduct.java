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
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ScladProduct;
import org.example.util.IOScladProduct;

/**
 *
 * @author ivan
 */
public class ModelMultiSelectScladProduct  extends AbstractTableModel{
    List<ScladProduct> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelMultiSelectScladProduct () {
        listCol.add("№");        
        listCol.add("Sel");        
        listCol.add("Паспорт");
        listCol.add("Название");
        listCol.add("Цвет");
        listCol.add("Цена");
        listCol.add("Ширина");
        listCol.add("Длина");
        listCol.add("Вес");
        listCol.add("МестоХранения");
        listCol.add("Дата поступления");
        listCol.add("Поставщик");
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
                return list.get(rowIndex).getScladproduct();
            case 1: 
                return list.get(rowIndex).getStatus()==3;    
            case 2: 
                return list.get(rowIndex).getPasport();        
            case 3: 
                return list.get(rowIndex).getProduct().getName();    
            case 4: 
                return list.get(rowIndex).getColor().getName();
            case 5: 
                return list.get(rowIndex).getPrice().setScale(2, RoundingMode.HALF_UP);
            case 6: 
                return list.get(rowIndex).getStatus()==0?list.get(rowIndex).getWidthtemp():list.get(rowIndex).getWidth().setScale(0, RoundingMode.HALF_EVEN);
            case 7: 
                return list.get(rowIndex).getStatus()==0?list.get(rowIndex).getLighttemp().setScale(2, RoundingMode.HALF_UP):list.get(rowIndex).getLight().setScale(2, RoundingMode.HALF_UP);
            case 8: 
                return list.get(rowIndex).getVes().setScale(2, RoundingMode.HALF_UP);
            case 9: 
                return list.get(rowIndex).getSclad().getName();
            case 10: 
                return list.get(rowIndex).getDocumentjournal().getDocument().getDates();
            case 11: 
                return list.get(rowIndex).getDocumentjournal().getDocument().getAgent().getName();    
            
            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    /***
     * Обновить данные
     * @param status     
     * @param sname     
     */
    public void setData(int status, String sname)
    {
        list = IOScladProduct.getListScladProduct(status, 1, 0, 0, 0, 0, 0, sname);
        fireTableDataChanged();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        list.get(rowIndex).setStatus(((Boolean)aValue)?3:1);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex==1;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==1)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }   
    
    
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column >3 && column < 9)                
            {                
                cell.setHorizontalAlignment(RIGHT);
            }
            return cell;
        }

    };
    
    
    public List<ScladProduct> getSelectList()
    {
        List<ScladProduct> ls = new ArrayList<>();
        for(ScladProduct s: list)
            if(s.getStatus()==3)
                ls.add(s);
        return ls;
    }
    
    
}
