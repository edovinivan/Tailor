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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.MarshrutAll;
import org.example.util.IOZadachaKomplektovka;

/**
 *
 * @author ivan
 */
public class ModelMarshrutAll  extends AbstractTableModel{
    List<MarshrutAll> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelMarshrutAll() {
        listCol.add("#");          //0
        listCol.add("Статус");     //1   
        listCol.add("Номер");      //2
        listCol.add("Артикул");      //2
        listCol.add("Дата");  
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
                return list.get(rowIndex).getZk();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getNomer();
            case 3:                 
                return list.get(rowIndex).getArticle();
            case 4: 
                return list.get(rowIndex).getDates();            
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int s)
    {
        list = IOZadachaKomplektovka.getMarshrutAllForCheh(s);
        fireTableDataChanged();
    }    
       
    // подсветка и картинки в таблицу                       
    final ImageIcon ok0 = new ImageIcon(getClass().getResource("/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/images/forw.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/images/Filled.png"));
    final ImageIcon ok3 = new ImageIcon(getClass().getResource("/images/2.png"));
    final ImageIcon ok4 = new ImageIcon(getClass().getResource("/images/clos.png"));
    
    final ImageIcon warn = new ImageIcon(getClass().getResource("/images/warning.png"));
    
    
    public DefaultTableCellRenderer jTableRenderer1 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 1) {
            int v = Integer.parseInt(cell.getText())-2;                
                    switch (v) {
                        case 0:
                            cell.setIcon(ok0);
                            cell.setText("");                            
                            cell.setToolTipText("Маршрут сформирован");
                            break;
                        case 1:
                            cell.setIcon(ok1);
                            cell.setText("");
                            cell.setToolTipText("Маршрут отправлен");
                            break;
                        case 2:
                            cell.setIcon(ok2);
                            cell.setText("");
                            cell.setToolTipText("Маршрут получен в цех");
                            break;
                        case 3:
                            cell.setIcon(ok3);
                            cell.setText("");
                            cell.setToolTipText("Маршрут выполнен");
                            break;    
                        case 4:
                            cell.setIcon(ok4);
                            cell.setText("");
                            cell.setToolTipText("Маршрут получен на складе");
                            break;                            
                    }
                }
            return cell;
        }

    };
    
    public DefaultTableCellRenderer jTableRenderer2 = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 17) 
            {
            int v = Integer.parseInt(cell.getText());                
                    switch (v) 
                    {
                        case 0:
                            cell.setIcon(null);
                            cell.setText("");                            
                            break;
                        default:
                            cell.setIcon(warn);
                            cell.setText("");                            
                            break;                                                  
                    }
                }
            return cell;
        }

    };
    
}
