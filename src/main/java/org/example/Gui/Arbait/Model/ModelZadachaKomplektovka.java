/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaKomplektovka;
import org.example.util.IOZadachaKomplektovka;

/**
 *
 * @author ivan
 * модель таблицы для показа комплектовок задачи
 */
public class ModelZadachaKomplektovka  extends AbstractTableModel{
    List<ZadachaKomplektovka> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelZadachaKomplektovka() {
        listCol.add("#");
        listCol.add("Статус");        
        listCol.add("Задача");
        listCol.add("Номер комплектовки");  
        listCol.add("Артикул");  
        listCol.add("Дата");  
        listCol.add("Швейный цех");          
        listCol.add("Комплектовщик");          
        listCol.add("Изделий");          
        listCol.add("М.Хранения");          
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
                return list.get(rowIndex).getZadachakomplektovka();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getZadacha().getNomer();
            case 3: 
                return list.get(rowIndex).getNomer();
            case 4: 
                return list.get(rowIndex).getModel().getArticle();
            case 5: 
                return list.get(rowIndex).getDates();
            case 6: 
                return list.get(rowIndex).getChek().getName();
            case 7: 
                return list.get(rowIndex).getRabotnik().getName();    
            case 8: 
                return list.get(rowIndex).getCounts();
            case 9: 
                return list.get(rowIndex).getSclad().getName();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int z)
    {
        list = IOZadachaKomplektovka.getListZadachaKomplektovka(z, -1);
        fireTableDataChanged();
    }
    
    public void setDataForOperator(int o, int hand, Date d1, Date d2, boolean vall)
    {
        list = IOZadachaKomplektovka.getListZadachaKomplektovkaForOperator(o, -1, hand, d1, d2, vall);
        fireTableDataChanged();
    }
    
    public void setDataForKomplektovkaFurnitura()
    {
        list = IOZadachaKomplektovka.getListZadachaKomplektovkaForFurnitura();
        fireTableDataChanged();
    }
    
    public void setDataForScladKroi()
    {
        list = IOZadachaKomplektovka.getMarshrutForScladKroi();
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
    
    
    
    // подсветка и картинки в таблицу                       
    final ImageIcon ok0 = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    
    public DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
            int v = Integer.parseInt(cell.getText());                
                    switch (v) {
                        case 0:
                            cell.setIcon(ok0);
                            cell.setText("");                            
                            break;
                        case 1:
                            cell.setIcon(ok1);
                            cell.setText("");                            
                            break;    
                        default:
                            cell.setIcon(ok2);
                            cell.setText("");
                            break;                        
                    }
                }
            return cell;
        }

    };

    
}
