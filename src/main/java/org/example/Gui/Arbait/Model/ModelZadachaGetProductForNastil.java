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
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaNastil;
import org.example.logic.ZadachaNastilProduct;
import org.example.logic.ZadachaScladProduct;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 * модель для выбора товаров для настила
 */
public class ModelZadachaGetProductForNastil  extends AbstractTableModel{
    List<ZadachaScladProduct> list = new ArrayList<>();
    List<ZadachaScladProduct> listZ = new ArrayList<>();
    List<String> listCol = new ArrayList<>();
    int zn;
    
    public ModelZadachaGetProductForNastil(int z) {
        listCol.add("№");
        listCol.add("#");
        listCol.add("Паспорт");  
        listCol.add("Материал");  
        listCol.add("Цвет");  
        listCol.add("Ширина");  
        listCol.add("Вес");  
        listCol.add("Длина");  
        zn = z;
    }   

        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==1)
            return Boolean.class;
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(columnIndex == 1)
        {
            if((boolean)aValue)
            {
                ZadachaNastilProduct z = new ZadachaNastilProduct();
                z.setZadachascladproduct(list.get(rowIndex));
                z.setZadachanastilproduct(0);
                z.setZadachanastil(new ZadachaNastil(zn));
                IOZadachaNastil.setZadachaNastilProduct(z);    
                
                // получим все товары для настила
                getZSPN();
            }
            else
            {
                IOZadachaNastil.delZadachaNastilProduct(zn, list.get(rowIndex).getZadachascladproduct());
                // получим все товары для настила
                getZSPN();
                //fireTableDataChanged();
            }
            //fireTableDataChanged();
        }
    }    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getZadachascladproduct();
            case 1:
            {
                for(ZadachaScladProduct sp: listZ)
                {
                    if(Objects.equals(sp.getZadachascladproduct(), list.get(rowIndex).getZadachascladproduct()))
                        return true;
                }
                return false;
            }
            case 2: 
                return list.get(rowIndex).getScladproduct().getPasport();
            case 3: 
                return list.get(rowIndex).getScladproduct().getProduct().getName();
            case 4: 
                return list.get(rowIndex).getScladproduct().getColor().getName();
            case 5: 
                return list.get(rowIndex).getScladproduct().getWidth().setScale(0, RoundingMode.HALF_EVEN);
            case 6: 
                return list.get(rowIndex).getScladproduct().getVes().setScale(2, RoundingMode.HALF_EVEN);
            case 7: 
                return list.get(rowIndex).getScladproduct().getLight().setScale(2, RoundingMode.HALF_EVEN);
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    /**
     * Получить товары которые выбраны для данной задачи
     * @param z - номер задачи
     */
    public void setData(int z)
    {
        list =  IOZadachaNastil.getListZadachaScladProduct(z);
        getZSPN();        
        // добавим те которые уже выбрали
        for(ZadachaScladProduct s: listZ)
            list.add(s);
        fireTableDataChanged();
    }
    
    /**
     * получим товары для данного настила
     */
    public void getZSPN()
    {
        listZ.clear();
        for(ZadachaNastilProduct s: IOZadachaNastil.getListZadachaNastilProduct(zn))
            listZ.add(s.getZadachascladproduct());
    }
    
    
    
    // подсветка и картинки в таблицу                       
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setHorizontalAlignment(LEFT);
            if (column == 5 || column == 6 || column == 7) {
                cell.setHorizontalAlignment(RIGHT);
            }
            return cell;
        }

    };
    
}
    

