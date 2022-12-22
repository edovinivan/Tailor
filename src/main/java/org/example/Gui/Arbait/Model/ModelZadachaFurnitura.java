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
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaFurnitura;
import org.example.util.IOZadachaFurnitura;

/**
 *
 * @author ivan
 */
public class ModelZadachaFurnitura  extends AbstractTableModel{
    List<ZadachaFurnitura> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelZadachaFurnitura() {
        listCol.add("№");        
        listCol.add("Паспорт");
        listCol.add("Название");
        listCol.add("Цвет");
        listCol.add("Цена");
        listCol.add("Кол-во");
        listCol.add("Остаток");
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
                return list.get(rowIndex).getZadachafurnitura();
            case 1: 
                return list.get(rowIndex).getScladproduct().getPasport();        
            case 2: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();    
            case 3: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 4: 
                return list.get(rowIndex).getScladproduct().getPrice().setScale(2, RoundingMode.HALF_EVEN);
            case 5: 
                return list.get(rowIndex).getQty().setScale(1, RoundingMode.HALF_EVEN);
            case 6: 
                return list.get(rowIndex).getScladproduct().getWidth().setScale(1, RoundingMode.HALF_EVEN);
            case 7: 
                return list.get(rowIndex).getScladproduct().getSclad().getName();
            case 8: 
                return list.get(rowIndex).getScladproduct().getDocumentjournal().getDocument().getDates();
            case 9: 
                return list.get(rowIndex).getScladproduct().getAgent().getName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    /***
     * Обновить данные    
     * @param zp
     */
    public void setData(int zp)
    {
        list = IOZadachaFurnitura.getListZadachaFurnituraForZadachaProduct(zp);
        fireTableDataChanged();
    }
    
    public void setDataForKomplektovka(int kom, int zp)
    {
        list = IOZadachaFurnitura.getListZadachaFurnituraForKomplektovka(zp, kom);
        fireTableDataChanged();
    }
    
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column >3 && column < 8)                
            {                
                cell.setHorizontalAlignment(RIGHT);
            }
            return cell;
        }

    };
    
}
