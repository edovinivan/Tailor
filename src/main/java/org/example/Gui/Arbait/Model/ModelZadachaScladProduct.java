/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.awt.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaNastilProduct;
import org.example.logic.ZadachaScladProduct;
import org.example.util.IOZadacha;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 */
public class ModelZadachaScladProduct  extends AbstractTableModel{
    List<ZadachaScladProduct> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    
    public ModelZadachaScladProduct() {
        listCol.add("№");
        listCol.add("Паспорт");  
        listCol.add("Материал");  
        listCol.add("Цвет");  
        listCol.add("Ширина");  
        listCol.add("Вес");          
        listCol.add("#");  
        listCol.add("Длина");  
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
                return list.get(rowIndex).getZadachascladproduct();
            case 1: 
                return list.get(rowIndex).getScladproduct().getPasport();
            case 2: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();
            case 3: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 4: 
                return list.get(rowIndex).getScladproduct().getWidth().setScale(0, RoundingMode.HALF_EVEN).toString();
            case 5: 
                return list.get(rowIndex).getScladproduct().getVes().setScale(2, RoundingMode.HALF_EVEN).toString();
            case 6:
                return list.get(rowIndex).getScladproduct().getScladproduct();
            case 7:
                return list.get(rowIndex).getScladproduct().getLight().setScale(2, RoundingMode.HALF_EVEN).toString();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int z)
    {
        list = IOZadacha.getListZadachaScladProduct(z);
        fireTableDataChanged();
    }
    
    public void setDataForNastil(int zn)
    {
        list.clear();
        for(ZadachaNastilProduct s: IOZadachaNastil.getListZadachaNastilProduct(zn))
            list.add(s.getZadachascladproduct());
        fireTableDataChanged();
    }
    
    
    
    // подсветка и картинки в таблицу                       
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column == 5 || column == 4 || column == 7) {
                cell.setHorizontalAlignment(RIGHT);
            }
            return cell;
        }

    };
    
    /**
     * получить весь вес полотен для настила
     * @return 
     */
    public BigDecimal getAllQty()
    {
        BigDecimal qs = new BigDecimal(0);
        for(ZadachaScladProduct s: list)
            qs = qs.add(s.getScladproduct().getVes());
        return qs;
    }
    
}
