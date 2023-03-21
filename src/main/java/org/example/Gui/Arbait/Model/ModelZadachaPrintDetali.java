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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import org.example.logic.ZadachaPrintDetali;
import org.example.util.HelpClass;
import org.example.util.IOZadachaPrintDetali;

/**
 *
 * @author ivan
 */
public class ModelZadachaPrintDetali extends AbstractTableModel{
    List<ZadachaPrintDetali> list = new ArrayList<>();
    List<String> listCol = new ArrayList<>();

    int vid;
    
    public ModelZadachaPrintDetali(int v) {
        vid = v;
        listCol.add("№");        
        listCol.add("Статус");  
        listCol.add("Артикул");
        listCol.add("Деталь");
        listCol.add("Дата");  
        listCol.add("Кол-воР");
        listCol.add("Цена");
        listCol.add("Кол-во");
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
                return list.get(rowIndex).getZadachaprintdetali();            
            case 1: 
                return list.get(rowIndex).getStatus();
            case 2: 
                return list.get(rowIndex).getZadacha().getModel().getArticle();        
            case 3: 
                return list.get(rowIndex).getPrintdetali().getName();
            case 4: 
                return HelpClass.getPrintDate(list.get(rowIndex).getZadacha().getDates());
            case 5: 
                return list.get(rowIndex).getQty();
            case 6: 
                return list.get(rowIndex).getPrice().setScale(2, RoundingMode.HALF_UP);
            case 7: 
                return list.get(rowIndex).getQtyend();    
                
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return listCol.get(column);
    }
    
    public void setData(int statusM)
    {
        list = IOZadachaPrintDetali.getListZadachaPrintDetali(-1, vid, statusM);
        fireTableDataChanged();
    }
    
   
    
    // подсветка и картинки в таблицу                       
    final ImageIcon edit = new ImageIcon(getClass().getResource("/org/example/images/1.png"));
    final ImageIcon ok1 = new ImageIcon(getClass().getResource("/org/example/images/2.png"));
    final ImageIcon ok2 = new ImageIcon(getClass().getResource("/org/example/images/clos.png"));
    public DefaultTableCellRenderer jTableRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int v = Integer.parseInt(cell.getText());
                if (column == 1) {
                    switch (v) {
                        case 0:
                            cell.setIcon(edit);
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
                    }
                }
            return cell;
        }

    };
    
}
