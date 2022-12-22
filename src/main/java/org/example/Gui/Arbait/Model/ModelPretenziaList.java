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
public class ModelPretenziaList  extends AbstractTableModel{
    List<ZadachaKomplektovkaPretenzia> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelPretenziaList() {
        listCol.add("#");          //0
        listCol.add("Статус");     //1   
        listCol.add("Маршрут");      //2
        listCol.add("Швейный цех");  //3        
        listCol.add("Комплектовщик");  //4        
        listCol.add("ДатаС");  //5        
        listCol.add("ДатаО");  //6                         
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
                return list.get(rowIndex).getZadachakomplektovka().getRabotnik().getName();
            case 5: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDate1());
            case 6: 
                if(list.get(rowIndex).getStatus()>2)
                    return HelpClass.getPrintDate(list.get(rowIndex).getDate2());            
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
        list = IOZadachaKomplektovkaPretenzia.getListZadachaKomplektovkaPretenziaForChex();
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
    final ImageIcon s2 = new ImageIcon(getClass().getResource("/images/forward.png"));
    final ImageIcon s3 = new ImageIcon(getClass().getResource("/images/2.png"));
    final ImageIcon s4 = new ImageIcon(getClass().getResource("/images/clos.png"));
    final ImageIcon s11 = new ImageIcon(getClass().getResource("/images/block.png"));
    
    
    
    public DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
            int v = Integer.parseInt(cell.getText());                
                    switch (v) {
                        case 0:
                        case 1:
                            cell.setIcon(s1);
                            cell.setText("");                            
                            cell.setToolTipText("Редактирование");
                            break;                        
                        case 2:
                            cell.setIcon(s2);
                            cell.setText("");
                            cell.setToolTipText("Отправлена");
                            break;
                        case 3:
                            cell.setIcon(s3);
                            cell.setText("");
                            cell.setToolTipText("Принята");
                            break;    
                        case 4:
                        case 5:    
                        case 6:        
                        case 7:        
                        case 8:
                        case 9:            
                        case 10:            
                            cell.setIcon(s4);
                            cell.setText("");
                            cell.setToolTipText("Рассмотрена");
                            break;                            
                        case 11:            
                            cell.setIcon(s11);
                            cell.setText("");
                            cell.setToolTipText("Закрыта");
                            break;                                
                    }
                }
            return cell;
        }

    };
    
}
