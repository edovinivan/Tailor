/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.Arbait.Model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import static javax.swing.SwingConstants.LEFT;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaKomplektovkaPretenzia;
import org.example.util.HelpClass;
import org.example.util.IOZadachaKomplektovkaPretenzia;

/**
 *
 * @author ivan
 */
public class ModelDopMarshrut extends AbstractTableModel{
    List<ZadachaKomplektovkaPretenzia> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelDopMarshrut() {
        listCol.add("#");          //0
        listCol.add("Статус");     //1   
        listCol.add("Маршрут");      //2
        listCol.add("Швейный цех");  //3    
        listCol.add("Кол. Претензия");  //4        
        listCol.add("Кол. Из цеха");  //4        
        listCol.add("Кол. На склад");  //4        
        listCol.add("Д_ВЦех");  //5        
        listCol.add("Д_ИзЦеха");  //6        
        listCol.add("Д_Склад");  //7                         
    }   

        
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return listCol.size();
    }

    long d;
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0: 
                return list.get(rowIndex).getZkpretenzia();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getZadachakomplektovka().getNomer();
            case 3: 
                return list.get(rowIndex).getZadachakomplektovka().getChek().getName();
            case 4: 
                return list.get(rowIndex).getCounts();
            case 5: 
                return list.get(rowIndex).getQty();
            case 6: 
                return list.get(rowIndex).getScladqty();    
            case 7: 
                if(list.get(rowIndex).getStatus()>4)
                    return HelpClass.getPrintDate(list.get(rowIndex).getDateget());            
                else
                    return "";                
            case 8: 
                if(list.get(rowIndex).getStatus()>5)
                    return HelpClass.getPrintDate(list.get(rowIndex).getDatereturn());            
                else
                    return "";
            case 9: 
                if(list.get(rowIndex).getStatus()>6)
                    return HelpClass.getPrintDate(list.get(rowIndex).getDatesclad());            
                else
                    return "";    
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData()
    {
        list = IOZadachaKomplektovkaPretenzia.getListZadachaKomplektovkaPretenziaForChex1();
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
    final ImageIcon s1 = new ImageIcon(getClass().getResource("/images/1.png"));
    final ImageIcon s2 = new ImageIcon(getClass().getResource("/images/Filled.png"));
    final ImageIcon s3 = new ImageIcon(getClass().getResource("/images/2.png"));
    final ImageIcon s4 = new ImageIcon(getClass().getResource("/images/clos.png"));
    
    
    
    public DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
            int v = Integer.parseInt(cell.getText());                
                    switch (v) {
                        case 4:
                            cell.setIcon(s1);
                            cell.setText("");                            
                            cell.setToolTipText("Создан");
                            break;                        
                        case 5:
                            cell.setIcon(s2);
                            cell.setText("");
                            cell.setToolTipText("Принят в цех");
                            break;
                        case 6:
                            cell.setIcon(s3);
                            cell.setText("");
                            cell.setToolTipText("Отправлен из цеха");
                            break;    
                        case 10:
                            cell.setIcon(s4);
                            cell.setText("");
                            cell.setToolTipText("Принят на склад");
                            break;                            
                    }
                }
            return cell;
        }

    };
    
}
