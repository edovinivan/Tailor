/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example.Gui.model.model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.Model;
import org.example.util.HelpClass;
import org.example.util.IOModel;

/**
 *
 * @author ivan
 */
public class ModelModel    extends AbstractTableModel{
    List<Model> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    
    public ModelModel() {
        listCol.add("№");
        listCol.add("Статус");
        listCol.add("№");
        listCol.add("Артикул");        
        listCol.add("Название");       
        listCol.add("Дата");        
        listCol.add("Модель");        
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
                return list.get(rowIndex).getModel();
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return rowIndex+1;    
            case 3: 
                return list.get(rowIndex).getArticle();
            case 4: 
                return list.get(rowIndex).getName();
            case 5: 
                return HelpClass.getPrintDate(list.get(rowIndex).getDates());
            case 6: 
                return list.get(rowIndex).getTipmodel().getName();                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int status, boolean all)
    {
        list = IOModel.getListModel(-1, status, all);
        fireTableDataChanged();
    }
    
    public void setData(int status, String seach, boolean all)
    {
        list = IOModel.getListModel(-1, status, seach, all);
        fireTableDataChanged();
    }
    
    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    final ImageIcon clos = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    final ImageIcon block = new ImageIcon(getClass().getResource("/org/example/images/block.png"));

    public final DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            if (column == 1) {
                switch (Integer.parseInt(cell.getText())) {
                    case 0:
                        cell.setIcon(edit);
                        cell.setText("");
                        break;
                    case 1:
                        cell.setIcon(ok);
                        cell.setText("");
                        break;
                    case 2:
                        cell.setIcon(clos);
                        cell.setText("");
                        break;    
                    case 3:
                        cell.setIcon(block);
                        cell.setText("");
                        break;        
                    
                }
            }
            return cell;
        }

    };
    
}
