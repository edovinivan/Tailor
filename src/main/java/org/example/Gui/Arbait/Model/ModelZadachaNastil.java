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
import org.example.logic.ZadachaNastil;
import org.example.util.IOZadachaNastil;

/**
 *
 * @author ivan
 */
public class ModelZadachaNastil   extends AbstractTableModel{
    List<ZadachaNastil> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    public ModelZadachaNastil() {
        listCol.add("#");
        listCol.add("Статус");        
        listCol.add("Номер");  
        listCol.add("Тип настила");  
        listCol.add("Тип настилания");          
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
                return list.get(rowIndex).getZadachanastil();
            case 1: 
                return list.get(rowIndex).getStatus();    
            case 2: 
                return list.get(rowIndex).getNomer();
            case 3: 
                return list.get(rowIndex).getTipnastila().getName();
            case 4: 
                return list.get(rowIndex).getTipnastilania().getName();
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int z)
    {
        list = IOZadachaNastil.getListZadachaNastil(z, -1);
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
    final ImageIcon ok0 = new ImageIcon(getClass().getResource("/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/images/2.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/images/bac.png"));
    final ImageIcon ok3 = new ImageIcon(getClass().getResource("/images/clos.png"));
    
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
                        case 2:
                            cell.setIcon(ok2);
                            cell.setText("");
                            break;
                        case 3:
                        case 4:
                            cell.setIcon(ok3);
                            cell.setText("");
                            break;    
                    }
                }
            return cell;
        }

    };
    
}
